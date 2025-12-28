/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7;

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
public class CanvasPool extends Canvas {
    private ArrayList<Integer> colaCiviles = new ArrayList<Integer>();
    private ArrayList<Integer> colaMilitares = new ArrayList<Integer>();
    private int idGarita = -1, idEscaner = -1, idArco = -1, idPasilloC = -1, idPasilloM1 = -1, idPasilloM2 = -1;
    private char tipoArco = 'n'; // ninguno inicialmente
    
    public CanvasPool(int alto, int ancho) {
        super.setSize(alto, ancho);
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
        og.setColor(Color.blue);
        og.drawString("Cola de militares", 640, 90);
        og.setColor(Color.red);
        og.drawString("Cola de civiles", 640, 290);
        
        og.setColor(Color.black);
        og.fillRect(500, 100, 400, 100); // Cola para militares
        og.fillRect(500, 300, 400, 100); // Cola para civiles
        
        og.drawString("Garita", 355, 90);
        og.fillRect(340, 100, 100, 100);
        og.drawString("Escaner", 350, 290);
        og.fillRect(340, 300, 100, 100);
        og.drawString("Arco", 170, 240);
        og.fillRect(150, 250, 100, 100); 
        
        og.setColor(Color.red);
        if(!colaCiviles.isEmpty()) {
            for(int i = 0; i < colaCiviles.size(); i++) {
                og.drawString(String.valueOf(colaCiviles.get(i)), 513 + 30*i, 370);
                og.fillOval(510 + 30*i, 380, 20, 20);
            }
        }
        if(idEscaner != -1) {
            og.drawString(String.valueOf(idEscaner), 378, 340);
            og.fillOval(375, 350, 20, 20);
        }
        if(idPasilloC != -1){
            og.drawString(String.valueOf(idPasilloC), 288, 310);
            og.fillOval(285, 320, 20, 20);
        }
        
        og.setColor(Color.blue);
        if(!colaMilitares.isEmpty()) {
            for(int i = 0; i < colaMilitares.size(); i++) {
                og.drawString(String.valueOf(colaMilitares.get(i)), 513 + 30*i, 170);
                og.fillOval(510 + 30*i, 180, 20, 20);
            }
        }
        if(idGarita != -1) {
            og.drawString(String.valueOf(idGarita), 378, 140);
            og.fillOval(375, 150, 20, 20);
        }
        if(idPasilloM2 != -1) {
            og.drawString(String.valueOf(idPasilloM2), 308, 170);
            og.fillOval(305, 180, 20, 20);
        }
        if(idPasilloM1 != -1) {
            og.drawString(String.valueOf(idPasilloM1), 268, 200);
            og.fillOval(265, 210, 20, 20);
        }
        
        if(idArco != -1) {
            if(tipoArco == 'c') {
                og.setColor(Color.red);
            } else if(tipoArco == 'm'){
                og.setColor(Color.blue);
            }
            og.drawString(String.valueOf(idArco), 203, 270);
            og.fillOval(200, 280, 20, 20);
        }
        
        g.drawImage(img, 0, 0, null);
    }

    public synchronized void EnColaMilitar(int id) {
        colaMilitares.add(id);
        repaint();
    }
    
    public synchronized void EnColaCivil(int id) {
        colaCiviles.add(id);
        repaint();
    }

    public synchronized void EnGarita(int id) {
        colaMilitares.remove((Object) id);
        idGarita = id;
        repaint();
    }
    
    public synchronized void EnEscaner(int id) {
        colaCiviles.remove((Object) id);
        idEscaner = id;
        repaint();
    }

    public synchronized void EnPasilloGarita() {
        if (idPasilloM1 == -1) {
            idPasilloM1 = idGarita;
        } else if (idPasilloM2 == -1) {
            idPasilloM2 = idGarita;
        }
        idGarita = -1;
        repaint();
    }
    
    public synchronized void EnPasilloEscaner() {
        idPasilloC = idEscaner;
        idEscaner = -1;
        repaint();
    }

    public synchronized void EnArco(int id, char tipo) {
        if(tipo == 'c') {
            idPasilloC = -1;
        } else if(tipo == 'm') {
            if(id == idPasilloM1) {
                idPasilloM1 = -1;
            } else if(id == idPasilloM2) {
                idPasilloM2 = -1;
            }
        }
        tipoArco = tipo;
        idArco = id;
        repaint();
    }

    public synchronized void SaleArco() {
        tipoArco = 'n';
        idArco = -1;
        repaint();
    }
}
