package academy.mindswap.rentacar.exceptions;

public class CarNotFoundException extends Exception{
    public CarNotFoundException() {
        super("Car not found");
    }
}
