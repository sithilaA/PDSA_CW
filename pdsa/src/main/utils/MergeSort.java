package main.utils;

import main.model.Transaction;
import java.util.List;
import java.util.LinkedList;

public class MergeSort {
    public static void sort(List<Transaction> transactions) {
        if (transactions.size() < 2) {
            return;
        }
        int mid = transactions.size() / 2;
        List<Transaction> left = new LinkedList<>(transactions.subList(0, mid));
        List<Transaction> right = new LinkedList<>(transactions.subList(mid, transactions.size()));

        sort(left);
        sort(right);

        merge(transactions, left, right);
    }

    private static void merge(List<Transaction> transactions, List<Transaction> left, List<Transaction> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getDescription().compareTo(right.get(j).getDescription()) <= 0) {
                transactions.set(k++, left.get(i++));
            } else {
                transactions.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            transactions.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            transactions.set(k++, right.get(j++));
        }
    }
}
