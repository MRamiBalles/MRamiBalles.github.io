/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p9_pcd;

import java.util.Random;

/**
 *
 * @author Manu
 */
public class Coche extends Thread {
    private int id;
    private int espera;
    private int calle;
    private Gasolinera gas;
    
    public Coche(int id, Gasolinera gas) {
        this.id = id;
        this.gas = gas;
        
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        espera = 1000*(rnd.nextInt(2) + 2);
    }
    
    @Override
    public void run() {
        try {
            System.out.println("El Coche con id : " + id + " en cola para repostar...\n");
            calle = gas.EntraCoche(id);
            System.out.println("El coche " + id + " repostando\n...\n");
            
            Thread.sleep(espera);
            System.out.println("El coche " + id + " ha terminado de repostar\n");
            gas.SaleCoche(id, calle);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
    
}
