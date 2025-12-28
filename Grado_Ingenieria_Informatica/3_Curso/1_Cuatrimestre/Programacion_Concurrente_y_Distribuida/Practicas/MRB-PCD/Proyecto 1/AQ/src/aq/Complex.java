/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aq;

import java.util.ArrayList;

/**
 *
 * @author Manu
 */
public class Complex {
    public ArrayList<Selector> conjuncion;
    
    public Complex() {
        super();
        conjuncion = new ArrayList<Selector>();
    }
    
    @Override
    public String toString() {
        return "[" + "]";
    }
    
    public boolean esMasGeneralQue(Complex c) {
        for(Selector sel : this.conjuncion) {
            if(!c.conjuncion.contains(sel))
                return false;
        }
        return true;
    }

    public boolean noCubreNegativos(ArrayList<Ejemplo> listaNeg) {
        for(Ejemplo e : listaNeg) {
            if(cubre(e))
                return false;
            
        }
        return false;
    }
    
    public boolean cubre(Ejemplo e) {
        for(Selector s : conjuncion) {
            if(!s.cubre(e))
                return false;
        }
        return true;
    }
}
