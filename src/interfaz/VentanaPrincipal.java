package interfaz;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    JPanel panelMenu;
    JPanel panelContenido;

    public VentanaPrincipal() {

        setTitle("Cyber-Airport Control");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    public void iniciarComponentes() {

        // PANEL PRINCIPAL
        setLayout(new BorderLayout());

        // =========================
        // PANEL SUPERIOR
        // =========================

        JPanel panelSuperior = new JPanel();

        JLabel titulo = new JLabel("CYBER AIRPORT CONTROL");

        titulo.setFont(new Font("Arial", Font.BOLD, 28));

        panelSuperior.add(titulo);

        add(panelSuperior, BorderLayout.NORTH);

        // =========================
        // PANEL MENU
        // =========================

        panelMenu = new JPanel();

        panelMenu.setLayout(new GridLayout(6,1));

        JButton btnAviones = new JButton("Aviones");
        JButton btnPasajeros = new JButton("Pasajeros");
        JButton btnRutas = new JButton("Rutas");
        JButton btnRadar = new JButton("Radar");
        JButton btnDespegues = new JButton("Despegues");
        JButton btnHistorial = new JButton("Historial");

        panelMenu.add(btnAviones);
        panelMenu.add(btnPasajeros);
        panelMenu.add(btnRutas);
        panelMenu.add(btnRadar);
        panelMenu.add(btnDespegues);
        panelMenu.add(btnHistorial);

        add(panelMenu, BorderLayout.WEST);

        // =========================
        // PANEL CONTENIDO
        // =========================

        panelContenido = new JPanel();

        panelContenido.setLayout(new BorderLayout());

        JLabel bienvenida = new JLabel(
                "Bienvenido al sistema aeroportuario",
                SwingConstants.CENTER
        );

        bienvenida.setFont(new Font("Arial", Font.PLAIN, 24));

        panelContenido.add(bienvenida, BorderLayout.CENTER);

        add(panelContenido, BorderLayout.CENTER);

        // =========================
        // EVENTOS BOTONES
        // =========================

        btnAviones.addActionListener(e -> mostrarModulo("MÓDULO AVIONES"));

        btnPasajeros.addActionListener(e -> mostrarModulo("MÓDULO PASAJEROS"));

        btnRutas.addActionListener(e -> mostrarModulo("MÓDULO RUTAS"));

        btnRadar.addActionListener(e -> mostrarModulo("MÓDULO RADAR"));

        btnDespegues.addActionListener(e -> mostrarModulo("MÓDULO DESPEGUES"));

        btnHistorial.addActionListener(e -> mostrarModulo("MÓDULO HISTORIAL"));
    }

    // =========================
    // CAMBIAR CONTENIDO
    // =========================

    public void mostrarModulo(String texto) {

        panelContenido.removeAll();

        JLabel label = new JLabel(texto, SwingConstants.CENTER);

        label.setFont(new Font("Arial", Font.BOLD, 30));

        panelContenido.add(label, BorderLayout.CENTER);

        panelContenido.revalidate();
        panelContenido.repaint();
    }
}