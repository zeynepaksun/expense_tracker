package tracker.gui;

import tracker.model.Expense;
import tracker.service.ExpenseServ;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ExpensePanel extends JPanel {
    private ExpenseServ expenseServ;

    public ExpensePanel() {
        setLayout(new BorderLayout());
        expenseServ = new ExpenseServ();

        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(5, 2));

        panelInput.add(new JLabel("Date:"));
        JTextField jtfDate = new JTextField();
        panelInput.add(jtfDate);

        panelInput.add(new JLabel("Amount:"));
        JTextField jtfAmount = new JTextField();
        panelInput.add(jtfAmount);

        panelInput.add(new JLabel("Category:"));
        JComboBox<String> jcbCategory = new JComboBox<>(new String[]{"Food", "Transportation", "Other"});
        panelInput.add(jcbCategory);

        panelInput.add(new JLabel("Description:"));
        JTextField txtDescription = new JTextField();
        panelInput.add(txtDescription);

        JButton btnAdd = new JButton("Add");
        panelInput.add(btnAdd);

        add(panelInput, BorderLayout.NORTH);

        String[] columns = {"Date", "Amount", "Category", "Description"};
        DefaultTableModel modelTable = new DefaultTableModel(columns, 0);
        JTable table = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> {
           String textDate = jtfDate.getText();
           String textAmount = jtfAmount.getText();
           String textCategory = jcbCategory.getSelectedItem().toString();
           String textDescription = txtDescription.getText();

           if(validateEnteredInputs(textDate, textAmount)) {
               Date date = dateParsed (textDate);
               double amount = Double.parseDouble(textAmount);

               Expense expense = new Expense(textCategory, textDescription, date, amount);
               expenseServ.insertExpense(expense);

               modelTable.addRow(new Object[]{textDate, amount, textCategory, textDescription});
               fieldClear(jtfDate, jtfAmount, txtDescription);
           }
           else {
               JOptionPane.showMessageDialog(this, "Please enter all the fields correctly.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
           }

        });
    }

    private boolean validateEnteredInputs(String textDate, String textAmount) {
        return dateParsed(textDate) != null && isAmountValid(textAmount);
    }

    private Date dateParsed(String textDate) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(textDate);
        } catch (ParseException e) {
            return null;
        }
    }

    private boolean isAmountValid(String textAmount) {
        try {
            double amount = Double.parseDouble(textAmount);
            return amount > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void fieldClear(JTextField jtfDate, JTextField jtfAmount, JTextField txtDescription) {
        jtfDate.setText("");
        jtfAmount.setText("");
        txtDescription.setText("");
    }
}
