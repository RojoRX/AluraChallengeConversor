package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.TimeConverter;

public class TimeConverterGUI {
    private TimeConverter timeConverter;

    public TimeConverterGUI() {
        timeConverter = new TimeConverter();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Conversor de Tiempo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel labelValue = new JLabel("Valor:");
        JTextField textFieldValue = new JTextField();
        JLabel labelFromUnit = new JLabel("Desde:");
        JComboBox<TimeConverter.TimeUnit> comboBoxFromUnit = new JComboBox<>(TimeConverter.TimeUnit.values());
        JLabel labelToUnit = new JLabel("A:");
        JComboBox<TimeConverter.TimeUnit> comboBoxToUnit = new JComboBox<>(TimeConverter.TimeUnit.values());

        inputPanel.add(labelValue);
        inputPanel.add(textFieldValue);
        inputPanel.add(labelFromUnit);
        inputPanel.add(comboBoxFromUnit);
        inputPanel.add(labelToUnit);
        inputPanel.add(comboBoxToUnit);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton buttonConvert = new JButton("Convertir");
        buttonPanel.add(buttonConvert);
        
        JPanel optionsPanel = new JPanel(new FlowLayout());
        JButton buttonShowOptions = new JButton("Salir");
        optionsPanel.add(buttonShowOptions);
        frame.add(optionsPanel, BorderLayout.SOUTH);

        buttonShowOptions.addActionListener(e -> {
            frame.setVisible(false); // Ocultar la ventana principal
            new OptionsMenu(frame); // Abrir la ventana de opciones
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(textFieldValue.getText());
                    TimeConverter.TimeUnit fromUnit = (TimeConverter.TimeUnit) comboBoxFromUnit.getSelectedItem();
                    TimeConverter.TimeUnit toUnit = (TimeConverter.TimeUnit) comboBoxToUnit.getSelectedItem();
                    double result = timeConverter.convertTime(value, fromUnit, toUnit);
                    showResultDialog(result, toUnit);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Valor no válido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Unidad de tiempo no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private void showResultDialog(double result, TimeConverter.TimeUnit unit) {
        JFrame resultFrame = new JFrame("Resultado");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setSize(300, 100);
        resultFrame.setLayout(new BorderLayout());
        
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel resultLabel = new JLabel("Resultado: " + result + " " + unit);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        resultPanel.add(resultLabel, BorderLayout.CENTER);
        resultFrame.add(resultPanel);

        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TimeConverterGUI converterGUI = new TimeConverterGUI();
            converterGUI.createAndShowGUI();
        });
    }
}
