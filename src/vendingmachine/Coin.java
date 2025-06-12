package vendingmachine;

public enum Coin {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.1),
    QUARTER(0.25);

    private double value;

    Coin(double val) {
        this.value = val;
    }

    public double getValue() {
        return value;
    }

}
