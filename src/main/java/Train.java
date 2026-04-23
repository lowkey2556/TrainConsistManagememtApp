public class Train {

    static boolean searchBogie(String[] bogieIds, String searchId) {
        // FAIL-FAST VALIDATION
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // SEARCH LOGIC
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("==========================================");
        System.out.println();

        // Create bogie array (empty train scenario)
        String[] bogieIds = {};

        // Search key
        String searchId = "BG101";

        boolean found = searchBogie(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}