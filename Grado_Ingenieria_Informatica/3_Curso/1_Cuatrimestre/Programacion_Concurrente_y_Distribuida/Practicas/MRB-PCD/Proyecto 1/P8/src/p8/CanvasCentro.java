/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p8;

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
public class CanvasCentro extends Canvas {

    private ArrayList<Integer> colaNormales = new ArrayList<>();
    private ArrayList<Integer> colaInfecciosos = new ArrayList<>();
    private boolean hayVirus = false, limpiando = false;
    private int huecoSala1 = -1, huecoSala2 = -1, huecoSala3 = -1;
    private char tipoSala1 = 'v', tipoSala2 = 'v', tipoSala3 = 'v';

    public CanvasCentro(int alto, int ancho) {
        super.setSize(alto, ancho);
        super.setBackground(Color.white);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();
        Font f = new Font("Arial", Font.BOLD, 20);
        og.setFont(f);
        int xCola = 450, yCola = 100, wCola = 500, hCola = 100;
        og.setColor(Color.black);
        og.fillRect(xCola, yCola, wCola, hCola); // Cola pacientes normales
        og.fillRect(xCola, yCola + 200, wCola, hCola); // Cola pacientes infecciosos
        og.fillRect(50, 50, 400, 400); // Sala
        og.fillRect(230, 450, 50, 50); // Limpieza

        og.setColor(Color.blue);
        if (!colaNormales.isEmpty()) {
            for (int i = 0; i < colaNormales.size(); i++) {
                og.drawString("PN" + String.valueOf(colaNormales.get(i)), xCola + 50 * i, yCola + 20);
                og.fillOval(xCola + 50 * i, yCola + 30, 30, 30);
            }
        }

        og.setColor(Color.red);
        if (!colaInfecciosos.isEmpty()) {
            for (int i = 0; i < colaInfecciosos.size(); i++) {
                og.drawString("PI" + String.valueOf(colaInfecciosos.get(i)), xCola + 50 * i, yCola + 220);
                og.fillOval(xCola + 50 * i, yCola + 230, 30, 30);
            }
        }

        if (!limpiando) {
            og.setColor(Color.white);
            og.fillOval(240, 455, 30, 30);
            og.drawString("Limpiador", 220, 445);
            if (hayVirus) {
                og.setColor(Color.yellow);
                og.fillOval(290, 260, 30, 30);
                og.drawString("Virus", 290, 250);
            }
        } else {
            og.setColor(Color.white);
            og.fillOval(210, 260, 30, 30);
            og.drawString("Limpiador", 190, 250);
            og.setColor(Color.yellow);
            og.fillOval(290, 260, 30, 30);
            og.drawString("Virus", 290, 250);
        }

        og.setColor(Color.green);
        if (huecoSala1 == -1) {
            og.fillOval(250, 100, 30, 30);
            og.drawString("M1", 250, 90);
        } else {
            //System.out.println("paciente " + huecoSala1);

            og.fillOval(250, 120, 30, 30);
            og.drawString("M1", 250, 110);
            if (tipoSala1 == 'n') {
                og.setColor(Color.blue);
                og.drawString("PN" + String.valueOf(huecoSala1), 250, 180);
                og.fillOval(250, 190, 30, 30);
            } else if (tipoSala1 == 'i') {
                if (huecoSala1 == huecoSala2) {
                    og.setColor(Color.red);
                    og.drawString("PI" + String.valueOf(huecoSala1), 200, 250);
                    og.fillOval(200, 260, 30, 30);
                } else if (huecoSala1 == huecoSala3) {
                    og.setColor(Color.red);
                    og.drawString("PI" + String.valueOf(huecoSala1), 270, 250);
                    og.fillOval(270, 260, 30, 30);
                }
            }
        }

        og.setColor(Color.green);
        if (huecoSala2 == -1) {
            og.fillOval(100, 370, 30, 30);
            og.drawString("M2", 100, 360);
        } else {
            og.fillOval(120, 350, 30, 30);
            og.drawString("M2", 120, 340);
            if (tipoSala2 == 'n') {
                og.setColor(Color.blue);
                og.drawString("PN" + String.valueOf(huecoSala2), 160, 300);
                og.fillOval(160, 310, 30, 30);
            } else if (tipoSala2 == 'i') { //
                if (huecoSala2 == huecoSala3) {
                    og.setColor(Color.red);
                    og.drawString("PI" + String.valueOf(huecoSala2), 220, 300);
                    og.fillOval(220, 310, 30, 30);
                }
            }

        }

        og.setColor(Color.green);
        if (huecoSala3 == -1) {
            og.fillOval(360, 380, 30, 30);
            og.drawString("M3", 360, 370);
        } else {
            og.fillOval(340, 360, 30, 30);
            og.drawString("M3", 340, 350);
            if (tipoSala3 == 'n') {
                og.setColor(Color.blue);
                og.drawString("PN" + String.valueOf(huecoSala3), 300, 300);
                og.fillOval(300, 310, 30, 30);
            }
        }

        g.drawImage(img, 0, 0, null);
    }

    public void enColaNormales(int id) {
        colaNormales.add(id);
        repaint();
    }

    public void enColaInfecciosos(int id) {
        colaInfecciosos.add(id);
        repaint();
    }

    public void enSala(int id, char tipo) {
        if (tipo == 'n') {
            colaNormales.remove((Object) id);
            if (huecoSala1 == -1) {
                huecoSala1 = id;
                tipoSala1 = 'n';
            } else if (huecoSala2 == -1) {
                huecoSala2 = id;
                tipoSala2 = 'n';
            } else { //if (huecoSala3 == -1) {
                huecoSala3 = id;
                tipoSala3 = 'n';
            }
        } else if (tipo == 'i') {
            colaInfecciosos.remove((Object) id);
            if (huecoSala1 == -1 && huecoSala2 == -1) {
                huecoSala1 = id;
                huecoSala2 = id;
                tipoSala1 = 'i';
                tipoSala2 = 'i';
            } else if (huecoSala1 == -1 && huecoSala3 == -1) {
                huecoSala1 = id;
                huecoSala3 = id;
                tipoSala1 = 'i';
                tipoSala3 = 'i';
            } else { //if (huecoSala2 == -1 && huecoSala3 == -1) {
                huecoSala3 = id;
                huecoSala2 = id;
                tipoSala3 = 'i';
                tipoSala2 = 'i';
            }
        }

        repaint();
    }

    public void terminaNormal(int id) {
        if (huecoSala1 == id) {
            huecoSala1 = -1;
            tipoSala1 = 'v';
        } else if (huecoSala2 == id) {
            huecoSala2 = -1;
            tipoSala2 = 'v';
        } else { //if (huecoSala3 == id) {
            huecoSala3 = -1;
            tipoSala3 = 'v';
        }
        repaint();
    }

    public void terminaInfeccioso(int id) {
        if (huecoSala1 == id && huecoSala2 == id) {
            huecoSala1 = -1;
            huecoSala2 = -1;
            tipoSala1 = 'v';
            huecoSala2 = 'v';
        } else if (huecoSala1 == id && huecoSala3 == id) {
            huecoSala1 = -1;
            huecoSala3 = -1;
            tipoSala1 = 'v';
            tipoSala3 = 'v';
        } else { // if (huecoSala2 == id && huecoSala3 == id) {
            huecoSala2 = -1;
            huecoSala3 = -1;
            tipoSala2 = 'v';
            tipoSala3 = 'v';
        }
        hayVirus = true;
        repaint();
    }

    public void limpiadorEsperando() {
        limpiando = false;
        hayVirus = false;
        repaint();
    }

    public void limpiadorLimpiando() {
        limpiando = true;
        repaint();
    }

}
