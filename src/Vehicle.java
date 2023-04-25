/*
  Name: Your Name
  PID:  A12345678
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * TODO
 * @author TODO
 * @since  TODO
 */

public abstract class Vehicle {

    private LocalDate date;
    private final String vehicle;
    protected final ArrayList<Passenger> currentPassengers;
    protected final ArrayList<String> passengerNames;
    protected int vehicleID;

    public Vehicle(String VehicleName) {
        this.date = LocalDate.now();
        /*TODO*/
    }

    public LocalDate getDate(){
        return this.date;
    }

    public String getVehicleName(){
        /*TODO*/
        return null;
    }

    public ArrayList<Passenger> getCurrentPassengers(){
        /*TODO*/
        return null;
    }

    public Integer getVehicleID() {
        /*TODO*/
        return null;
    }

    public abstract boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException;

    public abstract String getVehicleInfo();
}
