/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploframe;

/**
 *
 * @author usuario
 */
public class Recurso {
    private int contadores[] = {0,0};
    private MiCanvas cv;
    
    public Recurso(MiCanvas c){
        cv = c;
    }

    public int[] getContadores() {
        return contadores;
    }

    public synchronized void incrementa(int cual) {
        contadores[cual]++;        
        //canvas.representa(contadores);
        System.out.println("Los contadores valen " + contadores[0] + ", " + contadores[1]);
        cv.actualiza(contadores);
    }
}
