/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p9_pcd;

/**
 *
 * @author Manu
 */
public class Gasolinera {
    private int lateralLibre = 2;
    private int centroLibre = 2;
    private int cochesEsperando = 0;
    private int ambulancasEsperando = 0;
    private Canvas_Gasolinera canvas;
    
    public Gasolinera(Canvas_Gasolinera cv) {
        canvas = cv;
    }
    
    public synchronized int EntraCamion(int id) throws InterruptedException {
        int cual;
        canvas.EnColaCamion(id);
        while(lateralLibre <= 0 && (centroLibre != 2 || cochesEsperando > 0)) {
            wait();
        }
        if(lateralLibre == 2) {
            cual = 1;
            lateralLibre--;
        } else if(lateralLibre == 1) {
            cual = 4;
            lateralLibre--;
        } else {
            cual = 2;
            centroLibre = 0;
        } 
        canvas.RepostandoCamion(id, cual);
        return cual;
    }
    
    public synchronized int EntraCoche(int id) throws InterruptedException {
        int cual;
        canvas.EnColaCoche(id);
        cochesEsperando++;
        while(centroLibre == 0 && lateralLibre == 0) { // camionesEsperando < 0??
            wait();
        }
        cochesEsperando--;
        if(centroLibre == 2) {
            cual = 2;
            centroLibre--;
        } else if(centroLibre == 1) {
            cual = 3;
            centroLibre--;
        } else if(lateralLibre == 2) {
            cual = 1;
            lateralLibre--;
        } else {
            cual = 4;
            lateralLibre--;
        }
        canvas.RepostandoCoche(id, cual);
        return cual;
    }
    
    public synchronized void SaleCamion(int id, int cual) {
        if(cual == 1 || cual == 4) {
            lateralLibre++;
        } else {
            centroLibre = 2;
        }
        canvas.terminaCamion(id); 
        notifyAll();
    }
    
    public synchronized void SaleCoche(int id, int cual) {
        if(cual == 2 || cual == 3) {
            centroLibre++;
        } else {
            lateralLibre++;
        }
        canvas.terminaCoche(id);
        notifyAll();
    }
    
    public synchronized int EntraAmbulancia(int id) throws InterruptedException {
        int cual;
        canvas.EnColaAmbulancia(id);
        ambulanciasEsperando++;
        while(centroLibre == 0 && lateralLibre == 0) { // camionesEsperando < 0??
            wait();
        }
        cochesEsperando--;
        if(centroLibre == 2) {
            cual = 2;
            centroLibre--;
        } else if(centroLibre == 1) {
            cual = 3;
            centroLibre--;
        } else if(lateralLibre == 2) {
            cual = 1;
            lateralLibre--;
        } else {
            cual = 4;
            lateralLibre--;
        }
        canvas.RepostandoCoche(id, cual);
        return cual;
    }
    
    public synchronized void SaleAmbulancia(int id, int cual) {
        if(cual == 1 || cual == 4) {
            lateralLibre++;
        } else {
            centroLibre = 2;
        }
        canvas.terminaCamion(id); 
        notifyAll();
    }
}
