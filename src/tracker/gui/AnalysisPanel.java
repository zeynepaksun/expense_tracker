package tracker.gui;

import javax.swing.*;
import java.awt.*;

public class AnalysisPanel extends JPanel{
    public AnalysisPanel(){
        setLayout(new BorderLayout());

        JPanel panelAnalysis = new JPanel();
        panelAnalysis.setLayout(new BorderLayout());

        JTextArea areaAnalysis = new JTextArea("Spending Patterns");
        panelAnalysis.add(new JScrollPane(areaAnalysis), BorderLayout.CENTER);

        add(areaAnalysis, BorderLayout.CENTER);

    }
}
