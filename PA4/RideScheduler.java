import java.util.ArrayList;

public interface RideScheduler {
    ArrayList<Vehicle> getVehicles();
    ArrayList<Passenger> getPassengers();
    boolean addPassenger(Passenger p) throws OperationDeniedException;
    boolean addVehicle(Vehicle v);
    void assignPassengerToVehicle() throws OperationDeniedException;
    ArrayList<String> getRecords();
}
