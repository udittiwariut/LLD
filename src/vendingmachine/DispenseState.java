package vendingmachine;

public class DispenseState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {

        Product product = vendingMachine.getSelectedProduct();
        Inventory inventory = vendingMachine.getInvontry();
        inventory.reduceQuantity(product);
        System.out.println("Product dispensed: " + product.getName());
        this.vendingMachine.setState(this.vendingMachine.getState(State.RETURN));
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please complete previous transition first.");

    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please complete previous transition first.");

    }

}
