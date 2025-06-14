package vendingmachine;

public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed. Please collect the change.");
    }

    @Override
    public void returnChange() {
        double change = this.vendingMachine.getTotalPayment() - this.vendingMachine.getSelectedProduct().getPrice();
        System.out.println("Please collect your change " + change);
        this.vendingMachine.setState(this.vendingMachine.getState(State.IDEAL));
        this.vendingMachine.setSelectedProduct(null);
        this.vendingMachine.resetTotalPayment();
        vendingMachine.deSelectSeclectedProduct();

    }

}
