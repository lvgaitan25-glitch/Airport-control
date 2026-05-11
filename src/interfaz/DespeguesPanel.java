package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class DespeguesPanel extends JPanel {
    public DespeguesPanel(ControlCentral control) {
        setLayout(new FlowLayout());
        JButton btnDespegar = new JButton("Autorizar Despegue");
        JLabel lblSiguiente = new JLabel("Siguiente en cola: " + control.getCola().obtener().peek());

        btnDespegar.addActionListener(e -> {
            String avion = control.getCola().despegar();
            JOptionPane.showMessageDialog(this, "Avión " + avion + " ha despegado.");
            lblSiguiente.setText("Siguiente en cola: " + control.getCola().obtener().peek());
            control.getHistorial().guardarAccion("Despegue autorizado: " + avion);
        });

        add(new JLabel("AVIONES EN ESPERA (COLA):"));
        add(lblSiguiente);
        add(btnDespegar);
    }
}