package interfaz;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Cyber-Airport Control - Login");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Colores del tema
        Color fondo = new Color(13, 23, 33);
        Color acento = new Color(41, 128, 185);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(fondo);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));

        JLabel lblLogo = new JLabel("✈", SwingConstants.CENTER);
        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 90));
        lblLogo.setForeground(acento);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTitulo = new JLabel("CYBER-AIRPORT");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campos estilizados
        JTextField txtUser = new JTextField();
        txtUser.setBackground(new Color(21, 32, 43));
        txtUser.setForeground(Color.WHITE);
        txtUser.setCaretColor(Color.WHITE);
        txtUser.setBorder(BorderFactory.createLineBorder(acento));

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBackground(new Color(21, 32, 43));
        txtPass.setForeground(Color.WHITE);
        txtPass.setBorder(BorderFactory.createLineBorder(acento));

        JButton btnLogin = new JButton("INICIAR SESIÓN");
        btnLogin.setBackground(acento);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.add(lblLogo);
        panel.add(lblTitulo);
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(crearLabel("USUARIO"));
        panel.add(txtUser);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(crearLabel("CONTRASEÑA"));
        panel.add(txtPass);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> {
            new VentanaPrincipal().setVisible(true);
            this.dispose();
        });
    }

    private JLabel crearLabel(String t) {
        JLabel l = new JLabel(t);
        l.setForeground(new Color(144, 164, 174));
        l.setFont(new Font("Segoe UI", Font.BOLD, 10));
        return l;
    }
}