package vendingmachine;

public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (this.vendingMachine.getInvontry().isAvailable(product)) {
            System.out.println("Product selected: " + product.getName());
        } else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }

}
