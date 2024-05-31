package tracker.gui;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    public BudgetPanel() {
        setLayout(new BorderLayout());

        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(3, 2));

        panelInput.add(new JLabel("Your Monthly budget:"));
        JTextField fieldBudget = new JTextField();
        panelInput.add(fieldBudget);

        JButton buttonSetBudget = new JButton("Set Your Budget");
        panelInput.add(buttonSetBudget);

        JLabel currentLabel = new JLabel("Current Budget: Not Set");
        panelInput.add(currentLabel);

        add(panelInput, BorderLayout.NORTH);

        buttonSetBudget.addActionListener(e -> {
            String budget = fieldBudget.getText();
            if(isValid(budget)) {
                currentLabel.setText("Current Budget is: " + budget);
            }
            else {
                JOptionPane.showMessageDialog(this, "Please enter a valid budget", "Invalid Budget", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private boolean isValid(String budget) {
        try {
            double budgetDouble = Double.parseDouble(budget);
            return budgetDouble > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
