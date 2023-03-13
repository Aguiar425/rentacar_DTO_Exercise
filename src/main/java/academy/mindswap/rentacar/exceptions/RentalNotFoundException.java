package academy.mindswap.rentacar.exceptions;

public class RentalNotFoundException extends Exception {
    public RentalNotFoundException() {
        super("Rental not found");
    }
}
