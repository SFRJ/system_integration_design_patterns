package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static gui.Calculator.calculate;
import static java.lang.Integer.parseInt;

public class CommandsBoard implements ActionListener {

    private JPanel commandsPanel;
    private JTextField firtNumber;
    private JTextField secondNumber;
    private JLabel result;
    private JButton sumButton;

    public CommandsBoard() {
        this.commandsPanel = new JPanel();
        this.firtNumber = new JTextField("value");
        this.secondNumber = new JTextField("value");
        this.result = new JLabel("<result>");
        this.sumButton = new JButton("SUM");
    }

    public JPanel init() {
        commandsPanel = new JPanel(new FlowLayout());
        commandsPanel.add(firtNumber);
        commandsPanel.add(secondNumber);
        commandsPanel.add(result);
        sumButton.addActionListener(this);
        commandsPanel.add(sumButton);
        return commandsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
        result.setText(calculate(parseInt(firtNumber.getText()), parseInt(secondNumber.getText())));
        }
        catch (Exception ex) {
            result.setText("not valid numbers");
        }
    }
}