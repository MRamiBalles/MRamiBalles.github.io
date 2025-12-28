/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploframe;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Sumador extends Thread{
    private Recurso r;
    private int cual;
    
    public Sumador(Recurso r, int cual) {
        this.r = r;
        this.cual = cual;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            r.incrementa(cual);  
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sumador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
