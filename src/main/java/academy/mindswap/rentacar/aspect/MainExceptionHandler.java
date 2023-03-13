package academy.mindswap.rentacar.aspect;

import academy.mindswap.rentacar.exceptions.CarNotFoundException;
import academy.mindswap.rentacar.exceptions.RentalNotFoundException;
import academy.mindswap.rentacar.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Component
@ControllerAdvice
public class MainExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, NumberFormatException.class, ArithmeticException.class,
            CarNotFoundException.class, RentalNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<String> handleDivisionByZero(Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unknown Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
    }
}
