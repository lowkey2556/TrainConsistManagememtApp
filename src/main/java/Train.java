import java.util.Arrays;

public class Train {

    static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==============================================");
        System.out.println();

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();

        sortBogieNames(bogieNames);

        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();
        System.out.println("UC17 sorting completed...");
    }
}