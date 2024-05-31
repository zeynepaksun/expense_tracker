package tracker.model;

import java.util.Date;

public class Expense {

    private String category;
    private String description;
    private Date date;
    private double amount;

    public Expense(String category, String description, Date date, double amount) {
        this.category = category;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    // get-set category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    // get-set description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // get-set date
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    // get-set amount
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
