package interfaz;

import Control.ControlCentral;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import javax.swing.*;

public class DashboardPanel extends JPanel {
    private ControlCentral Control;
    private double anguloRadar = 0; 

    public DashboardPanel(ControlCentral Control) {
        this.Control = Control;
        setBackground(new Color(13, 23, 33));
        setLayout(new BorderLayout());

        Timer timerRadar = new Timer(40, e -> {
            anguloRadar -= 0.06; 
            if (anguloRadar < -Math.PI * 2) anguloRadar = 0;
            repaint();
        });
        timerRadar.start();
    }

    public void actualizarEstadisticas() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2 - 60; 
        int radioMax = 160;

        // 1. ANILLOS DEL RADAR
        g2.setStroke(new BasicStroke(1f));
        g2.setColor(new Color(46, 204, 113, 40)); 
        for (int r = 40; r <= radioMax; r += 40) {
            g2.drawOval(centroX - r, centroY - r, r * 2, r * 2);
        }

        // 2. ESTELA DE BARRIDO (Simulada con arcos degradados)
        for (int i = 0; i < 60; i++) {
            float alpha = (60 - i) / 60f * 0.3f;
            g2.setColor(new Color(46, 204, 113, (int)(alpha * 255)));
            double ang = Math.toDegrees(-anguloRadar) - i;
            g2.fill(new Arc2D.Double(centroX - radioMax, centroY - radioMax, radioMax * 2, radioMax * 2, ang, 1, Arc2D.PIE));
        }

        // 3. PUNTOS DE PRESENCIA
        g2.setColor(new Color(100, 255, 170, 200));
        g2.fillOval(centroX + 80, centroY - 70, 6, 6);   
        g2.fillOval(centroX - 100, centroY + 60, 6, 6);  
        g2.fillOval(centroX + 30, centroY + 110, 6, 6);  

        // 4. DIBUJO MANUAL DEL AVIÓN CENTRAL (Para evitar el cuadro de error)
        dibujarAvion(g2, centroX, centroY, 30, new Color(46, 204, 113), -45);

        // 5. LÍNEA PRINCIPAL
        int xDestino = centroX + (int) (radioMax * Math.cos(anguloRadar));
        int yDestino = centroY + (int) (radioMax * Math.sin(anguloRadar));
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(new Color(150, 255, 200)); 
        g2.drawLine(centroX, centroY, xDestino, yDestino);
        g2.fillOval(xDestino - 4, yDestino - 4, 8, 8);

        // 6. LOGOTIPO INFERIOR
        int yBase = centroY + radioMax + 70;
        
        // Dibujar avión pequeño azul del logo (Manual)
        dibujarAvion(g2, centroX - 90, yBase - 15, 20, new Color(52, 152, 219), -45);
        
        g2.setFont(new Font("SansSerif", Font.BOLD, 22));
        g2.setColor(Color.WHITE);
        g2.drawString("CONTROL ", centroX - 30, yBase - 10);
        g2.setColor(new Color(52, 152, 219));
        g2.drawString("AÉREO", centroX + 80, yBase - 10);
        
        g2.setColor(new Color(52, 152, 219, 100));
        g2.drawLine(centroX - 220, yBase - 18, centroX - 120, yBase - 18); 
        g2.drawLine(centroX + 170, yBase - 18, centroX + 270, yBase - 18); 

        g2.setFont(new Font("SansSerif", Font.BOLD, 26));
        g2.setColor(Color.WHITE);
        String t1 = "CENTRO DE MONITOREO AÉREO";
        g2.drawString(t1, centroX - g2.getFontMetrics().stringWidth(t1)/2, yBase + 35);

        g2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g2.setColor(new Color(150, 150, 150));
        String t2 = "Control de vuelos • Radar • Pasajeros • Rutas";
        g2.drawString(t2, centroX - g2.getFontMetrics().stringWidth(t2)/2, yBase + 60);
    }

    // Método para dibujar un avión vectorial
    private void dibujarAvion(Graphics2D g2, int x, int y, int size, Color color, int rotationDeg) {
        g2.setColor(color);
        Graphics2D gCopy = (Graphics2D) g2.create();
        gCopy.translate(x, y);
        gCopy.rotate(Math.toRadians(rotationDeg));
        
        Path2D path = new Path2D.Double();
        path.moveTo(0, -size/2); // Punta
        path.lineTo(size/10, -size/10);
        path.lineTo(size/2, size/10); // Ala derecha
        path.lineTo(size/2, size/4);
        path.lineTo(size/10, size/6);
        path.lineTo(size/10, size/2.5);
        path.lineTo(size/4, size/2); // Cola derecha
        path.lineTo(-size/4, size/2); // Cola izquierda
        path.lineTo(-size/10, size/2.5);
        path.lineTo(-size/10, size/6);
        path.lineTo(-size/2, size/4); // Ala izquierda
        path.lineTo(-size/2, size/10);
        path.lineTo(-size/10, -size/10);
        path.closePath();
        
        gCopy.fill(path);
        gCopy.dispose();
    }
}