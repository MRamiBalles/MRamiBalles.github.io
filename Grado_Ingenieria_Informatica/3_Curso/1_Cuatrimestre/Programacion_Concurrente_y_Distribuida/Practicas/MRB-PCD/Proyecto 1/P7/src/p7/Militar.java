/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author Manu
 */
public class Militar implements Callable<Integer> {
    private Control control;
    private int id;
    private int espera;
    private CanvasPool cv;
    
    public Militar(Control control, CanvasPool cv, int id) {
        this.control = control;
        this.cv = cv;
        this.id = id;
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        espera = 1000*(rnd.nextInt(2) + 2);
    }
    
    @Override
    public Integer call() throws InterruptedException {
        cv.EnColaMilitar(id);
        control.entraGarita();
        
        cv.EnGarita(id);
        System.out.println("Militar con id " + id + " en la garita.");
        Thread.sleep(2000);
        control.saleGarita();
        
        cv.EnPasilloGarita();
        //System.out.println("Militar con id " + id + " esperando al arco ...");
        control.entraArco('m');
        
        cv.EnArco(id, 'm');
        System.out.println("Militar con id " + id + " en arco.");
        Thread.sleep(espera);
        control.saleArco();
        
        cv.SaleArco();
        System.out.println("Militar con id " + id + " dentro de las instalaciones!");
        return espera;
    }
    
}
