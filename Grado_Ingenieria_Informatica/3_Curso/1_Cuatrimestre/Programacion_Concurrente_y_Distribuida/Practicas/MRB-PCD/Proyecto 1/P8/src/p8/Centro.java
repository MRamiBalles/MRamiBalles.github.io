/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Manu
 */
public class Centro {
    private Lock mutex = new ReentrantLock();
    private Condition colaNormal = mutex.newCondition();
    private Condition colaInfecciosos = mutex.newCondition();
    private Condition colaLimpiador = mutex.newCondition();
    private int genteEnSala = 0, infecciososEsperando = 0;
    private boolean salaInfectada = false;
    
    public void entraNormal(int id) throws InterruptedException {
        mutex.lock();
        try {
            if(genteEnSala == 3 || salaInfectada || (infecciososEsperando != 0 && genteEnSala < 2)) { 
                colaNormal.await();
            }
            genteEnSala++;            
        } finally {
            mutex.unlock();
        }
    }
    
    public void saleNormal(int id) throws InterruptedException {
        mutex.lock();
        try {
            genteEnSala--;
            if(salaInfectada) {
                colaLimpiador.signal();
            } else if(genteEnSala < 2 && infecciososEsperando != 0) {
                colaInfecciosos.signal();
            } else { 
                colaNormal.signal(); 
            }
        } finally {
            mutex.unlock();
        }
    }
    
    public void entraInfeccioso(int id) throws InterruptedException {
        mutex.lock();
        try {
            infecciososEsperando++;
            if(genteEnSala > 1 || salaInfectada) { 
                colaInfecciosos.await();
            }
            infecciososEsperando--;
            genteEnSala += 2;
        } finally {
            mutex.unlock();
        }
    }
    
    public void saleInfeccioso(int id) throws InterruptedException {
        mutex.lock();
        try {
            salaInfectada = true;
            genteEnSala -= 2;
            colaLimpiador.signal();
        } finally {
            mutex.unlock();
        }
    }
    
    public void entraLimpiador() throws InterruptedException {
        mutex.lock();
        try {
            if(genteEnSala > 0 || !salaInfectada) {
                colaLimpiador.await();
            }
        } finally {
            mutex.unlock();
        }
    }
    
    public void saleLimpiador() throws InterruptedException {
        mutex.lock();
        try {
            salaInfectada = false;
            if(infecciososEsperando > 0) {
                colaInfecciosos.signal();
            } else {
                colaNormal.signal();
            }
        } finally {
            mutex.unlock();
        }
    }
}
