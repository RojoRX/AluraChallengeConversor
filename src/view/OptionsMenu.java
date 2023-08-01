package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsMenu {
    private JFrame parentFrame;

    public OptionsMenu(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Opciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Alineación vertical

        // Margen para separar el texto de la parte superior de la ventana
        frame.add(Box.createVerticalStrut(20));

        JLabel label = new JLabel("¿Desea continuar?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto horizontalmente

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Alineación y espaciado
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar los botones horizontalmente

        JButton buttonBackToMenu = new JButton("Volver al Menú Principal");
        buttonBackToMenu.addActionListener(e -> {
        	CurrencyConverterMenu currencyConverterMenu = new CurrencyConverterMenu();
            currencyConverterMenu.displayMenu(); // Mostrar la ventana del menú principal
            frame.dispose(); // Cerrar la ventana de opciones
        });

        JButton buttonCancelAndClose = new JButton("Cancelar");
        buttonCancelAndClose.addActionListener(e -> {
        	parentFrame.setVisible(true);
            frame.dispose(); // Cerrar la ventana de opciones
        });

        JButton buttonExitProgram = new JButton("Terminar Programa");
        buttonExitProgram.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Programa terminado.");
            System.exit(0); // Terminar el programa
        });

        buttonPanel.add(buttonBackToMenu);
        buttonPanel.add(buttonCancelAndClose);
        buttonPanel.add(buttonExitProgram);

        frame.add(label);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
