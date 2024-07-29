package main.service;

import main.model.TransactionNode;

public class TransactionService {
    private TransactionNode head;

    public TransactionService() {
        this.head = null;
    }

    public void addTransaction(String type, double amount, String description) {
        TransactionNode newNode = new TransactionNode(type, amount, description);
        if (head == null) {
            head = newNode;
        } else {
            TransactionNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void printTransactions() {
        TransactionNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
