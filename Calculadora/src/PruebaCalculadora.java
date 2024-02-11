import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaCalculadora {
    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel labelResultado;
    private JButton buttonSumar;
    private JButton buttonMultiplicar;
    private JButton buttonClear;
    private Calculadora calculadora;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PruebaCalculadora window = new PruebaCalculadora();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PruebaCalculadora() {
        calculadora = new Calculadora();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculadora");
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        textField1 = new JTextField();
        textField1.setColumns(10);
        frame.getContentPane().add(textField1);

        textField2 = new JTextField();
        textField2.setColumns(10);
        frame.getContentPane().add(textField2);

        buttonSumar = new JButton("+");
        buttonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int resultado = calculadora.sumar(num1, num2);
                labelResultado.setText("Resultado: " + resultado);
            }
        });
        frame.getContentPane().add(buttonSumar);

        buttonMultiplicar = new JButton("*");
        buttonMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int resultado = calculadora.multiplicar(num1, num2);
                labelResultado.setText("Resultado: " + resultado);
            }
        });
        frame.getContentPane().add(buttonMultiplicar);

        buttonClear = new JButton("Clear");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                labelResultado.setText("Resultado:");
            }
        });
        frame.getContentPane().add(buttonClear);

        labelResultado = new JLabel("Resultado:");
        frame.getContentPane().add(labelResultado);
    }
}