package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrencyConverterMenu implements Menu {
    private JFrame frame;

    public CurrencyConverterMenu() {
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());

        // Panel para mostrar el texto de bienvenida
        JPanel welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Bienvenido al Challenge Conversor de ALURA");
        welcomePanel.add(welcomeLabel);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton buttonCurrencyConverter = new JButton("Conversor de Moneda");
        JButton buttonTimeConverter = new JButton("Conversor de Tiempo");
        JButton buttonExitProgram = new JButton("Salir del Programa");

        buttonCurrencyConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerramos el menú principal
                CurrencyConverterView currencyConverterView = new CurrencyConverterView();
                currencyConverterView.displayGUI(); // Mostramos el conversor de moneda
            }
        });

        buttonTimeConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerramos el menú principal
                TimeConverterGUI timeConverterGUI = new TimeConverterGUI();
                timeConverterGUI.createAndShowGUI(); // Mostramos el conversor de tiempo
            }
        });

        buttonExitProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Terminar el programa
            }
        });

        buttonPanel.add(buttonCurrencyConverter);
        buttonPanel.add(buttonTimeConverter);
        buttonPanel.add(buttonExitProgram);

        // Panel para mostrar el texto de autoría y año
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        JLabel authorLabel = new JLabel("Desarrollado por Eric Rojo");
        footerPanel.add(authorLabel, BorderLayout.NORTH);

        // Agregar los paneles al frame principal
        frame.add(welcomePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    @Override
    public void displayMenu() {
        // Implementar el método displayMenu() de la interfaz Menu aquí si es necesario.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverterMenu currencyConverterMenu = new CurrencyConverterMenu();
        });
    }
}
