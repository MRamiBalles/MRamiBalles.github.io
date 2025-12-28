/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p8;

/**
 *
 * @author Manu
 */
public class Limpiador extends Thread {
    private CanvasCentro canvas;
    private Centro centro;
    
    public Limpiador(CanvasCentro cv, Centro c) {
        canvas = cv;
        centro = c;
    }
    
    @Override
    public void run(){
        try {
            while(true) {
                centro.entraLimpiador();
                System.out.println("Limpiador en sala!");
                canvas.limpiadorLimpiando();
                sleep(3000);
                centro.saleLimpiador();
                System.out.println("Limpiador termina de limpiar");
                canvas.limpiadorEsperando();
            }
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }
}
