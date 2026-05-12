package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AvionesPanel extends JPanel {
    private ControlCentral Control;
    private JTextField txtPlaca, txtModelo, txtFila, txtCol;
    private DefaultTableModel modeloTabla;

    public AvionesPanel(ControlCentral Control) {
        this.Control = Control;
        setBackground(new Color(21, 32, 43));
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Formulario
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.setOpaque(false);

        panelForm.add(new JLabel("MATRÍCULA:") {{ setForeground(Color.WHITE); }});
        txtPlaca = new JTextField();
        panelForm.add(txtPlaca);

        panelForm.add(new JLabel("MODELO:") {{ setForeground(Color.WHITE); }});
        txtModelo = new JTextField();
        panelForm.add(txtModelo);

        panelForm.add(new JLabel("FILA HANGAR (0-4):") {{ setForeground(Color.WHITE); }});
        txtFila = new JTextField();
        panelForm.add(txtFila);

        panelForm.add(new JLabel("COL HANGAR (0-4):") {{ setForeground(Color.WHITE); }});
        txtCol = new JTextField();
        panelForm.add(txtCol);

        JButton btnAgregar = new JButton("REGISTRAR AVIÓN");
        btnAgregar.setBackground(new Color(46, 204, 113));
        btnAgregar.setForeground(Color.WHITE);
        panelForm.add(btnAgregar);

        // Tabla
        String[] col = {"MATRÍCULA", "MODELO", "UBICACIÓN"};
        modeloTabla = new DefaultTableModel(col, 0);
        JTable tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelForm, BorderLayout.WEST);

        // LÓGICA CORREGIDA
        btnAgregar.addActionListener(e -> {
            try {
                String placa = txtPlaca.getText().toUpperCase().trim();
                String modelo = txtModelo.getText().trim();
                int f = Integer.parseInt(txtFila.getText().trim());
                int c = Integer.parseInt(txtCol.getText().trim());

                if (Control.getRadar().estaOcupado(f, c)) {
                    JOptionPane.showMessageDialog(this, "Hangar ocupado.");
                } else {
                    // 1. Ocupar en matriz lógica
                    Control.getRadar().ocuparHangar(f, c);
                    // 2. Registrar en lista de hangares (Persistencia)
                    Control.registrarAvionHangar(placa); 
                    // 3. Actualizar Interfaz e Historial
                    modeloTabla.addRow(new Object[]{placa, modelo, "["+f+","+c+"]"});
                    Control.getHistorial().guardarAccion("Avión " + placa + " registrado.");
                    limpiarCampos();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos.");
            }
        });
    }

    private void limpiarCampos() {
        txtPlaca.setText(""); txtModelo.setText(""); txtFila.setText(""); txtCol.setText("");
    }
}