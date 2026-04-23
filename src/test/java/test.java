package java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws Train.InvalidCapacityException {
        Train.PassengerBogie bogie =
                new Train.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie);
        assertEquals("Sleeper", bogie.getBogieType());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Train.InvalidCapacityException exception =
                assertThrows(
                        Train.InvalidCapacityException.class,
                        () -> new Train.PassengerBogie("General", -10)
                );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Train.InvalidCapacityException exception =
                assertThrows(
                        Train.InvalidCapacityException.class,
                        () -> new Train.PassengerBogie("General", 0)
                );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Train.InvalidCapacityException exception =
                assertThrows(
                        Train.InvalidCapacityException.class,
                        () -> new Train.PassengerBogie("AC", 0)
                );

        assertTrue(exception.getMessage().contains("greater than zero"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Train.InvalidCapacityException {
        Train.PassengerBogie bogie =
                new Train.PassengerBogie("AC 3 Tier", 64);

        assertEquals("AC 3 Tier", bogie.getBogieType());
        assertEquals(64, bogie.getCapacity());
        assertEquals("AC 3 Tier -> 64", bogie.toString());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Train.InvalidCapacityException {
        Train.PassengerBogie bogie1 =
                new Train.PassengerBogie("Sleeper", 72);

        Train.PassengerBogie bogie2 =
                new Train.PassengerBogie("Chair Car", 90);

        Train.PassengerBogie bogie3 =
                new Train.PassengerBogie("AC First Class", 24);

        assertEquals(72, bogie1.getCapacity());
        assertEquals(90, bogie2.getCapacity());
        assertEquals(24, bogie3.getCapacity());
    }
}