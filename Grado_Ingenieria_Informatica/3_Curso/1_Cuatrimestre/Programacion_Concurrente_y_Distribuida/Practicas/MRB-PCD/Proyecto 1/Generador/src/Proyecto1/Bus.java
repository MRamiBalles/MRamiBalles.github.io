/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manu
 */
public class Bus extends Thread {
    private Terminal t;
    
    public Bus(Terminal t) {
        this.t = t;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Bus para cargar\n");
                t.CargaBus();
                System.out.println("Bus cargado! En trayecto..\n");
                Thread.sleep(2000);
                t.DescargaBus();
                System.out.println("Bus descargado! En trayecto..\n");
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Fin del hilo bus");
    }
}
