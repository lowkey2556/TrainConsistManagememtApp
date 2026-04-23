import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        Train.GoodsBogie bogie = new Train.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        Train.GoodsBogie bogie = new Train.GoodsBogie("Rectangular");

        Train.CargoSafetyException exception = assertThrows(
                Train.CargoSafetyException.class,
                () -> bogie.assignCargo("Petroleum")
        );

        assertEquals("Unsafe cargo assignment!", exception.getMessage());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Train.GoodsBogie bogie = new Train.GoodsBogie("Rectangular");

        assertThrows(
                Train.CargoSafetyException.class,
                () -> bogie.assignCargo("Petroleum")
        );

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        Train.GoodsBogie unsafeBogie = new Train.GoodsBogie("Rectangular");
        Train.GoodsBogie safeBogie = new Train.GoodsBogie("Cylindrical");

        assertThrows(
                Train.CargoSafetyException.class,
                () -> unsafeBogie.assignCargo("Petroleum")
        );

        safeBogie.assignCargo("Coal");
        assertEquals("Coal", safeBogie.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        Train.GoodsBogie bogie = new Train.GoodsBogie("Rectangular");

        assertThrows(
                Train.CargoSafetyException.class,
                () -> bogie.assignCargo("Petroleum")
        );
    }
}