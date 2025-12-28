/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5pcd;

import java.util.Random;

/**
 *
 * @author usuario
 */
public class Rehabilita implements Runnable {
    private int id;
    private Centro c;
    
    public Rehabilita(int id, Centro c){
        this.id = id;
        this.c = c;
    }
   
    
    @Override
    public void run(){
        try {
            Random rnd = new Random();
            rnd.setSeed(System.currentTimeMillis());
            System.out.println("El hilo: " + id + " ha comenzado rehabilitacion");
            c.EntraRehabilitacion();
            Thread.sleep((rnd.nextInt(2)+2)*1000);
            System.out.println("El hilo: " + id + " ha finalizado rehabilitacion");
            c.SaleRehabilitacion();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
    
}
