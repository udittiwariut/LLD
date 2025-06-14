package vendingmachine;

public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (this.vendingMachine.getInvontry().isAvailable(product)) {
            this.vendingMachine.setSelectedProduct(product);
            this.vendingMachine.setState(this.vendingMachine.getState(State.READY));
            System.out.println("Product selected: " + product.getName());
        } else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void returnChange() {
        System.out.println(this.vendingMachine.getCrruntState());
        System.out.println("Select the product first.");

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select the product first.");

    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select the product first.");

    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select the product first.");
    }

}
