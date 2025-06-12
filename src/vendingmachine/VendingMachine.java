package vendingmachine;

import java.lang.annotation.Retention;

public class VendingMachine {

    private static VendingMachine instance;
    private final Inventory inventory;
    private Product selectedProduct;
    private double totalPayment;
    private VendingMachineState crrState;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public void setState(VendingMachineState state) {
        crrState = state;
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public Inventory getInvontry() {
        return this.inventory;
    }

    public double getTotalPayment() {
        return this.totalPayment;
    }

    public VendingMachineState getState(State state) {
        VendingMachineState changedState = null;
        switch (state) {
            case READY:
                changedState = this.readyState;
            case DISPENSE:
                changedState = this.dispenseState;
            case RETURN:
                changedState = this.returnChangeState;
            case IDEAL:
                changedState = this.idleState;
        }
        return changedState;
    }

    public void addCoin(Coin coin) {
        this.totalPayment += coin.getValue();
    }

    public void addNote(Note note) {
        this.totalPayment += note.getValue();
    }

}
