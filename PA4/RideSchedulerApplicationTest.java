/*
  Name: Your Name
  PID:  A12345678
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * TODO
 * @author TODO
 * @since  TODO
 */
public class RideSchedulerApplicationTest {
    private final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    private static final String INVALID_INPUT =
            "The input vehicle is not a premium vehicle.";
    protected static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    ValuePassenger yunyi, marina, brian, viren, jad, lebron, mike, kobe;
    StandardPassenger steven, muchan, quentin, saathvik;
    PremiumVehicle pv1,pv2,pv3;
    EconomyVehicle ev1,ev2,ev3;
    StandardRide sdr1;
    ShareableRide shr1;
    LocalDate date = LocalDate.now();



    @BeforeEach
    public void setup() throws OperationDeniedException {
        yunyi = new ValuePassenger("Yunyi", "Tutor");
        marina = new ValuePassenger("Marina", "Instructor");
        brian = new ValuePassenger("Brian", "Tutor");
        viren = new ValuePassenger("Viren", "Tutor");
        jad = new ValuePassenger("Jad", "Tutor");
        lebron = new ValuePassenger("LeBron", "Athlete");
        mike = new ValuePassenger("Mike", "Athlete");
        kobe = new ValuePassenger("Kobe", "Athlete");
        steven = new StandardPassenger("Steven", "Tutor");
        muchan = new StandardPassenger("Muchan", "Tutor");
        quentin = new StandardPassenger("Quentin", "Tutor");
        saathvik = new StandardPassenger("Saathvik", "Tutor");
        pv1 = new PremiumVehicle("bmw01");
        pv2 = new PremiumVehicle("AUDIR8");
        pv3 = new PremiumVehicle("Mercedes");
        ev1 = new EconomyVehicle("civic");
        ev2 = new EconomyVehicle("niSSAn");
        ev3 = new EconomyVehicle("dodGe");
        sdr1 = new StandardRide();
        shr1 = new ShareableRide();
    }

    @Test
    public void TestNewID() {
        System.out.println(yunyi.getPassengerID());
        System.out.println(saathvik.getPassengerID());
        System.out.println(pv1.getVehicleID());
        System.out.println(ev1.getVehicleID());
    }

    @Test
    public void TestStandardRide() throws OperationDeniedException {
        sdr1.addPassenger(yunyi);
        sdr1.addPassenger(marina);
        sdr1.addPassenger(brian);
        sdr1.addPassenger(steven);
        sdr1.addPassenger(muchan);
        sdr1.addPassenger(quentin);
        sdr1.addVehicle(ev1);
        sdr1.addVehicle(ev2);
        sdr1.addVehicle(ev3);
        sdr1.addVehicle(pv1);
        sdr1.addVehicle(pv2);
        sdr1.addVehicle(pv3);
        sdr1.assignPassengerToVehicle();
        System.out.println(sdr1.getRecords());
    }

    @Test
    public void TestStandardRideThrowsODE(){
        try {
            sdr1.addPassenger(yunyi);
            sdr1.addPassenger(muchan);
            sdr1.addVehicle(ev1);
            sdr1.assignPassengerToVehicle();
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(MISMATCH_MSG, ode.getMessage());
        }
    }

    @Test
    public void TestStandardRideThrowsODE2(){
        try {
            StandardRide sdr2 = new StandardRide();
            sdr2.addPassenger(yunyi);
            sdr2.addPassenger(muchan);
            sdr2.addVehicle(pv1);
            sdr2.addVehicle(pv2);
            sdr2.assignPassengerToVehicle();
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            System.out.println(ode.getMessage());
            assertEquals(INVALID_ACTION, ode.getMessage());
        }
    }

    @Test
    public void TestShareableRideThrowsODE(){
        try {
            shr1.addPassenger(steven);
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(DENIED_PASSENGER_GROUP, ode.getMessage());
        }
    }

    @Test
    public void TestShareableRideThrowsODE2(){
        try {
            shr1.addPassenger(yunyi);
            shr1.addPassenger(marina);
            shr1.addPassenger(brian);
            shr1.addPassenger(jad);
            shr1.addPassenger(viren);
            shr1.addPassenger(lebron);
            shr1.addPassenger(mike);
            shr1.addPassenger(kobe);
            shr1.addVehicle(pv1);
            shr1.assignPassengerToVehicle();
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_ACTION, ode.getMessage());
        }
    }

    @Test
    public void TestShareableRide() throws OperationDeniedException {
        shr1.addPassenger(yunyi);
        shr1.addPassenger(marina);
        shr1.addPassenger(brian);
        shr1.addPassenger(jad);
        shr1.addPassenger(viren);
        shr1.addPassenger(lebron);
        shr1.addPassenger(mike);
        shr1.addPassenger(kobe);
        shr1.addVehicle(pv1);
        shr1.addVehicle(pv2);
        shr1.assignPassengerToVehicle();
        System.out.println(shr1.getRecords());
    }


    @Test
    public void TestVehicle() throws OperationDeniedException {
        assertEquals(Integer.valueOf(1), pv1.getVehicleID());
        assertEquals(Integer.valueOf(0), ev1.getVehicleID());

        assertEquals("bmw01", pv1.getVehicleName());

        pv1.addPassengerToVehicle(yunyi);
        pv1.addPassengerToVehicle(brian);
        assertEquals(false, pv1.addPassengerToVehicle(yunyi));
        System.out.println(pv1.getVehicleInfo());

        ev1.addPassengerToVehicle(steven);
        ev1.addPassengerToVehicle(yunyi);
        ev1.addPassengerToVehicle(brian);
        System.out.println(ev1.getVehicleInfo());
    }

    @Test
    public void TestPremiumVehicleThrowsODE1(){
        try {
            PremiumVehicle pv_test = new PremiumVehicle("volvo");
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_INPUT, ode.getMessage());
        }
    }

    @Test
    public void TestPremiumVehicleThrowsODE2(){
        try {
            pv1.addPassengerToVehicle(steven);
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(DENIED_PASSENGER_GROUP, ode.getMessage());
        }
    }

    @Test
    public void testValuePassengerThrowsIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValuePassenger yunyi = new ValuePassenger("Yunyi", null);
        });
    }

    @Test
    public void testValuePassenger(){
        assertEquals("Tutor", yunyi.displayBio());
        assertEquals("<Value Passenger> Yunyi", yunyi.displayName());
        yunyi.setBio("DSC Tutor");
        assertEquals("DSC Tutor", yunyi.displayBio());
        yunyi.setCustomTitle("UCSD Senior");
        assertEquals("<UCSD Senior> Yunyi", yunyi.displayName());
        assertEquals(Integer.valueOf(1), yunyi.getPassengerID());
    }


}
