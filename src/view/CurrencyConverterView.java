package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CurrencyConverter;

public class CurrencyConverterView {
    private CurrencyConverter currencyConverter;

    public CurrencyConverterView() {
        currencyConverter = new CurrencyConverter();
    }

    public void displayGUI() {
        JFrame frame = new JFrame("Conversor de Moneda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 200)); // Establecer el ancho mínimo
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel labelFrom = new JLabel("Cantidad:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(labelFrom, gbc);

        JTextField textFieldAmount = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(textFieldAmount, gbc);

        JLabel labelFromCurrency = new JLabel("Moneda de origen (USD, EUR, GBP, JPY, KRW):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(labelFromCurrency, gbc);

        // Selector de monedas de origen
        String[] currencies = { "USD", "EUR", "GBP", "JPY", "KRW" };
        JComboBox<String> currencySelectorFrom = new JComboBox<>(currencies);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(currencySelectorFrom, gbc);

        JLabel labelTo = new JLabel("Moneda de destino (USD, EUR, GBP, JPY, KRW):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(labelTo, gbc);

        // Selector de monedas de destino
        JComboBox<String> currencySelectorTo = new JComboBox<>(currencies);
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(currencySelectorTo, gbc);

        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints buttonGbc = new GridBagConstraints();
        buttonGbc.insets = new Insets(5, 5, 5, 5);
        buttonGbc.anchor = GridBagConstraints.CENTER;

        JButton buttonConvertTo = new JButton("Convertir BOB a Moneda de Destino");
        buttonGbc.gridx = 0;
        buttonGbc.gridy = 0;
        buttonPanel.add(buttonConvertTo, buttonGbc);

        JButton buttonConvertFrom = new JButton("Convertir Moneda de Origen a BOB");
        buttonGbc.gridx = 1;
        buttonGbc.gridy = 0;
        buttonPanel.add(buttonConvertFrom, buttonGbc);
        
        JPanel optionsPanel = new JPanel(new FlowLayout());
        JButton buttonShowOptions = new JButton("Salir");
        optionsPanel.add(buttonShowOptions);
        frame.add(optionsPanel, BorderLayout.SOUTH);

        buttonShowOptions.addActionListener(e -> {
            frame.setVisible(false); // Ocultar la ventana principal
            new OptionsMenu(frame); // Abrir la ventana de opciones
        });

        frame.setVisible(true);

        frame.add(buttonPanel, BorderLayout.CENTER);

        buttonConvertTo.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(textFieldAmount.getText());
                String toCurrency = (String) currencySelectorTo.getSelectedItem();
                double convertedAmount = currencyConverter.convertToCurrency(amount, toCurrency);
                showResultDialog(amount + " BOB es igual a " + convertedAmount + " " + toCurrency);
            } catch (NumberFormatException ex) {
                showErrorDialog("Valor no válido en la cantidad. Ingrese un número válido.");
            }
        });
        buttonConvertFrom.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(textFieldAmount.getText());
                String fromCurrency = (String) currencySelectorFrom.getSelectedItem();
                double convertedAmount = currencyConverter.convertFromCurrency(amount, fromCurrency);
                showResultDialog(amount + " " + fromCurrency + " es igual a " + convertedAmount + " BOB");
            } catch (NumberFormatException ex) {
                showErrorDialog("Valor no válido en la cantidad. Ingrese un número válido.");
            }
        });

        frame.setVisible(true);
    }

    private void showResultDialog(String result) {
        JOptionPane.showMessageDialog(null, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverterView converterView = new CurrencyConverterView();
            converterView.displayGUI();
        });
    }
}
