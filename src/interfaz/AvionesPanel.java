package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;
import modelos.Avion;

public class AvionesPanel extends JPanel {
    public AvionesPanel(ControlCentral control) {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(3, 2));
        JTextField txtId = new JTextField();
        JTextField txtModelo = new JTextField();
        JButton btnGuardar = new JButton("Agregar al Hangar");

        btnGuardar.addActionListener(e -> {
            String id = txtId.getText();
            String mod = txtModelo.getText();
            if (!id.isEmpty() && !mod.isEmpty()) {
                control.getAviones().agregar(new Avion(id, mod, "Hangar"));
                control.getHistorial().guardarAccion("Avión agregado: " + id);
                JOptionPane.showMessageDialog(this, "Avión guardado con éxito.");
                txtId.setText(""); txtModelo.setText("");
            }
        });

        formulario.add(new JLabel("ID Avión:")); formulario.add(txtId);
        formulario.add(new JLabel("Modelo:")); formulario.add(txtModelo);
        formulario.add(new JLabel("")); formulario.add(btnGuardar);

        add(formulario, BorderLayout.NORTH);
    }
}