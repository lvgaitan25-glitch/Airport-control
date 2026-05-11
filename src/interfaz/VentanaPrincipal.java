package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*; // <--- Ahora esta importación sí funcionará

public class VentanaPrincipal extends JFrame {
    private JPanel panelContenido = new JPanel();
    private ControlCentral control = new ControlCentral();

    public VentanaPrincipal() {
        setTitle("Cyber Airport Control");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        crearMenu();
        
        panelContenido.setLayout(new BorderLayout());
        add(panelContenido, BorderLayout.CENTER);
    }

    private void crearMenu() {
        JPanel menu = new JPanel(new GridLayout(6, 1, 5, 5));
        JButton btnAviones = new JButton("Aviones");
        JButton btnPasajeros = new JButton("Pasajeros");
        JButton btnRutas = new JButton("Rutas");
        JButton btnRadar = new JButton("Radar");
        JButton btnDespegues = new JButton("Despegues");
        JButton btnHistorial = new JButton("Historial");

        btnAviones.addActionListener(e -> mostrar(new AvionesPanel(control)));
        btnPasajeros.addActionListener(e -> mostrar(new PasajerosPanel(control)));
        btnRutas.addActionListener(e -> mostrar(new RutasPanel(control)));
        btnRadar.addActionListener(e -> mostrar(new RadarPanel(control)));
        btnDespegues.addActionListener(e -> mostrar(new DespeguesPanel(control)));
        btnHistorial.addActionListener(e -> mostrar(new HistorialPanel(control)));

        menu.add(btnAviones); menu.add(btnPasajeros); menu.add(btnRutas);
        menu.add(btnRadar); menu.add(btnDespegues); menu.add(btnHistorial);
        add(menu, BorderLayout.WEST);
    }

    private void mostrar(JPanel panel) {
        panelContenido.removeAll();
        panelContenido.add(panel, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}