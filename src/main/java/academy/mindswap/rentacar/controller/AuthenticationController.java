package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.auth.AuthenticationRequest;
import academy.mindswap.rentacar.auth.AuthenticationResponse;
import academy.mindswap.rentacar.service.AuthenticationService;
import academy.mindswap.rentacar.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/adminRegister")
  public ResponseEntity<AuthenticationResponse> adminRegister(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.adminRegister(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}
