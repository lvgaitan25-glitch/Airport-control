package interfaz;

import javax.swing.*;
import java.awt.*;
import estructuras.ArbolPasajeros;
import modelos.Pasajeros;

public class VentanaPrincipal extends JFrame {
    ArbolPasajeros arbol =
        new ArbolPasajeros();

    public VentanaPrincipal() {

        setTitle("Cyber-Airport Control");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        iniciarComponentes();
        arbol.insertar(
        new Pasajeros(
                100,
                "Sebastian",
                "Medellin",
                "A12"));

arbol.insertar(
        new Pasajeros(
                50,
                "Valentina",
                "Bogota",
                "B05"));

arbol.insertar(
        new Pasajeros(
                150,
                "Carlos",
                "Miami",
                "C18"));
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

    String entrada =
            JOptionPane.showInputDialog(
                    "Ingrese ticket:");

    int ticket = Integer.parseInt(entrada);

    boolean encontrado =
            arbol.buscar(ticket);

    if (encontrado) {

        JOptionPane.showMessageDialog(
                null,
                "Pasajero encontrado");

    } else {

        JOptionPane.showMessageDialog(
                null,
                "Pasajero NO encontrado");
    }
});
        add(panelPrincipal);
    }
}
