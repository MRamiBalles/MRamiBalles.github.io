/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p8;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Manu
 */
public class PInfeccioso implements Runnable {
    private int id;
    private CanvasCentro canvas;
    private Centro centro;
    private int espera;
    
    public PInfeccioso(int id, CanvasCentro cv, Centro c) {
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
            canvas.enColaInfecciosos(id);
            System.out.println("Paciente infeccioso con id " + id + " en cola..");
            centro.entraInfeccioso(id);
            System.out.println("Paciente infeccioso con id " + id + " siendo atendido en sala!");
            canvas.enSala(id, 'i');
            sleep(espera);
            centro.saleInfeccioso(id);
            System.out.println("Paciente infeccioso con id " + id + " saliendo de sala (Virus..)");
            canvas.terminaInfeccioso(id);
            
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }
    
}
