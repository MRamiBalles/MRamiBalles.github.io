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
public class RobotTR extends Thread {
    private Semaphore litroR, huecoR, litroB, huecoB;
    private Random rnd;
    private CanvasRobots cv;
    
    public RobotTR(Semaphore litroR, Semaphore huecoR, Semaphore litroB, Semaphore huecoB, CanvasRobots cv) {
        this.litroR = litroR;
        this.litroB = litroB;
        this.huecoB = huecoB;
        this.huecoR = huecoR;
        this.cv = cv;
        rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                int CantidadRojo = rnd.nextInt(4) + 3;
                System.out.println("tinte rojo a reponer : " + CantidadRojo);
                int CantidadBlanco = rnd.nextInt(4) + 3;
                System.out.println("tinte blanco a reponer : " + CantidadBlanco);
                cv.reponeInicioCargado(CantidadBlanco, CantidadRojo);
                sleep(1000);
                for(int i = 0; i < CantidadBlanco; i++) {
                    cv.reponeBlanco();
                    huecoB.acquire();
                    litroB.release();
                    sleep(100);
                }
                for(int i = 0; i < CantidadRojo; i++) {
                    cv.reponeRojo();
                    huecoR.acquire();
                    litroR.release();
                    sleep(100);
                }
                
            int espera = 1000*(rnd.nextInt(4) + 2);
            cv.reponeInicioVacio();
            System.out.println("Robot TR esperando...");
            sleep(espera);
            }
            
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }

}

