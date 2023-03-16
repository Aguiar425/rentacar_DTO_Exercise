package academy.mindswap.rentacar.config;

import academy.mindswap.rentacar.repository.TokenRepository;
import academy.mindswap.rentacar.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            Boolean isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Boolean isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                String path = request.getRequestURI().substring(request.getContextPath().length());
                if (adminPrivileges(request, response, filterChain, userDetails, path)) {
                    return;
                } else if (employeePrivileges(request, response, filterChain, userDetails, path)) {
                    return;
                } else if (clientPrivileges(request, response, filterChain, userDetails, path)) {
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    //todo clients should only be able to see cars and their own rentals
    private static boolean clientPrivileges(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, UserDetails userDetails, String path) throws IOException, ServletException {
        if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CLIENT"))) {
            if (path.startsWith("/car/all") || path.startsWith("/rental/all")) {
                filterChain.doFilter(request, response);
                return true;
            } else {
                boolean clientLimits = path.startsWith("/car") || path.startsWith("/rental") || path.startsWith("/admin") || path.startsWith("/user/all");
                if (clientLimits) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().write("Access denied");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean employeePrivileges(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, UserDetails userDetails, String path) throws IOException, ServletException {
        if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE"))) {
            if (path.startsWith("/car") || path.startsWith("/rental")) {
                filterChain.doFilter(request, response);
                return true;
            } else if (path.startsWith("/admin")) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("Access denied");
                return true;
            }
        }
        return false;
    }

    private static boolean adminPrivileges(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, UserDetails userDetails, String path) throws IOException, ServletException {
        if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            if (path.startsWith("/admin") || path.startsWith("/car") || path.startsWith("/rental")) {
                filterChain.doFilter(request, response);
                return true;
            }
        }
        return false;
    }
}