public class Train {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (shape.equalsIgnoreCase("Rectangular")
                        && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=======================================");
        System.out.println();

        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        try {
            bogie1.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        try {
            bogie2.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("UC15 runtime handling completed...");
    }
}