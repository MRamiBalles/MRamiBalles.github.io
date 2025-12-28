
import java.util.Random;
import java.util.concurrent.Semaphore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
                int CantidadRojo = 1000*rnd.nextInt(3) + 3;
                System.out.println("rojo : " + CantidadRojo);
                int CantidadBlanco = 1000*rnd.nextInt(3) + 3;
                System.out.println("blanco : " + CantidadBlanco);
                for(int i = 0; i < CantidadRojo; i++) {
                    litroR.acquire();
                    huecoR.release();
                }
                for(int i = 0; i < CantidadBlanco; i++) {
                    litroB.acquire();
                    huecoB.release();
                }
            int espera = 1000*rnd.nextInt(3) + 2;
            sleep(espera);
            }
            
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }

}
