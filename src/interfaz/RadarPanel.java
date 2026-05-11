package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class RadarPanel extends JPanel {
    public RadarPanel(ControlCentral control) {
        setLayout(new FlowLayout());

        JTextField txtFila = new JTextField(3);
        JTextField txtCol = new JTextField(3);
        JButton btnOcupar = new JButton("Marcar Posición");

        btnOcupar.addActionListener(e -> {
            int f = Integer.parseInt(txtFila.getText());
            int c = Integer.parseInt(txtCol.getText());
            control.getRadar().ocupar(f, c); // Guarda en la Matriz
            control.getHistorial().guardarAccion("Radar: Posición ["+f+"]["+c+"] ocupada");
            JOptionPane.showMessageDialog(this, "Radar actualizado.");
        });

        add(new JLabel("Fila:")); add(txtFila);
        add(new JLabel("Col:")); add(txtCol);
        add(btnOcupar);
    }
}