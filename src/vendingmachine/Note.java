package vendingmachine;

public enum Note {
    ONE(1), FIVE(5), TEN(10);

    private int value;

    Note(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
