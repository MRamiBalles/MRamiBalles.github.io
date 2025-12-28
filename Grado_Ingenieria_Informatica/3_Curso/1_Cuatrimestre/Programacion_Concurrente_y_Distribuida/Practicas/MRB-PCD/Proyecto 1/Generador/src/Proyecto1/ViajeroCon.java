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
public class ViajeroCon implements Runnable {
    private int id;
    private Terminal t;
    
    public ViajeroCon(int i, Terminal t){
        id = i;
        this.t = t;
    }

    @Override
    public void run() {
        try {
            System.out.println("Viajero con equipaje " + id + " en cola para el bus\n");
            t.SubeCon();
            System.out.println("Viajero con equipaje " + id + " en Bus\n");
            t.Baja();
            System.out.println("Viajero con equipaje " + id + " en estacion\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(ViajeroCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
