package interfaz;

import Control.ControlCentral;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelos.Pasajero;

public class PasajerosPanel extends JPanel {
    private ControlCentral control;
    private JTextField txtId, txtNombre, txtDestino;
    private DefaultTableModel modeloTabla;
    private JTable tablaPasajeros;

    // Colores del tema Cyber-Dark
    private final Color COLOR_FONDO = new Color(21, 32, 43);
    private final Color COLOR_COMPONENTE = new Color(13, 23, 33);
    private final Color COLOR_ACENTO = new Color(52, 152, 219);

    public PasajerosPanel(ControlCentral Control) {
        this.control = Control;
        
        setBackground(COLOR_FONDO);
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // --- ENCABEZADO ---
        JLabel lblTitulo = new JLabel("GESTIÓN DE PASAJEROS (ÁRBOL BINARIO)");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        add(lblTitulo, BorderLayout.NORTH);

        // --- FORMULARIO (ZONA SUPERIOR) ---
        JPanel panelForm = new JPanel(new GridLayout(2, 4, 10, 5));
        panelForm.setOpaque(false);

        panelForm.add(crearLabel("ID TICKET:"));
        panelForm.add(crearLabel("NOMBRE:"));
        panelForm.add(crearLabel("DESTINO:"));
        panelForm.add(new JLabel("")); // Espacio

        txtId = crearTextField();
        txtNombre = crearTextField();
        txtDestino = crearTextField();
        
        JButton btnAgregar = new JButton("REGISTRAR");
        btnAgregar.setBackground(new Color(39, 174, 96));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 12));

        panelForm.add(txtId);
        panelForm.add(txtNombre);
        panelForm.add(txtDestino);
        panelForm.add(btnAgregar);

        // --- TABLA (ZONA CENTRAL) ---
        String[] columnas = {"ID TICKET", "NOMBRE", "DESTINO"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tablaPasajeros = new JTable(modeloTabla);
        configurarEstiloTabla();
        
        JScrollPane scroll = new JScrollPane(tablaPasajeros);
        scroll.getViewport().setBackground(COLOR_COMPONENTE);
        scroll.setBorder(BorderFactory.createLineBorder(COLOR_ACENTO));

        // --- ACCIONES (ZONA INFERIOR) ---
        JButton btnBorrar = new JButton("ELIMINAR SELECCIONADO");
        btnBorrar.setBackground(new Color(192, 57, 43));
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 12));

        // Lógica de botones
        btnAgregar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                Pasajero p = new Pasajero(id, txtNombre.getText().trim(), txtDestino.getText().trim());
                control.getPasajeros().insertar(p);
                control.getHistorial().guardarAccion("Pasajero " + id + " registrado.");
                actualizarTabla();
                limpiarCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos.");
            }
        });

        btnBorrar.addActionListener(e -> {
            int fila = tablaPasajeros.getSelectedRow();
            if (fila != -1) {
                int id = (int) modeloTabla.getValueAt(fila, 0);
                control.getPasajeros().eliminar(id);
                actualizarTabla();
            }
        });

        JPanel panelCentro = new JPanel(new BorderLayout(0, 15));
        panelCentro.setOpaque(false);
        panelCentro.add(panelForm, BorderLayout.NORTH);
        panelCentro.add(scroll, BorderLayout.CENTER);
        panelCentro.add(btnBorrar, BorderLayout.SOUTH);

        add(panelCentro, BorderLayout.CENTER);
        actualizarTabla();
    }

    // --- MÉTODOS DE APOYO (ESTOS ERAN LOS QUE FALTABAN) ---

    public void actualizarTabla() {
        modeloTabla.setRowCount(0);
        List<Pasajero> lista = control.getPasajeros().getListaOrdenada();
        for (Pasajero p : lista) {
            modeloTabla.addRow(new Object[]{ p.getId(), p.getNombre(), p.getDestino() });
        }
    }

    private JLabel crearLabel(String texto) {
        JLabel l = new JLabel(texto);
        l.setForeground(new Color(144, 164, 174));
        l.setFont(new Font("Segoe UI", Font.BOLD, 11));
        return l;
    }

    private JTextField crearTextField() {
        JTextField f = new JTextField();
        f.setBackground(COLOR_COMPONENTE);
        f.setForeground(Color.WHITE);
        f.setCaretColor(Color.WHITE);
        f.setBorder(BorderFactory.createLineBorder(COLOR_ACENTO));
        return f;
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDestino.setText("");
    }

    private void configurarEstiloTabla() {
        tablaPasajeros.setBackground(COLOR_COMPONENTE);
        tablaPasajeros.setForeground(Color.WHITE);
        tablaPasajeros.setGridColor(new Color(41, 128, 185));
        tablaPasajeros.setRowHeight(30);
    }
}