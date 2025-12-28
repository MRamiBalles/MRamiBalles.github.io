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
public class Camion implements Runnable {
    private int id;
    private int espera; 
    private int calle;
    private Gasolinera gas;
    
    public Camion(int id, Gasolinera gas) {
        this.id = id;
        this.gas = gas;
        
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        espera = 1000*(rnd.nextInt(2) + 2);
    }
    
    @Override
    public void run() {
        try {
            System.out.println("El camion con id : " + id + " esta esperando para repostar...\n");
            calle = gas.EntraCamion(id);
            System.out.println("El camion " + id +" repostando\n...\n");
            Thread.sleep(espera);
            System.out.println("El camion " + id + " ha finalizado de repostar\n");
            gas.SaleCamion(id, calle);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
    
}
