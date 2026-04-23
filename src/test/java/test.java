import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Train.linearSearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(Train.linearSearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Train.linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Train.linearSearch(bogieIds, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(Train.linearSearch(bogieIds, "BG101"));
    }
}