
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
            for(int i = 0; i < 6; i++) {
                litroR.acquire();
                huecoR.release();
                litroR.acquire();
                huecoR.release();
                litroB.acquire();
                huecoB.release();
            }
            
            int espera = 1000*rnd.nextInt(2) + 1;
            sleep(espera);
        } catch(InterruptedException ex) {
            ex.getMessage();
        }
    }
    
}
