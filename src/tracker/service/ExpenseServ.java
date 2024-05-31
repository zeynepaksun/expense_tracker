package tracker.service;

import tracker.model.Expense;
import java.util.List;
import java.util.ArrayList;


public class ExpenseServ {
    private List<Expense> expenses = new ArrayList<>();

    public List<Expense> getExpense() {
        return expenses;
    }

    public void insertExpense(Expense expense) {
        expenses.add(expense);
    }
}
