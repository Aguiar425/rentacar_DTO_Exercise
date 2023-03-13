package academy.mindswap.rentacar.exceptions;

public class RentalNotFoundException extends RuntimeException {
    public RentalNotFoundException() {
        super("Rental not found");
    }
}
