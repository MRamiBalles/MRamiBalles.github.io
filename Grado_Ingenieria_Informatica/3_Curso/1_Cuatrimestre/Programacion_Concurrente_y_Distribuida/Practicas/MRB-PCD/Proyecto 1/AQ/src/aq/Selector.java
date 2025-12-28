/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aq;

/**
 *
 * @author Manu
 */
public class Selector {
    public String atributo, operador, valor;
    
    public Selector(String a, String o, String v) {
        super();
        atributo = a;
        operador = o;
        valor = v;
    }
    
    @Override
    public String toString(){
        return String.format("{%s, %s, %s}\n", atributo, operador, valor);
    }
}
