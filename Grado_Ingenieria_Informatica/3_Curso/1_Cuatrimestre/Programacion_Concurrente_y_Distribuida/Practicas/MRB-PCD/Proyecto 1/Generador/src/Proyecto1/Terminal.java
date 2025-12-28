/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author Manu
 */
public class Terminal {
    private int huecosLibres = 7, esperandoSin = 0;
    private boolean cargaBus = false;
    
    public synchronized void SubeSin() throws InterruptedException {
        esperandoSin++;
        while(!cargaBus || huecosLibres == 0){
            wait();
        }
        esperandoSin--;
        huecosLibres--;
        notifyAll();
    }
    
    public synchronized void SubeCon() throws InterruptedException {
        while(!cargaBus || (huecosLibres == 0 && esperandoSin > 0)) {
            wait();
        }
        huecosLibres--;
        huecosLibres--;
        notifyAll();
    }
    
    public synchronized void Baja() {
        huecosLibres++;
        notifyAll();
    }
    
    public synchronized void CargaBus() throws InterruptedException {
        cargaBus = true;
        while (huecosLibres < 7 && (esperandoSin > 0 && huecosLibres < 7)) {
            wait();
        }
        if (huecosLibres == 7) {
            cargaBus = false;
            notifyAll();
        }
    }
    
    public synchronized void DescargaBus() {
        huecosLibres = 7;
        notifyAll();
    } 
}
