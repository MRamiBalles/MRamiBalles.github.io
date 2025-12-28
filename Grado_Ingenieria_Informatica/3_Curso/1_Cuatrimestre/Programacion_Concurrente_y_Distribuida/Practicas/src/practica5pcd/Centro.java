/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5pcd;

/**
 *
 * @author usuario
 */
public class Centro {
    private boolean Mlibre = true, Flibre = true, Vlibre = true;
    private int esperandoRehabilitacion = 0;
    
    public Centro(){
        
    }
    
    public synchronized void EntraRehabilitacion() throws InterruptedException {
        esperandoRehabilitacion++;
        while (!Flibre) { //para que no despierte otros hilos que no quiero
            wait();
        }
        esperandoRehabilitacion--;
        Flibre = false;
    }

    public synchronized void SaleRehabilitacion() throws InterruptedException {
        while (!Vlibre) {
            wait();
        }
        Flibre = true;
        notifyAll();
    }

    public synchronized void EntraMasaje() throws InterruptedException {
        while (!Mlibre || (!Flibre && esperandoRehabilitacion != 0)) { //para que no despierte otros hilos que no quiero
            wait();
        }
        Mlibre = false;
    }

    public synchronized void SaleMasaje() throws InterruptedException {
        while (!Vlibre && es) {
            wait();
        }
        Mlibre = true;
        notifyAll();
    }

}
