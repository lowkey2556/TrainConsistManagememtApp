import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class test {
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 100)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 10)
                .toList();

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = new ArrayList<Bogie>().stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        original.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(copy.size(), original.size());
    }
}