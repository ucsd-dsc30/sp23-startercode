import java.util.ArrayList;

public class StandardRide implements RideScheduler{

    private final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public StandardRide(){
        /*TODO*/
    }


    public ArrayList<Vehicle> getVehicles() {
        /*TODO*/
        return null;
    }


    public ArrayList<Passenger> getPassengers() {
        /*TODO*/
        return null;
    }


    public boolean addPassenger(Passenger p) {
        /*TODO*/
        return false;
    }

    public boolean addVehicle(Vehicle v) {
        /*TODO*/
        return false;
    }

    public void assignPassengerToVehicle() throws OperationDeniedException {
        /*TODO*/
    }


    public ArrayList<String> getRecords() {
        /*TODO*/
        return null;
    }
}
