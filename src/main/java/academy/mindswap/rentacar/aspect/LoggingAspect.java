package academy.mindswap.rentacar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution( * academy.mindswap.rentacar.controller.*.*(..))")
    public void logBeforeAdd(JoinPoint joinPoint){
        logger.info("Before " + joinPoint.getSignature().getName() + " method call");
    }
}
