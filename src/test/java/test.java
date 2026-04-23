import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> Train.searchBogie(bogieIds, "BG101")
        );

        assertEquals("No bogies available in train. Cannot perform search.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};

        assertDoesNotThrow(() -> Train.searchBogie(bogieIds, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(Train.searchBogie(bogieIds, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertFalse(Train.searchBogie(bogieIds, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};

        assertTrue(Train.searchBogie(bogieIds, "BG101"));
    }
}