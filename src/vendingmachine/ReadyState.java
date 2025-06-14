package vendingmachine;

public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Coin coin) {
        this.vendingMachine.addCoin(coin);

    }

    @Override
    public void insertNote(Note note) {
        this.vendingMachine.addNote(note);
        vendingMachine.setState(this.vendingMachine.getState(State.DISPENSE));
    }

    @Override
    public void selectProduct(Product product) {
        System.err.println("Product is already selected");

    }

    @Override
    public void returnChange() {
        System.err.println("Return will be provided after dispense of product");

    }

    @Override
    public void dispenseProduct() {
        if (!vendingMachine.isValidPayment())
            System.out.println("Insufficient Money.");
        else {
            vendingMachine.setState(vendingMachine.getState(State.DISPENSE));
            vendingMachine.dispenseProduct();
        }

    }

}
