package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;
import modelos.Pasajero; // Importamos tu clase Pasajero

public class PasajerosPanel extends JPanel {
    private ControlCentral control;
    private JTextField txtTicket, txtNombre, txtDestino;

    public PasajerosPanel(ControlCentral control) {
        this.control = control;
        setLayout(new BorderLayout());

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(4, 2, 10, 10));
        txtTicket = new JTextField();
        txtNombre = new JTextField();
        txtDestino = new JTextField();
        JButton btnRegistrar = new JButton("Registrar");

        formulario.add(new JLabel("Ticket (Número):"));
        formulario.add(txtTicket);
        formulario.add(new JLabel("Nombre:"));
        formulario.add(txtNombre);
        formulario.add(new JLabel("Destino:"));
        formulario.add(txtDestino);
        formulario.add(new JLabel(""));
        formulario.add(btnRegistrar);

        // EVENTO DEL BOTÓN
        btnRegistrar.addActionListener(e -> {
            try {
                // 1. Extraemos los datos de la interfaz
                int numTicket = Integer.parseInt(txtTicket.getText());
                String nom = txtNombre.getText();
                String des = txtDestino.getText();

                // 2. CREAMOS EL OBJETO (Esto es lo que pedía tu error)
                Pasajero p = new Pasajero(numTicket, nom, des);

                // 3. ENVIAMOS EL OBJETO AL ÁRBOL
                control.getPasajeros().insertar(p);

                // 4. Guardamos en el historial
                control.getHistorial().guardarAccion("Registrado: " + nom);

                JOptionPane.showMessageDialog(this, "Pasajero registrado con éxito.");
                
                // Limpiar campos
                txtTicket.setText("");
                txtNombre.setText("");
                txtDestino.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: El ticket debe ser un número.");
            }
        });

        add(new JLabel("GESTIÓN DE PASAJEROS", JLabel.CENTER), BorderLayout.NORTH);
        add(formulario, BorderLayout.CENTER);
    }
}