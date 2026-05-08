package interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Cyber-Airport Control");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    public void iniciarComponentes() {

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        // TÍTULO
        JLabel titulo = new JLabel("CYBER-AIRPORT CONTROL", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // PANEL CENTRAL
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(2, 3, 10, 10));

        JButton btnRutas = new JButton("Rutas de Vuelo");
        JButton btnRadar = new JButton("Radar de Pista");
        JButton btnAviones = new JButton("Registro Aviones");
        JButton btnCola = new JButton("Cola Despegue");
        JButton btnHistorial = new JButton("Historial Undo");
        JButton btnPasajeros = new JButton("Pasajeros BST");

        panelCentral.add(btnRutas);
        panelCentral.add(btnRadar);
        panelCentral.add(btnAviones);
        panelCentral.add(btnCola);
        panelCentral.add(btnHistorial);
        panelCentral.add(btnPasajeros);

        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        // EVENTOS
        btnRutas.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Módulo Grafo: Rutas de vuelo");
        });

        btnRadar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Módulo Matriz: Radar de pista");
        });

        btnAviones.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Módulo Arreglo: Registro de aviones");
        });

        btnCola.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Módulo Cola: Despegues");
        });

        btnHistorial.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Módulo Pila: Historial Undo");
        });

        btnPasajeros.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Módulo Árbol: Pasajeros por ticket");
        });

        add(panelPrincipal);
    }
}
