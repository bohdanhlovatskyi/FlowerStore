package payments;

public class Transaction {
    public boolean isSuccessful;
    public double amount;
    public String transactionType;

    public Transaction(String transactionType, double amount, boolean isSuccessful) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.isSuccessful = isSuccessful;
    }
}
