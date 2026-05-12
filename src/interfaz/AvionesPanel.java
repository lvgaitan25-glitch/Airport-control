package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AvionesPanel extends JPanel {
    private ControlCentral Control;
    private DefaultTableModel modeloTabla;
    private JTextField txtMatricula, txtModelo;

    public AvionesPanel(ControlCentral Control) {
        this.Control = Control;
        
        setBackground(new Color(21, 32, 43));
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- ENCABEZADO ---
        JLabel titulo = new JLabel("REGISTRO DE AERONAVES Y ASIGNACIÓN DE HANGAR");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        // --- FORMULARIO ---
        JPanel panelForm = new JPanel(new GridLayout(2, 3, 10, 5));
        panelForm.setOpaque(false);

        panelForm.add(crearLabel("PLACA / MATRÍCULA:"));
        panelForm.add(crearLabel("MODELO DEL AVIÓN:"));
        panelForm.add(new JLabel("")); 

        txtMatricula = crearTextField();
        txtModelo = crearTextField();
        
        JButton btnAgregar = new JButton("ASIGNAR HANGAR");
        btnAgregar.setBackground(new Color(39, 174, 96));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 12));

        panelForm.add(txtMatricula);
        panelForm.add(txtModelo);
        panelForm.add(btnAgregar);

        // --- TABLA ---
        String[] columnas = {"MATRÍCULA", "MODELO", "UBICACIÓN EN MATRIZ"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        JTable tabla = new JTable(modeloTabla);
        tabla.setBackground(new Color(28, 40, 51));
        tabla.setForeground(Color.WHITE);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(new Color(21, 32, 43));

        add(panelForm, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // --- LÓGICA DEL BOTÓN ---
        btnAgregar.addActionListener(e -> {
            String placa = txtMatricula.getText().trim().toUpperCase();
            String modelo = txtModelo.getText().trim();

            if (placa.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar Placa y Modelo.");
                return;
            }

            try {
                String inputF = JOptionPane.showInputDialog(this, "Fila Hangar (0-4):");
                String inputC = JOptionPane.showInputDialog(this, "Columna Hangar (0-4):");
                
                if (inputF == null || inputC == null) return;

                int f = Integer.parseInt(inputF);
                int c = Integer.parseInt(inputC);

                if (Control.getRadar().estaOcupado(f, c)) {
                    JOptionPane.showMessageDialog(this, "Hangar [" + f + "," + c + "] ocupado.");
                } else {
                    Control.getRadar().ocuparHangar(f, c);
                    modeloTabla.addRow(new Object[]{ placa, modelo, "["+f+","+c+"]" });
                    Control.getHistorial().guardarAccion("Avión " + placa + " en Hangar ["+f+","+c+"]");
                    
                    txtMatricula.setText("");
                    txtModelo.setText("");
                    JOptionPane.showMessageDialog(this, "Asignado con éxito.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Use números del 0 al 4.");
            }
        });
    }

    // --- MÉTODOS AYUDANTES (ESTOS ERAN LOS QUE FALTABAN) ---

    private JLabel crearLabel(String texto) {
        JLabel l = new JLabel(texto);
        l.setForeground(new Color(144, 164, 174));
        l.setFont(new Font("Segoe UI", Font.BOLD, 11));
        return l;
    }

    private JTextField crearTextField() {
        JTextField f = new JTextField();
        f.setBackground(new Color(13, 23, 33));
        f.setForeground(Color.WHITE);
        f.setCaretColor(Color.WHITE);
        f.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185)));
        return f;
    }
} 