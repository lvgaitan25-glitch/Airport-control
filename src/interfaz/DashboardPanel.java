package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class DashboardPanel extends JPanel {

    private ControlCentral Control;

    public DashboardPanel(ControlCentral control) {

        this.Control = control;

        setLayout(new BorderLayout());

        setBackground(new Color(15, 23, 42));

        // =====================================================
        // PANEL SUPERIOR
        // =====================================================

        JPanel panelSuperior = new JPanel();

        panelSuperior.setBackground(new Color(15, 23, 42));

        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));

        panelSuperior.setBorder(
                BorderFactory.createEmptyBorder(40, 40, 20, 40));

        JLabel titulo =
                new JLabel("AIRPORT CONTROL CENTER");

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 34));

        titulo.setForeground(Color.WHITE);

        JLabel subtitulo =
                new JLabel("Sistema Aeroportuario Inteligente");

        subtitulo.setFont(
                new Font("Segoe UI", Font.PLAIN, 16));

        subtitulo.setForeground(
                new Color(180, 180, 180));

        panelSuperior.add(titulo);

        panelSuperior.add(Box.createVerticalStrut(10));

        panelSuperior.add(subtitulo);

        // =====================================================
        // PANEL CENTRAL DECORATIVO
        // =====================================================

        JPanel panelDecorativo = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                // Fondo degradado
                GradientPaint gp = new GradientPaint(
                        0,
                        0,
                        new Color(20, 30, 48),
                        getWidth(),
                        getHeight(),
                        new Color(36, 59, 85));

                g2.setPaint(gp);

                g2.fillRect(0, 0, getWidth(), getHeight());

                // Radar decorativo
                g2.setColor(new Color(52, 152, 219, 80));

                int centroX = getWidth() / 2;

                int centroY = getHeight() / 2;

                for (int i = 50; i <= 250; i += 40) {

                    g2.drawOval(
                            centroX - i / 2,
                            centroY - i / 2,
                            i,
                            i);
                }

                // Línea radar
                g2.setStroke(new BasicStroke(3));

                g2.setColor(new Color(46, 204, 113));

                g2.drawLine(
                        centroX,
                        centroY,
                        centroX + 140,
                        centroY - 90);

                // Puntos decorativos
                g2.fillOval(
                        centroX + 120,
                        centroY - 80,
                        10,
                        10);

                g2.fillOval(
                        centroX - 90,
                        centroY + 60,
                        10,
                        10);

                g2.fillOval(
                        centroX + 40,
                        centroY + 100,
                        10,
                        10);

                // Avión decorativo
                g2.setFont(
                        new Font("Segoe UI Emoji",
                                Font.PLAIN,
                                50));

                g2.drawString(
                        "✈",
                        centroX - 25,
                        centroY + 20);

                // Texto inferior
                g2.setFont(
                        new Font("Segoe UI",
                                Font.BOLD,
                                20));

                g2.setColor(Color.WHITE);

                g2.drawString(
                        "CENTRO DE MONITOREO AÉREO",
                        centroX - 170,
                        getHeight() - 60);

                g2.setFont(
                        new Font("Segoe UI",
                                Font.PLAIN,
                                14));

                g2.setColor(
                        new Color(200, 200, 200));

                g2.drawString(
                        "Control de vuelos • Radar • Pasajeros • Rutas",
                        centroX - 180,
                        getHeight() - 30);
            }
        };

        panelDecorativo.setOpaque(false);

        // =====================================================
        // PANEL INFERIOR
        // =====================================================

        JPanel panelInferior = new JPanel(
                new FlowLayout(FlowLayout.RIGHT));

        panelInferior.setBackground(new Color(15, 23, 42));

        panelInferior.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JLabel estado =
                new JLabel("● SISTEMA OPERATIVO");

        estado.setForeground(new Color(46, 204, 113));

        estado.setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        panelInferior.add(estado);

        // =====================================================
        // AGREGAR COMPONENTES
        // =====================================================

        add(panelSuperior, BorderLayout.NORTH);

        add(panelDecorativo, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);
    }

    // =====================================================
    // MÉTODO VACÍO PARA COMPATIBILIDAD
    // =====================================================

    public void actualizarEstadisticas() {

    }
}