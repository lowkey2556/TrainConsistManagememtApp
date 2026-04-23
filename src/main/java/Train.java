public class Train {
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    static class PassengerBogie {
        private String bogieType;
        private int capacity;

        public PassengerBogie(String bogieType, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public String getBogieType() {
            return bogieType;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return bogieType + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=======================================");
        System.out.println();

        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + bogie1);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            PassengerBogie bogie2 = new PassengerBogie("General", 0);
            System.out.println("Created Bogie: " + bogie2);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("UC14 exception handling completed...");
    }
}