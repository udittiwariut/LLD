package vendingmachine;

public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    private ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertCount(Coin coin) {
        this.vendingMachine.addCoin(coin);

    }

    public boolean isValidPayment(double money) {
        if(this.vendingMachine.getTotalPayment() >= money){
            this.vendingMachine.addCoin(coin);
        }

    }
}
