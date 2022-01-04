import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel mainPanel;
    private JTextField inputField;
    private JLabel inputLabel;
    private JButton calculateButton;
    private JButton addButton;
    private JButton substractButton;
    private JLabel errorLabel;
    private JLabel resultNameLabel;
    private JLabel resultLabel;
    private double currentResult = 0;
    private int currentAction = 0;

    public SimpleCalculator(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double lastNumber = Double.parseDouble(inputField.getText());
                double result;
                if (currentAction == 0) {
                   result = currentResult + lastNumber;
                } else {
                    result = currentResult - lastNumber;
                }

                resultLabel.setText(Double.toString(result));
                inputField.setText("");
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentResult = Double.parseDouble(inputField.getText());
                currentAction = 0;
                inputField.setText("");
            }
        });
        substractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentResult = Double.parseDouble(inputField.getText());
                currentAction = 1;
                inputField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new SimpleCalculator("Calculator");
        frame.setVisible(true);
    }
}