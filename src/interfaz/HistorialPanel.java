package interfaz;

import javax.swing.*;
import java.awt.*;
import Control.ControlCentral;

public class HistorialPanel extends JPanel {
    private ControlCentral Control;
    private JTextArea areaTexto;

    public HistorialPanel(ControlCentral Control) {
        this.Control = Control;
        setBackground(new Color(21, 32, 43));
        setLayout(new BorderLayout(15, 15));
        
        JLabel titulo = new JLabel("HISTORIAL DE OPERACIONES");
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBackground(new Color(13, 23, 33));
        areaTexto.setForeground(Color.GREEN);
        
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
    }

    // ESTE ES EL MÉTODO QUE TE DABA ERROR:
    public void cargarHistorial() {
        if (areaTexto != null && Control.getHistorial() != null) {
            areaTexto.setText("");
            for (String log : Control.getHistorial().getListaLogs()) {
                areaTexto.append("> " + log + "\n");
            }
        }
    }
}