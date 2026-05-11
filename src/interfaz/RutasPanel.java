package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class RutasPanel extends JPanel {
    public RutasPanel(ControlCentral control) {
        setLayout(new BorderLayout());
        JTextArea areaRutas = new JTextArea(15, 30);
        areaRutas.setEditable(false);
        
        // Aquí simulamos la visualización del Grafo
        areaRutas.append("=== RED DE RUTAS ACTUALES ===\n");
        areaRutas.append("Bogotá -> [Miami, Madrid]\n");
        areaRutas.append("Miami -> [Bogotá]\n");
        areaRutas.append("Madrid -> [Bogotá]\n");

        add(new JLabel("CONEXIONES ENTRE AEROPUERTOS", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(areaRutas), BorderLayout.CENTER);
    }
}