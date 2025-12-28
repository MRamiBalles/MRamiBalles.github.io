/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manu
 */
public class ViajeroSin extends Thread {
    private int id;
    private Terminal t;
    
    public ViajeroSin(int i, Terminal t){
        id = i;
        this.t = t;
    }

    @Override
    public void run() {
        try {
            System.out.println("Viajero sin equipaje " + id + " en cola para el bus\n");
            t.SubeSin();
            System.out.println("Viajero sin equipaje " + id + " en Bus\n");
            t.Baja();
            System.out.println("Viajero sin equipaje " + id + " en estacion\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(ViajeroSin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
