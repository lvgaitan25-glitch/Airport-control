package interfaz;

import Control.ControlCentral;
import java.awt.*;
import javax.swing.*;

public class DespeguePanel extends JPanel {

    private ControlCentral Control;

    private DefaultListModel<String> modeloLista;
    private JList<String> listaVisual;

    // Combo con aviones registrados en hangares
    private JComboBox<String> comboAviones;

    private GrafoColaPanel grafoPanel;

    public DespeguePanel(ControlCentral Control) {

        this.Control = Control;

        setLayout(new BorderLayout(15, 15));

        setBackground(new Color(21, 32, 43));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20));

        // =====================================================
        // TÍTULO
        // =====================================================

        JLabel titulo =
                new JLabel(
                        "GESTIÓN DE DESPEGUE - COLA FIFO");

        titulo.setForeground(
                new Color(52, 152, 219));

        titulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22));

        // =====================================================
        // PANEL SUPERIOR
        // =====================================================

        JPanel panelSuperior =
                new JPanel(new BorderLayout(10, 10));

        panelSuperior.setBackground(
                new Color(21, 32, 43));

        // =====================================================
        // COMBO DE AVIONES
        // =====================================================

        comboAviones = new JComboBox<>();

        comboAviones.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14));

        actualizarComboAviones();

        // =====================================================
        // BOTÓN AGREGAR A COLA
        // =====================================================

        JButton btnAgregar =
                new JButton("ENVIAR A DESPEGUE");

        btnAgregar.setBackground(
                new Color(52, 152, 219));

        btnAgregar.setForeground(Color.WHITE);

        btnAgregar.setFocusPainted(false);

        btnAgregar.addActionListener(e -> {

            String avion =
                    (String) comboAviones.getSelectedItem();

            if (avion != null) {

                // Evitar duplicados
                if (!Control.getColaDespegue()
                        .contains(avion)) {

                    Control.encolarAvion(avion);

                    Control.getHistorial()
                            .guardarAccion(
                                    "Avión enviado a despegue: "
                                            + avion);

                    actualizarLista();

                    grafoPanel.repaint();

                    JOptionPane.showMessageDialog(
                            this,
                            "Avión agregado a cola:\n"
                                    + avion);

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Ese avión ya está en cola.");
                }

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No hay aviones registrados.");
            }
        });

        panelSuperior.add(
                comboAviones,
                BorderLayout.CENTER);

        panelSuperior.add(
                btnAgregar,
                BorderLayout.EAST);

        // =====================================================
        // PANEL CENTRAL
        // =====================================================

        JPanel panelCentral =
                new JPanel(
                        new GridLayout(1, 2, 15, 15));

        panelCentral.setBackground(
                new Color(21, 32, 43));

        // =====================================================
        // LISTA VISUAL
        // =====================================================

        modeloLista = new DefaultListModel<>();

        listaVisual = new JList<>(modeloLista);

        listaVisual.setBackground(
                new Color(13, 23, 33));

        listaVisual.setForeground(Color.WHITE);

        listaVisual.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        14));

        JScrollPane scroll =
                new JScrollPane(listaVisual);

        // =====================================================
        // PANEL DEL GRAFO
        // =====================================================

        grafoPanel =
                new GrafoColaPanel(Control);

        panelCentral.add(scroll);

        panelCentral.add(grafoPanel);

        // =====================================================
        // BOTÓN DESPEGAR
        // =====================================================

        JButton btnDespegar =
                new JButton(
                        "AUTORIZAR SIGUIENTE DESPEGUE");

        btnDespegar.setBackground(
                new Color(39, 174, 96));

        btnDespegar.setForeground(Color.WHITE);

        btnDespegar.setFocusPainted(false);

        btnDespegar.addActionListener(e -> {

            String avion =
                    Control.despacharAvion();

            if (avion != null) {

                Control.getHistorial()
                        .guardarAccion(
                                "Avión despegó: "
                                        + avion);

                actualizarLista();

                grafoPanel.repaint();

                JOptionPane.showMessageDialog(
                        this,
                        "Despegue autorizado:\n"
                                + avion);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No hay aviones en espera.");
            }
        });

        // =====================================================
        // BOTÓN CANCELAR
        // =====================================================

        JButton btnCancelar =
                new JButton(
                        "CANCELAR DESPEGUE");

        btnCancelar.setBackground(
                new Color(192, 57, 43));

        btnCancelar.setForeground(Color.WHITE);

        btnCancelar.setFocusPainted(false);

        btnCancelar.addActionListener(e -> {

            String avionSeleccionado =
                    listaVisual.getSelectedValue();

            if (avionSeleccionado != null) {

                avionSeleccionado =
                        avionSeleccionado
                                .replace("✈ ", "");

                Control.getColaDespegue()
                        .remove(avionSeleccionado);

                Control.getHistorial()
                        .guardarAccion(
                                "Despegue cancelado: "
                                        + avionSeleccionado);

                actualizarLista();

                grafoPanel.repaint();

                JOptionPane.showMessageDialog(
                        this,
                        "Despegue cancelado:\n"
                                + avionSeleccionado);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione un avión.");
            }
        });

        // =====================================================
        // PANEL BOTONES
        // =====================================================

        JPanel panelBotones =
                new JPanel(
                        new GridLayout(1, 2, 10, 10));

        panelBotones.setBackground(
                new Color(21, 32, 43));

        panelBotones.add(btnDespegar);

        panelBotones.add(btnCancelar);

        // =====================================================
        // CONTENEDOR SUPERIOR
        // =====================================================

        JPanel contenedorSuperior =
                new JPanel(new BorderLayout());

        contenedorSuperior.setBackground(
                new Color(21, 32, 43));

        contenedorSuperior.add(
                titulo,
                BorderLayout.NORTH);

        contenedorSuperior.add(
                panelSuperior,
                BorderLayout.SOUTH);

        // =====================================================
        // AGREGAR COMPONENTES
        // =====================================================

        add(contenedorSuperior,
                BorderLayout.NORTH);

        add(panelCentral,
                BorderLayout.CENTER);

        add(panelBotones,
                BorderLayout.SOUTH);

        actualizarLista();
    }

    // =====================================================
    // ACTUALIZAR LISTA
    // =====================================================

    public void actualizarLista() {

        modeloLista.clear();

        if (Control.getColaDespegue() != null) {

            for (String avion :
                    Control.getColaDespegue()) {

                modeloLista.addElement(
                        "✈ " + avion);
            }
        }
    }

    // =====================================================
    // ACTUALIZAR COMBO DE AVIONES
    // =====================================================

    public void actualizarComboAviones() {

        comboAviones.removeAllItems();

        for (String avion :
                Control.getHangares()) {

            comboAviones.addItem(avion);
        }
    }

    // =====================================================
    // PANEL GRAFO
    // =====================================================

    class GrafoColaPanel extends JPanel {

        private ControlCentral Control;

        public GrafoColaPanel(
                ControlCentral Control) {

            this.Control = Control;

            setBackground(
                    new Color(13, 23, 33));
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g;

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int x = 30;

            int y = getHeight() / 2;

            int anchoNodo = 110;

            int altoNodo = 45;

            int espacio = 50;

            int i = 0;

            for (String avion :
                    Control.getColaDespegue()) {

                int nodoX =
                        x + (i * (anchoNodo + espacio));

                // Línea
                if (i <
                        Control.getColaDespegue().size() - 1) {

                    g2.setColor(Color.WHITE);

                    g2.drawLine(
                            nodoX + anchoNodo,
                            y + 22,
                            nodoX + anchoNodo + espacio,
                            y + 22);
                }

                // Nodo
                g2.setColor(
                        new Color(52, 152, 219));

                g2.fillRoundRect(
                        nodoX,
                        y,
                        anchoNodo,
                        altoNodo,
                        20,
                        20);

                // Texto
                g2.setColor(Color.WHITE);

                g2.setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                12));

                g2.drawString(
                        avion,
                        nodoX + 10,
                        y + 27);

                i++;
            }

            // Título grafo
            g2.setColor(
                    new Color(39, 174, 96));

            g2.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18));

            g2.drawString(
                    "COLA FIFO",
                    20,
                    40);
        }
    }
}