/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7;

/**
 *
 * @author Manu
 */
public class Control {
    private boolean GaritaLibre = true, ArcoLibre = true, EscanerLibre = true;
    private int PasilloGaritaLibre = 2, PasilloEscanerLibre = 1;
    
    public synchronized void entraGarita() throws InterruptedException {
        while(!GaritaLibre) {
            wait();
        }
        GaritaLibre = false;
        notifyAll();
    }
    
    public synchronized void saleGarita() throws InterruptedException{
        while(PasilloGaritaLibre == 0) {
            wait();
        }
        GaritaLibre = true;
        PasilloGaritaLibre--;
        notifyAll();
    }
    
    public synchronized void entraEscaner() throws InterruptedException {
        while(!EscanerLibre) {
            wait();
        }
        EscanerLibre = false;
        notifyAll();
    }
    
    public synchronized void saleEscaner() throws InterruptedException{
        while(PasilloEscanerLibre != 1) {
            wait();
        }
        EscanerLibre = true;
        PasilloEscanerLibre--;
        notifyAll();
    }
    
    public synchronized void entraArco(char tipo) throws InterruptedException{
        while(!ArcoLibre) {
            wait();
        }
        ArcoLibre = false;
        if(tipo == 'm') {
            PasilloGaritaLibre++;
        } else if(tipo == 'c') {
            PasilloEscanerLibre++;
        }
        notifyAll();
    }
    
    public synchronized void saleArco() throws InterruptedException {
        ArcoLibre = true;
        notifyAll();
    }
}
