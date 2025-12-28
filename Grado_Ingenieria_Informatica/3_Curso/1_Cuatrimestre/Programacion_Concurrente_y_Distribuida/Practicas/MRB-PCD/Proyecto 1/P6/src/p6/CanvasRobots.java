/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p6;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Manu
 */
public class CanvasRobots extends Canvas {
    private int ra1 = 0, ra2 = 0, rb1 = 0, rb2 = 0, rp = 0; // 0 en inicio, 1 en tanque blanco y 2 en tanque rojo
    private boolean ra1b = false, ra2b = false, rb1r = false, rb2r = false;
    private int ra1r = 0, ra2r = 0, rb1b = 0, rb2b = 0;
    private int cantidadRojo = 0, cantidadBlanco = 0;
    private int tanqueRojo, tanqueBlanco;
    
    public CanvasRobots(int alto, int ancho) {
        super.setSize(ancho, alto);
        super.setBackground(Color.blue);
        
        tanqueRojo = 0; tanqueBlanco = 0;
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
        
        og.setColor(Color.black);
        og.fillRect(0, 0, 100, 100);
        og.fillRect(786, 0, 100, 100);
        og.fillRect(0, 463, 100, 100);
        og.fillRect(786, 463, 100, 100);
        
        for(int i = 0; i < 7; i++) {
            og.drawRect(200, 200 + 20*i, 100, 20); // Tanque Blanco
        }
        for(int i = 0; i < 7; i++) {
            og.drawRect(600, 200 + 20*i, 100, 20); // Tanque Rojo
        }
        
        og.setColor(Color.yellow); // Color para TA
        if(ra1 == 0) {
            og.fillOval(25, 25, 50, 50);
            og.drawString("TA1", 27, 20);
            og.setColor(Color.black);
            og.drawOval(35, 40, 10, 10);
            og.drawOval(45, 60, 10, 10);
            og.drawOval(55, 40, 10, 10);
        } else if(ra1 == 1) {
            og.fillOval(150, 210, 50, 50);
            og.drawString("TA1", 152, 205);
            og.setColor(Color.black);
            og.drawOval(160, 225, 10, 10);
            og.drawOval(170, 245, 10, 10);
            og.drawOval(180, 225, 10, 10);
            if(ra1b = true) {
                og.setColor(Color.white);
                og.fillOval(170, 245, 10, 10);
            }
            og.setColor(Color.red);
            og.fillOval(160, 225, 10, 10);
            og.fillOval(180, 225, 10, 10);
        } else if(ra1 == 2) {
            og.fillOval(550, 210, 50, 50);
            og.drawString("TA1", 552, 205);
            og.setColor(Color.black);
            og.drawOval(560, 225, 10, 10);
            og.drawOval(570, 245, 10, 10);
            og.drawOval(580, 225, 10, 10);
            if(ra1r == 2){
                og.setColor(Color.red);
                og.fillOval(560, 225, 10, 10);
                og.fillOval(580, 225, 10, 10);
            } else if(ra1r == 1) {
                og.setColor(Color.red);
                og.fillOval(560, 225, 10, 10);
            }
        }
        
        
        og.setColor(Color.yellow); // Color para TA
        if(ra2 == 0) {
            og.fillOval(811, 25, 50, 50);
            og.drawString("TA2", 813, 20);
            og.setColor(Color.black);
            og.drawOval(821, 40, 10, 10);
            og.drawOval(831, 60, 10, 10);
            og.drawOval(841, 40, 10, 10);
        } else if(ra2 == 1) {
            og.fillOval(300, 210, 50, 50);
            og.drawString("TA2", 302, 205);
            og.setColor(Color.black);
            og.drawOval(310, 225, 10, 10);
            og.drawOval(320, 245, 10, 10);
            og.drawOval(330, 225, 10, 10);
            if(ra2b = true) {
                og.setColor(Color.white);
                og.fillOval(320, 245, 10, 10);
            }
            og.setColor(Color.red);
            og.fillOval(310, 225, 10, 10);
            og.fillOval(330, 225, 10, 10);
        } else if(ra2 == 2) {
            og.fillOval(700, 210, 50, 50);
            og.drawString("TA2", 702, 205);
            og.setColor(Color.black);
            og.drawOval(710, 225, 10, 10);
            og.drawOval(720, 245, 10, 10);
            og.drawOval(730, 225, 10, 10);
            if(ra1r == 2){
                og.setColor(Color.red);
                og.fillOval(710, 225, 10, 10);
                og.fillOval(730, 225, 10, 10);
            } else if(ra1r == 1) {
                og.setColor(Color.red);
                og.fillOval(710, 225, 10, 10);
            }
        }
        
        
        og.setColor(Color.magenta); // Color para TB
        if(rb1 == 0) {
            og.fillOval(25, 488, 50, 50);
            og.drawString("TB3", 27, 483);
            og.setColor(Color.black);
            og.drawOval(35, 503, 10, 10);
            og.drawOval(45, 523, 10, 10);
            og.drawOval(55, 503, 10, 10);
        } else if(rb1 == 1) {
            og.fillOval(150, 290, 50, 50);
            og.drawString("TB3", 152, 285);
            og.setColor(Color.black);
            og.drawOval(160, 305, 10, 10);
            og.drawOval(170, 325, 10, 10);
            og.drawOval(180, 305, 10, 10);
            if(rb1b == 2){
                og.setColor(Color.white);
                og.fillOval(160, 305, 10, 10);
                og.fillOval(180, 305, 10, 10);
            } else if(rb1b == 1) {
                og.setColor(Color.white);
                og.fillOval(160, 305, 10, 10);            
            }
        } else if(rb1 == 2) {
            og.fillOval(550, 290, 50, 50);
            og.drawString("TB3", 552, 285);
            og.setColor(Color.black);
            og.fillOval(560, 305, 10, 10);
            og.fillOval(570, 325, 10, 10);
            og.fillOval(580, 305, 10, 10);
            if(rb1r = true) {
                og.setColor(Color.red);
                og.fillOval(570, 325, 10, 10);
            }
            og.setColor(Color.white);
            og.fillOval(560, 305, 10, 10);
            og.fillOval(580, 305, 10, 10);
        }
        
        og.setColor(Color.magenta); // Color para TB
        if(rb2 == 0) {
            og.fillOval(811, 488, 50, 50);
            og.drawString("TB4", 813, 483);
            og.setColor(Color.black);
            og.drawOval(821, 503, 10, 10);
            og.drawOval(831, 523, 10, 10);
            og.drawOval(841, 503, 10, 10);
        } else if(rb2 == 1) {
            og.fillOval(300, 290, 50, 50);
            og.drawString("TB4", 302, 285);
            og.setColor(Color.black);
            og.drawOval(310, 305, 10, 10);
            og.drawOval(320, 325, 10, 10);
            og.drawOval(330, 305, 10, 10);
            if(rb2b == 2){
                og.setColor(Color.white);
                og.fillOval(310, 305, 10, 10);
                og.fillOval(330, 305, 10, 10);
            } else if(rb2b == 1) {
                og.setColor(Color.white);
                og.fillOval(310, 305, 10, 10);            
            }
        } else if(rb2 == 2) {
            og.fillOval(700, 290, 50, 50);
            og.drawString("TB4", 702, 285);
            og.setColor(Color.black);
            og.fillOval(710, 305, 10, 10);
            og.fillOval(720, 325, 10, 10);
            og.fillOval(730, 305, 10, 10);
            if(rb2r = true) {
                og.setColor(Color.red);
                og.fillOval(720, 325, 10, 10);
            }
            og.setColor(Color.white);
            og.fillOval(710, 305, 10, 10);
            og.fillOval(730, 305, 10, 10);
        }
        
        og.setColor(Color.green); // Color para TR
        if(rp == 0) {
            og.fillRect(420, 40, 80, 60);
            og.drawString("TR", 455, 65);
            
            og.setColor(Color.black);
            for(int i = 0; i < 6; i++) {
                og.drawRect(450, 40 + 10*i, 25, 10); // Huecos del reponedor
                og.drawRect(475, 40 + 10*i, 25, 10);
            }
            og.setColor(Color.white);
            for(int i = 0; i < cantidadBlanco; i++) {
                og.fillRect(450, 90 - 10*i, 24, 9); // Cantidad blanco
            }
            og.setColor(Color.red);
            for(int i = 0; i < cantidadRojo; i++) {
                og.fillRect(475, 90 - 10*i, 24, 9); // Cantidad Rojo
            }
        } else if(rp == 1) {
            og.fillRect(220, 140, 80, 60);
            og.drawString("TR", 255, 165);
            
            og.setColor(Color.black);
            for(int i = 0; i < 6; i++) {
                og.drawRect(250, 140 + 10*i, 25, 10); // Huecos del reponedor
                og.drawRect(275, 140 + 10*i, 25, 10);
            }
            og.setColor(Color.white);
            for(int i = 0; i < cantidadBlanco; i++) {
                og.fillRect(250, 190 - 10*i, 24, 9); // Cantidad blanco
            }
            og.setColor(Color.red);
            for(int i = 0; i < cantidadRojo; i++) {
                og.fillRect(275, 190 - 10*i, 24, 9); // Cantidad Rojo
            }
        } else if(rp == 2) {
            og.fillRect(620, 140, 80, 60);
            og.drawString("TR", 655, 165);
            
            og.setColor(Color.black);
            for(int i = 0; i < 6; i++) {
                og.drawRect(650, 140 + 10*i, 25, 10); // Huecos del reponedor
                og.drawRect(675, 140 + 10*i, 25, 10);
            }
            og.setColor(Color.red);
            for(int i = 0; i < cantidadRojo; i++) {
                og.fillRect(675, 190 - 10*i, 24, 9); // Cantidad Rojo
            }
        }
        
        og.setColor(Color.white);
        for(int i = 0; i < tanqueBlanco; i++) {
            og.fillRect(200, 340 - 20*i, 99, 19); // Tanque Blanco
        }
            
        og.setColor(Color.red);
        for(int i = 0; i < tanqueRojo; i++) {
            og.fillRect(600, 340 - 20*i, 99, 19); // Tanque Rojo
        }
        g.drawImage(img, 0, 0, null);
    }

    public synchronized void enInicioA(int id) {
        if(id == 1) {
            ra1 = 0;
            ra1r = 0;
            ra1b = false;
        } else if(id == 2) {
            ra2 = 0;
            ra2r = 0;
            ra2b = false;
        }
        repaint();
    }
    public synchronized void enRojoA(int id) {
        if(id == 1) {
            ra1 = 2;
        } else if(id == 2) {
            ra2 = 2;
        }
        //tanqueRojo--;
        repaint();
    }
    public synchronized void enBlancoA(int id) {
        if(id == 1) {
            ra1 = 1;
        } else if(id == 2) {
            ra2 = 1;
        }
        //tanqueBlanco--;
        repaint();
    }
    
    public synchronized void enInicioB(int id) {
        if (id == 3) {
            rb1 = 0;
            rb1r = false;
            rb1b = 0;
        } else if(id == 4) {
            rb2 = 0;
            rb2r = false;
            rb2b = 0;
        }
        repaint();
    }
    public synchronized void enBlancoB(int id) {
        if(id == 3) {
            rb1 = 1;
        } else if(id == 4) {
            rb2 = 1;
        }
        //tanqueBlanco--;
        repaint();
    }
    public synchronized void enRojoB(int id) {
        if(id == 3) {
            rb1 = 2;
        } else if(id == 4) {
            rb2 = 2;
        }
        //tanqueRojo--;
        repaint();
    }

    public synchronized void reponeInicioCargado(int CantidadBlanco, int CantidadRojo) {
        cantidadBlanco = CantidadBlanco;
        cantidadRojo = CantidadRojo;
        rp = 0;
        repaint();
    }

    public synchronized void reponeBlanco() {
        rp = 1;
        tanqueBlanco++;
        cantidadBlanco--;
        repaint();
    }

    public synchronized void reponeRojo() {
        rp = 2;
        tanqueRojo++;
        cantidadRojo--;
        repaint();
    }

    public synchronized void reponeInicioVacio() {
        cantidadRojo = 0;
        rp = 0;
        repaint();
    }

    public void cogeR(int id) {
        if(id == 1) {
            ra1r++;
        } else if(id == 2) {
            ra2r++;
        } else if(id == 3) {
            rb1r = true;
        } else if(id == 4) {
            rb2r = true;
        } 
        tanqueRojo--;
        repaint();
    }
    
    public void cogeB(int id) {
        if(id == 1) {
            ra1b = true;
        } else if(id == 2) {
            ra2b = true;
        } else if(id == 3) {
            rb1b++;
        } else if(id == 4) {
            rb2b++;
        } 
        tanqueBlanco--;
        repaint();
    }
}
