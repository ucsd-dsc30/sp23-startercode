import java.util.ArrayList;

public class ShareableRide implements RideScheduler{

    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private final int CARPOOL_LIMIT = 5;

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public ShareableRide(){
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


    public boolean addPassenger(Passenger p) throws OperationDeniedException {
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
