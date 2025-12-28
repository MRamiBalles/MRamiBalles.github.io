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
public class Masaje extends Thread {
    private int id;
    private Centro c;

    public Masaje(int id, Centro c) {
        this.id = id;
        this.c = c;
    }

    
    @Override
    public void run() {
        try {
            Random rnd = new Random();
            rnd.setSeed(System.currentTimeMillis());
            System.out.println("El hilo: " + id + " ha comenzado su masaje");
            c.EntraMasaje();
            Thread.sleep((rnd.nextInt(2)+2)*1000);
            System.out.println("El hilo: " + id + " ha finalizado su masaje");
            c.SaleMasaje();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
}
