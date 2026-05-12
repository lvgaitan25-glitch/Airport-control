package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class RadarPanel extends JPanel {
    private ControlCentral Control;
    private JPanel panelGrid;

    public RadarPanel(ControlCentral Control) {
        this.Control = Control;
        setBackground(new Color(13, 23, 33));
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("MONITOR DE HANGARES (MATRIZ)", SwingConstants.CENTER);
        titulo.setForeground(new Color(46, 204, 113));
        titulo.setFont(new Font("Consolas", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        panelGrid = new JPanel(new GridLayout(5, 5, 5, 5));
        panelGrid.setBackground(new Color(13, 23, 33));
        add(panelGrid, BorderLayout.CENTER);
        
        dibujarRadar();
    }

    public void dibujarRadar() {
        panelGrid.removeAll();
        for (int i = 0; i < Control.getRadar().getFilas(); i++) {
            for (int j = 0; j < Control.getRadar().getColumnas(); j++) {
                JPanel celda = new JPanel();
                celda.setLayout(new BorderLayout());
                
                if (Control.getRadar().estaOcupado(i, j)) {
                    celda.setBackground(new Color(192, 57, 43)); // Rojo
                    JLabel icon = new JLabel("✈", SwingConstants.CENTER);
                    icon.setForeground(Color.WHITE);
                    celda.add(icon);
                } else {
                    celda.setBackground(new Color(28, 40, 51)); // Azul oscuro
                    JLabel coord = new JLabel(i + "," + j, SwingConstants.CENTER);
                    coord.setForeground(Color.DARK_GRAY);
                    coord.setFont(new Font("Arial", Font.PLAIN, 10));
                    celda.add(coord);
                }
                celda.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185)));
                panelGrid.add(celda);
            }
        }
        panelGrid.revalidate();
        panelGrid.repaint();
    }
}