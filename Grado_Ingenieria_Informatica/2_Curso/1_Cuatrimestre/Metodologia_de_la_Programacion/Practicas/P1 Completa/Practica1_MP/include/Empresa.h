#ifndef EMPRESA_H
#define EMPRESA_H


#include "Fecha.h" //definicion clase Fecha
#include "Cliente.h" // definicion clase Cliente
#include "Contrato.h" // definicion de la clase Contrato
#include "ContratoTP.h" // definicion de la clase ContratoTP
#include "ContratoMovil.h" // definicion de la clase ContratoMovil
#include <iostream>

using namespace std;

class Empresa{
    Cliente *clientes[100]; //array estático (tamaño 100)de punteros a Clientes
    int ncli;           //para saber cuántos clientes hay en el array (al principio 0)
    const int nmaxcli; //para saber cuántos caben en el array clientes(100)
    Contrato **contratos; //array dinámico de punteros a Contratos
    int ncon;            //para saber cuántos Contratos hay en el array (al principio 0)
    int nmaxcon; //para saber cuántos caben en el array Contratos
public:
    Empresa();
    virtual ~Empresa(); //No se implementan el constructor de copia ni el operador de asignación

    void crearContrato();
    bool cancelarContrato(int idContrato); //true si el Contrato existe, false si no
    bool bajaCliente(long int dni);        //true si el Cliente existe, false si no
    int descuento(float porcentaje) const; //devuelve a cuantos aplica el descuento
    int nContratosTP() const;
    void ver() const;

    void cargarDatos();

};

#endif // EMPRESA_H
