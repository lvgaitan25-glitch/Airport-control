package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class HistorialPanel extends JPanel {
    public HistorialPanel(ControlCentral control) {
        setLayout(new BorderLayout());
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        JList<String> lista = new JList<>(modeloLista);
        JButton btnUndo = new JButton("Deshacer Última Acción (UNDO)");

        btnUndo.addActionListener(e -> {
            String accion = control.getHistorial().deshacerAccion();
            JOptionPane.showMessageDialog(this, "Deshaciendo: " + accion);
        });

        add(new JLabel("HISTORIAL DE ACCIONES (PILA)", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(btnUndo, BorderLayout.SOUTH);
    }
}