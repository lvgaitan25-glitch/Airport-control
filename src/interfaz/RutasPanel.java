package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class RutasPanel extends JPanel {
    private ControlCentral Control;
    private JTextArea txtVisorGrafo;
    private JTextField txtOrigen, txtDestino;

    public RutasPanel(ControlCentral Control) {
        this.Control = Control;
        setBackground(new Color(21, 32, 43));
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- TITULO ---
        JLabel titulo = new JLabel("TRAFICO AEREO: RED DE RUTAS");
        titulo.setForeground(new Color(52, 152, 219));
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(titulo, BorderLayout.NORTH);

        // --- VISOR DE GRAFO (CENTRO) ---
        txtVisorGrafo = new JTextArea();
        txtVisorGrafo.setBackground(new Color(13, 23, 33));
        txtVisorGrafo.setForeground(new Color(46, 204, 113));
        txtVisorGrafo.setFont(new Font("Monospaced", Font.BOLD, 15));
        txtVisorGrafo.setEditable(false);
        txtVisorGrafo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(41, 128, 185)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(new JScrollPane(txtVisorGrafo), BorderLayout.CENTER);

        // --- PANEL DE CONTROL (SUR) ---
        JPanel panelInferior = new JPanel(new GridLayout(2, 1, 5, 5));
        panelInferior.setOpaque(false);

        // Subpanel para inputs
        JPanel subInputs = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subInputs.setOpaque(false);
        txtOrigen = crearTextField("Origen");
        txtDestino = crearTextField("Destino");
        subInputs.add(new JLabel("PUNTO A:") {{ setForeground(Color.WHITE); }});
        subInputs.add(txtOrigen);
        subInputs.add(new JLabel("PUNTO B:") {{ setForeground(Color.WHITE); }});
        subInputs.add(txtDestino);

        // Subpanel para botones
        JPanel subBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subBotones.setOpaque(false);

        JButton btnAgregar = new JButton("CREAR CONEXION");
        btnAgregar.setBackground(new Color(39, 174, 96));
        btnAgregar.setForeground(Color.WHITE);

        JButton btnEliminar = new JButton("BORRAR CONEXION");
        btnEliminar.setBackground(new Color(192, 57, 43));
        btnEliminar.setForeground(Color.WHITE);

        subBotones.add(btnAgregar);
        subBotones.add(btnEliminar);

        panelInferior.add(subInputs);
        panelInferior.add(subBotones);
        add(panelInferior, BorderLayout.SOUTH);

        // --- LOGICA ---
        btnAgregar.addActionListener(e -> {
            Control.getRutas().agregarConexion(txtOrigen.getText().toUpperCase(), txtDestino.getText().toUpperCase());
            Control.getHistorial().guardarAccion("Grafo: Nueva ruta " + txtOrigen.getText() + "-" + txtDestino.getText());
            actualizarVista();
            limpiar();
        });

        btnEliminar.addActionListener(e -> {
            Control.getRutas().eliminarConexion(txtOrigen.getText().toUpperCase(), txtDestino.getText().toUpperCase());
            Control.getHistorial().guardarAccion("Grafo: Ruta eliminada " + txtOrigen.getText() + "-" + txtDestino.getText());
            actualizarVista();
            limpiar();
        });

        actualizarVista();
    }

    public void actualizarVista() {
        txtVisorGrafo.setText(Control.getRutas().toString());
    }

    private void limpiar() {
        txtOrigen.setText("");
        txtDestino.setText("");
    }

    private JTextField crearTextField(String hint) {
        JTextField f = new JTextField(8);
        f.setBackground(new Color(28, 40, 51));
        f.setForeground(Color.WHITE);
        f.setCaretColor(Color.WHITE);
        f.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185)));
        return f;
    }
}