package vendingmachine;

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
        crrState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static VendingMachine getInsVendingMachineInstance() {
        if (instance == null)
            instance = new VendingMachine();

        return instance;
    }

    public Product addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price);
        inventory.addItem(product, quantity);
        return product;
    }

    public void selectProduct(Product product) {
        crrState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        crrState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        crrState.insertNote(note);
    }

    public void dispenseProduct() {
        crrState.dispenseProduct();
    }

    public void returnChange() {
        crrState.returnChange();
    }

    VendingMachineState getState(State state) {
        VendingMachineState changedState = null;

        switch (state) {
            case READY -> changedState = this.readyState;
            case DISPENSE -> changedState = this.dispenseState;

            case RETURN -> changedState = this.returnChangeState;

            case IDEAL -> changedState = this.idleState;

        }

        return changedState;
    }

    void setState(VendingMachineState state) {
        crrState = state;
    }

    void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    Product getSelectedProduct() {
        return this.selectedProduct;
    }

    Inventory getInvontry() {
        return this.inventory;
    }

    double getTotalPayment() {
        return this.totalPayment;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void addNote(Note note) {
        totalPayment += note.getValue();
    }

    void resetTotalPayment() {
        totalPayment = 0.0;
    }

    void deSelectSeclectedProduct() {
        this.selectedProduct = null;
    }

    VendingMachineState getCrruntState() {
        return this.crrState;
    }

    boolean isValidPayment() {
        return this.getTotalPayment() >= this.getSelectedProduct().getPrice();
    }

}
