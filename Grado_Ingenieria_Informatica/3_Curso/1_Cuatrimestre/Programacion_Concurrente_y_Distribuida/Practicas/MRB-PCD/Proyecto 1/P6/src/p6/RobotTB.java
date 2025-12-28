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
public class RobotTB implements Runnable {
    private int id;
    private Semaphore litroR, huecoR, litroB, huecoB;
    private Random rnd;
    private CanvasRobots cv;
    
    public RobotTB(int id, Semaphore litroR, Semaphore huecoR, Semaphore litroB, Semaphore huecoB, CanvasRobots cv) {
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
            cv.enInicioB(id);
            sleep(500);
            for(int i = 0; i < 6; i++) {
                cv.enBlancoB(id);
                litroB.acquire();
                cv.cogeB(id);
                sleep(500);
                huecoB.release();
                
                //cv.enBlancoB(id);
                litroB.acquire();
                cv.cogeB(id);
                sleep(500);
                huecoB.release();
                
                System.out.println("TB"+id+" cambiando al tanque rojo");
                sleep(1000);
                
                cv.enRojoB(id);
                litroR.acquire();
                cv.cogeR(id);
                sleep(500);
                huecoR.release();
                
                int espera = 1000*(rnd.nextInt(3) + 1);
                cv.enInicioB(id);
                System.out.println("TB"+id+" preparando el tinte rojo claro " + i+1);
                sleep(espera);
            }
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }

    
}
