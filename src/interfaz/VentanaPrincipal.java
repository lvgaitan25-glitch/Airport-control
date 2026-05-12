package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    // =====================================================
    // ATRIBUTOS
    // =====================================================

    private ControlCentral Control;

    private CardLayout cardLayout;

    private JPanel contenedorCentral;

    // =====================================================
    // PANELES
    // =====================================================

    private DashboardPanel panelDashboard;

    private PasajerosPanel panelPasajeros;

    private AvionesPanel panelAviones;

    private RadarPanel panelRadar;

    private RutasPanel panelRutas;

    private DespeguePanel panelDespegue;

    private HistorialPanel panelHistorial;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public VentanaPrincipal() {

        // Inicializar sistema
        Control = new ControlCentral();

        Control.iniciarSistema();

        // Configuración ventana
        setTitle("AIRPORT-CONTROL | Gestión Aeroportuaria");

        setSize(1150, 720);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        inicializarComponentes();
    }

    // =====================================================
    // INICIALIZAR COMPONENTES
    // =====================================================

    private void inicializarComponentes() {

        // =================================================
        // MENÚ LATERAL
        // =================================================

        JPanel menuLateral = new JPanel();

        menuLateral.setBackground(
                new Color(13, 23, 33));

        menuLateral.setPreferredSize(
                new Dimension(250, 0));

        menuLateral.setLayout(
                new GridLayout(10, 1, 5, 5));

        // =================================================
        // CONTENEDOR CENTRAL
        // =================================================

        cardLayout = new CardLayout();

        contenedorCentral = new JPanel(cardLayout);

        // =================================================
        // INICIALIZAR PANELES
        // =================================================

        panelDashboard =
                new DashboardPanel(Control);

        panelPasajeros =
                new PasajerosPanel(Control);

        panelAviones =
                new AvionesPanel(Control);

        panelRadar =
                new RadarPanel(Control);

        panelRutas =
                new RutasPanel(Control);

        panelDespegue =
                new DespeguePanel(Control);

        panelHistorial =
                new HistorialPanel(Control);

        // =================================================
        // AGREGAR PANELES
        // =================================================

        contenedorCentral.add(
                panelDashboard,
                "DASHBOARD");

        contenedorCentral.add(
                panelPasajeros,
                "PASAJEROS");

        contenedorCentral.add(
                panelAviones,
                "AVIONES");

        contenedorCentral.add(
                panelRadar,
                "RADAR");

        contenedorCentral.add(
                panelRutas,
                "RUTAS");

        contenedorCentral.add(
                panelDespegue,
                "DESPEGUE");

        contenedorCentral.add(
                panelHistorial,
                "HISTORIAL");

        // =================================================
        // BOTONES MENÚ
        // =================================================

        String[] secciones = {

                "DASHBOARD",
                "PASAJEROS",
                "AVIONES",
                "RADAR",
                "RUTAS",
                "DESPEGUE",
                "HISTORIAL"
        };

        for (String texto : secciones) {

            JButton btn =
                    crearBotonMenu(texto);

            btn.addActionListener(e -> {

                // =========================================
                // ACTUALIZAR PANELES
                // =========================================

                switch (texto) {

                    case "DASHBOARD":

                        panelDashboard
                                .actualizarEstadisticas();

                        break;

                    case "RADAR":

                        panelRadar
                                .dibujarRadar();

                        break;

                    case "DESPEGUE":

                        // =================================
                        // ACTUALIZAR COMBO Y LISTA
                        // =================================

                        panelDespegue
                                .actualizarComboAviones();

                        panelDespegue
                                .actualizarLista();

                        break;

                    case "HISTORIAL":

                        panelHistorial
                                .cargarHistorial();

                        break;

                    case "PASAJEROS":

                        panelPasajeros
                                .actualizarTabla();

                        break;
                }

                // =========================================
                // CAMBIAR PANEL
                // =========================================

                cardLayout.show(
                        contenedorCentral,
                        texto);
            });

            menuLateral.add(btn);
        }

        // =================================================
        // AGREGAR COMPONENTES
        // =================================================

        add(menuLateral, BorderLayout.WEST);

        add(contenedorCentral, BorderLayout.CENTER);
    }

    // =====================================================
    // BOTÓN PERSONALIZADO
    // =====================================================

    private JButton crearBotonMenu(String texto) {

        JButton btn = new JButton(texto);

        btn.setForeground(Color.WHITE);

        btn.setBackground(
                new Color(21, 32, 43));

        btn.setFocusPainted(false);

        btn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        btn.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        new Color(41, 128, 185)));

        // =============================================
        // EFECTO HOVER
        // =============================================

        btn.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    public void mouseEntered(
                            java.awt.event.MouseEvent evt) {

                        btn.setBackground(
                                new Color(52, 152, 219));
                    }

                    public void mouseExited(
                            java.awt.event.MouseEvent evt) {

                        btn.setBackground(
                                new Color(21, 32, 43));
                    }
                });

        return btn;
    }
}