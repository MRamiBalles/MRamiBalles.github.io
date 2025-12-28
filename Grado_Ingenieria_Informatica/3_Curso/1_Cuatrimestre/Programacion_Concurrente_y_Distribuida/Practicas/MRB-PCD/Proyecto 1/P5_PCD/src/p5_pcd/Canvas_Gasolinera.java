/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p5_pcd;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Manu
 */
public class Canvas_Gasolinera extends Canvas {
    private ArrayList<Integer> colaCa = new ArrayList<>();
    private ArrayList<Integer> colaCo = new ArrayList<>();
    private int idc1 = -1, idc2 = -1, idc3 = -1, idc4 = -1;
    private char tipoc1 = 'n', tipoc2 = 'n', tipoc3 = 'n', tipoc4 = 'n';
    
    public Canvas_Gasolinera(int ancho, int alto) {
        super.setSize(ancho, alto);
        super.setBackground(Color.white);
    }

    public synchronized void  EnColaCamion(int id) {
        colaCa.add(id);
        repaint();
    }

    public synchronized void  EnColaCoche(int id) {
        colaCo.add(id);
        repaint();
    }

    public synchronized void  RepostandoCamion(int id, int cual) {
        colaCa.remove((Object) id); // Integer.valueOf(id)
        if(cual == 1) {
            idc1 = id;
            tipoc1 = 'a'; // Camion
        } else if(cual == 4) {
            idc4 = id;
            tipoc4 = 'a'; // Camion
        } else { // Cual == 2 -> Centros
            idc2 = id;
            idc3 = id;
            tipoc2 = 'a'; // Camion
            tipoc3 = 'a';
        }
        repaint();
    }

    public synchronized void  RepostandoCoche(int id, int cual) {
        colaCo.remove((Object) id); 
        if(cual == 1) {
            idc1 = id;
            tipoc1 = 'o'; // Coche
        } else if(cual == 4) {
            idc4 = id;
            tipoc4 = 'o'; // Coche
        } else if(cual == 2) {
            idc2 = id;
            tipoc2 = 'o';
        } else { // Cual == 3
            idc3 = id;
            tipoc3 = 'o';
        }
        repaint();
    }

    public synchronized void terminaCamion(int id) {
        if(id == idc1) {
            idc1 = -1;
            tipoc1 = 'n';
        } else if(id == idc4) { 
            idc4 = -1;
            tipoc4 = 'n';
        } else { // centros
            idc2 = -1;
            idc3 = -1;
            tipoc2 = 'n';
            tipoc3 = 'n';
        }
        repaint();
    }

    public synchronized void terminaCoche(int id) {
        if(id == idc1) {
            idc1 = -1;            
            tipoc1 = 'n';
        } else if (id == idc2) {
            idc2 = -1;            
            tipoc2 = 'n';
        } else if (id == idc3) {
            idc3 = -1;            
            tipoc3 = 'n';
        } else {
            idc4 = -1;
            tipoc4 = 'n';
        }
        repaint();
    }
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    
    @Override
    public void paint(Graphics g) {
        Image img = createImage(getWidth(), getHeight());
        Font f1 = new Font("Arial", Font.BOLD, 20);
        Graphics og = img.getGraphics();
        og.setFont(f1);
        
        og.setColor(Color.black);
        og.drawString("Gasolinera de Coches y Camiones", 300, 50);
        og.drawString("Cola de Coches", 150, 160);
        og.drawString("Cola de Camiones", 150, 360);
        
        // Dibujar colas y calles
        og.fillRect(0, 200, 400, 50);
        og.fillRect(0, 400, 400, 50);
        
        og.fillRect(500, 150, 250, 50);
        og.fillRect(500, 250, 250, 50);
        og.fillRect(500, 350, 250, 50);
        og.fillRect(500, 450, 250, 50);
        
        // Dibujar surtidores 
        og.setColor(Color.red);
        og.fillRect(600, 150, 50, 30);       
        og.fillRect(530, 270, 50, 30);
        og.fillRect(670,350, 50, 30);
        og.fillRect(600, 470, 50, 30);

        if(!colaCa.isEmpty()) {
            for(int i = 0; i < colaCa.size(); i++) {
                og.setColor(Color.black);
                og.drawString("Ca" + colaCa.get(i), 360 - 60*i, 390);
                og.setColor(Color.blue);
                og.fillRect(360 - 60*i, 400, 40, 20);
            }
        } 
        
        if(!colaCo.isEmpty()) {
            for(int i = 0; i < colaCo.size(); i++) {
                og.setColor(Color.black);
                og.drawString("Co" + colaCo.get(i), 360 - 50*i, 190);
                og.setColor(Color.yellow);
                og.fillRect(360 - 50*i, 200, 20, 10);
            }
        } 

        if(idc1 != -1) {
            if(tipoc1 == 'a') {
                og.setColor(Color.black);
                og.drawString("Ca" + idc1, 600, 120);
                og.setColor(Color.blue);
                og.fillRect(600, 130, 40, 20);
            } else { //tipoc1 == coche
                og.setColor(Color.black);
                og.drawString("Co" + idc1, 590, 130);
                og.setColor(Color.yellow);
                og.fillRect(600, 140, 20, 10);
            }
        }
        
        if(idc2 != -1) {
            if(tipoc2 == 'a') {
                og.setColor(Color.black);
                og.drawString("Ca" + idc2, 530, 350);
                og.setColor(Color.blue);
                og.fillRect(530, 300, 40, 20);
            } else { //tipoc1 == coche
                og.setColor(Color.black);
                og.drawString("Co" + idc2, 520, 330);
                og.setColor(Color.yellow);
                og.fillRect(530, 300, 20, 10);
            }
        } 
        
        if(idc3 != -1) {
            if(tipoc3 == 'a') {
                //og.setColor(Color.black);
                //og.drawString("Ca" + idc3, 670, 320);
                //og.setColor(Color.blue);
                //og.fillRect(670, 330, 40, 20);
            } else { //tipoc1 == coche
                og.setColor(Color.black);
                og.drawString("Co" + idc3, 660, 330);
                og.setColor(Color.yellow);
                og.fillRect(670, 340, 20, 10);
            }
        }
        
        if(idc4 != -1) {
            if(tipoc4 == 'a') {
                og.setColor(Color.black);
                og.drawString("Ca" + idc4, 600, 540);
                og.setColor(Color.blue);
                og.fillRect(600, 500, 40, 20);
            } else { //tipoc1 == coche
                og.setColor(Color.black);
                og.drawString("Co" + idc4, 590, 530);
                og.setColor(Color.yellow);
                og.fillRect(600, 500, 20, 10);
            }
        } 
        
        g.drawImage(img, 0, 0, null);
    }
}
