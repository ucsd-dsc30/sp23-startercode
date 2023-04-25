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
    ValuePassenger yunyi;
    LocalDate date = LocalDate.now();



    @BeforeEach
    public void setup() throws OperationDeniedException {
        yunyi = new ValuePassenger("Yunyi", "Tutor");
    }

    @Test
    public void testValuePassengerThrowsIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValuePassenger yunyi = new ValuePassenger("Yunyi", null);
        });
    }


}
