import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

public class test {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 80),
                new Bogie("D", 40)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : getBogies()) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : getBogies()) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        getBogies().stream().filter(b -> b.capacity > 60).toList();
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("X", i % 100));
        }

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertFalse(result.isEmpty());
    }
}