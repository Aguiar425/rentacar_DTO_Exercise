package academy.mindswap.rentacar.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("Car not found");
    }
}
