
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Manu
 */
class CanvasRobots extends Canvas {
    private int ra1, ra2, rb1, rb2;
    private int cantidadRojo = 0, cantidadBlanco = 0;
    private int reponeRojo = 0, reponeBlanco = 0;
    
    public CanvasRobots(int alto, int ancho) {
        super.setSize(ancho, alto);
        super.setBackground(Color.white);
    } 
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    
    @Override
    public void paint(Graphics g) {
        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();
        Font f1 = new Font("Arial", Font.BOLD, 20);
        og.setFont(f1);
        
        
        g.drawImage(img, 0, 0, null);
    }
    
}
