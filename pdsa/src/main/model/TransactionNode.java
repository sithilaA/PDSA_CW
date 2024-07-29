package main.model;

public class TransactionNode {
    private String type; // "income" or "expense"
    private double amount;
    private String description;
    private TransactionNode next;

    public TransactionNode(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.next = null;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionNode getNext() {
        return next;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\n" + "Amount: " + amount + "\n" + "Description: " + description;
    }
}
