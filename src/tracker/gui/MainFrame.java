package tracker.gui;

import javax.swing.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        setSize(800, 600);
        setTitle("Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane mainTabbedPane = new JTabbedPane();

        mainTabbedPane.addTab("User Expenses", new ExpensePanel());
        mainTabbedPane.addTab("User Budget", new BudgetPanel());
        mainTabbedPane.addTab("Analysis", new AnalysisPanel());

        add(mainTabbedPane);
    }
}
