/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p6;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Manu
 */
public class RobotTA extends Thread {
    private int id;
    private Semaphore litroR, huecoR, litroB, huecoB;
    private Random rnd;
    private CanvasRobots cv;
    
    public RobotTA(int id, Semaphore litroR, Semaphore huecoR, Semaphore litroB, Semaphore huecoB, CanvasRobots cv) {
        this.litroR = litroR;
        this.litroB = litroB;
        this.huecoB = huecoB;
        this.huecoR = huecoR;
        this.id = id;
        this.cv = cv;
        rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
    }
    
    @Override
    public void run() {
        try {
            cv.enInicioA(id);
            sleep(500);
            for(int i = 0; i < 6; i++) {
                cv.enRojoA(id);
                litroR.acquire();
                cv.cogeR(id);
                sleep(500);
                huecoR.release();
                
                cv.enRojoA(id);
                litroR.acquire();
                cv.cogeR(id);
                sleep(500);
                huecoR.release();
                
                System.out.println("TA"+id+" cambiando al tanque blanco");
                sleep(1000);
                
                cv.enBlancoA(id);
                litroB.acquire();
                cv.cogeB(id);
                sleep(500);
                huecoB.release();
                
                int espera = 1000*(rnd.nextInt(3) + 1);
                cv.enInicioA(id);
                System.out.println("TA"+id+" preparando el tinte rojo oscuro " + i+1);
                sleep(espera);
            }
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }
    
}
