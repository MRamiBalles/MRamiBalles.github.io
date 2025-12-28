/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploframe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author usuario
 */
public class MiCanvas extends Canvas {
    private int valor[] = {0,0};
    public MiCanvas(int ancho, int alto){
        this.setSize(ancho, alto);
        this.setBackground(Color.cyan);
    }
    
    @Override
    public void paint(Graphics g) {
        Image img = createImage(this.getWidth(), this.getHeight());
        Graphics og = img.getGraphics();
        Font f1 = new Font("Jokerman", Font.BOLD, 30);
        og.setFont(f1);
        og.fillOval(50, 72, 30, 30);
        og.drawString("Contador 1 = " + valor[0], 100, 100);
        Font f2 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
        og.setFont(f2);
        og.setColor(Color.red);
        og.fillRect(50, 175, 30, 30);
        og.drawString("Contador 2 = " + valor[1], 100, 200);
        g.drawImage(img, 0, 0, null);
    }
    
    public void actualiza(int contadores[]) {
        valor[0] = contadores[0];
        valor[1] = contadores[1];
        repaint();
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
}
