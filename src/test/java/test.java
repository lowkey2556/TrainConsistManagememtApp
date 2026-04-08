import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
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
                new Bogie("Sleeper", 70)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = getSampleBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = getSampleBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = List.of(new Bogie("Sleeper", 50));

        int total = list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(50, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = new ArrayList<Bogie>().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Integer> capacities = getSampleBogies().stream()
                .map(b -> b.capacity)
                .toList();

        assertTrue(capacities.contains(72));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int total = getSampleBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(72 + 56 + 24 + 70, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        int sizeBefore = original.size();

        original.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(sizeBefore, original.size());
    }
}