/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aq;

import java.util.ArrayList;

/**
 *
 * @author Manu
 */
public class AQ {
    public ArrayList<Ejemplo> listaPos = new ArrayList<>();
    public ArrayList<Ejemplo> listaNeg = new ArrayList<>();
    public ArrayList<Complex> covering = new ArrayList<>();
    public final Complex COMPLEJO_VACIO = new Complex();
    public final String[] operadores = {
        "IGUAL"
        //, "MAYOR_iGUAL"
    };
    
    public AQ(ArrayList<Ejemplo> pos, ArrayList<Ejemplo> neg){
        listaPos = pos;
        listaNeg = neg;
    }
    
    public ArrayList<Selector> generateSeed(Ejemplo ej) {
        ArrayList<Selector> semilla = new ArrayList<Selector>();
        for (int i = 0; i < ej.columnas.length; i++) {
            for (int j = 0; j < operadores.length; j++) {
                Selector s = new Selector(ej.columnas[i], operadores[j], ej.valores[i]);
                semilla.add(s);
            }
        }
        
        return semilla;
    }
    
    public ArrayList<Selector> algoritmo() {
        while(!listaPos.isEmpty()) {
            Ejemplo p1 = listaPos.get(0);
            
            ArrayList<Selector> semilla = generateSeed(p1);
            ArrayList<Complex> LComplex = alg_star(semilla, listaNeg);
            
            Complex mejor = new Complex();
            
        }
        return semilla;
    }
    
    public ArrayList<Complex> eliminarCubiertos(ArrayList<Complex> Ep, ArrayList<Complex> E) {
        ArrayList<Complex> nuevoEp = new ArrayList<Complex>(Ep);
        ArrayList<Complex> temp = new ArrayList<Complex>();
        for(Complex cEp : Ep) {
            for(Complex cE : E) {
                if(cE.esMasGeneralQue(cEp)) {
                    temp.add(cEp);
                    break;
                }
            }
            
        }
        nuevoEp.removeAll(temp);
        return nuevoEp;
    }
    
    
    public ArrayList<Complex> alg_star(ArrayList<Selector> semilla, ArrayList<Ejemplo> listaNeg) {
        ArrayList<Complex> E = new ArrayList<Complex>();
        ArrayList<Complex> L = new ArrayList<Complex>();
        L.add(new Complex());
        
        while(!L.isEmpty()) {
            ArrayList<Complex> Ep = merge(L, semilla);
            System.out.println("merge(" + L + ", " + semilla + ")");
            System.out.println(Ep.toString());
            
            Ep = eliminarCubiertos(Ep, E);
            
            for(Complex c : Ep) {
                if(!c.noCubreNegativos(listaNeg)) {
                    E.add(c);
                }
            }
        }
        return E;
    }
    
    public ArrayList<Complex> merge(ArrayList<Complex> L, ArrayList<Selector> semilla) {
        ArrayList<Complex> merged = new ArrayList<Complex>();
        for(Selector s : semilla) {
            for(Complex c : L) {
                if(!c.conjuncion.contains(s)) {
                    Complex nuevo = new Complex();
                    nuevo.conjuncion.addAll(c.conjuncion);
                    nuevo.conjuncion.add(s);
                    merged.add(nuevo);
            }
        }
        return merged;
    }
    
    public static void main(String[] args) {
        ArrayList<Ejemplo> ejPos = new ArrayList<>();
        ArrayList<Ejemplo> ejNeg = new ArrayList<>();
        // Positivos :
        ejPos.add(new Ejemplo(new String[] {"ANTENAS", "NUCLEO", "CUERPO", "COLAS"}, new String[] {"1", "2", "rayado", "0"}));
        //ejemplos.add(new Ejemplo(new String[] {"ANTENAS", "NUCLEO", "CUERPO", "COLAS"}, new String[] {"1", "0", "rayado", "2"}));
        // Negativos :
        ejNeg.add(new Ejemplo(new String[] {"ANTENAS", "NUCLEO", "CUERPO", "COLAS"}, new String[] {"1", "1", "blanco", "0"}));
        ejNeg.add(new Ejemplo(new String[] {"ANTENAS", "NUCLEO", "CUERPO", "COLAS"}, new String[] {"1", "1", "rayado", "1"}));
        AQ aq = new AQ(ejPos, ejNeg);
        aq.algoritmo();
            
        }
    }
    
}
