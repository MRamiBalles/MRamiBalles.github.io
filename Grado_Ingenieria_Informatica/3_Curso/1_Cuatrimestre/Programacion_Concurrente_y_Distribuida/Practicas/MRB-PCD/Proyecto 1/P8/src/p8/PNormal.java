/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p8;

import java.util.Random;

/**
 *
 * @author Manu
 */
public class PNormal extends Thread {
    private int id;
    private CanvasCentro canvas;
    private Centro centro;
    private int espera;
    
    public PNormal(int id, CanvasCentro cv, Centro c) {
        this.id = id;
        canvas = cv;
        centro = c;
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        espera = (rnd.nextInt(5) + 1) * 1000;
    }
    
    @Override
    public void run(){
        try {
            canvas.enColaNormales(id);
            System.out.println("Paciente normal con id " + id + " en cola..");
            centro.entraNormal(id);
            System.out.println("Paciente normal con id " + id + " siendo atendido en sala");
            canvas.enSala(id, 'n');
            sleep(espera);
            centro.saleNormal(id);
            System.out.println("Paciente normal con id " + id + " saliendo de sala");
            canvas.terminaNormal(id);
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }
    
}
