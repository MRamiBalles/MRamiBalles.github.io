#ifndef CONTRATO_H
#define CONTRATO_H

#include <iostream>
#include "Fecha.h"
#include "Cliente.h"

using namespace std;

class Contrato
{
    static int contador; //Para todos los objetos de la clase (encapsulación)
    int idContrato;
    long int dniContrato;
    Fecha fechaContrato;
    int minutosHablados;

    public:
        Contrato(long int d, Fecha f);
        Contrato(const Contrato &c);
        virtual ~Contrato();

        long int getDniContrato() const {return this-> dniContrato;}
        Fecha getFechaContrato() const {return this-> fechaContrato;}
        int getIdContrato() const {return this-> idContrato;}
        int getMinutosHablados() const {return this-> minutosHablados;}
        void setDniContrato(long int d) {this-> dniContrato = d;}
        void setFechaContrato(Fecha f) {this-> fechaContrato = f;}
        void setMinutosHablados(int m) {this-> minutosHablados = m;}

        //Modificaciones para que Contrato muestre comportamiento polimorfico:
        virtual void ver() const;
        friend ostream& operator<<(ostream &s, const Contrato &c);
        virtual float factura() const=0; //Virtual puro (abstracto)

        friend int operator+(const Contrato &c1, const Contrato &c2);
        friend int operator+(const Contrato &c, const int &n);
};

//int operator+(const Contrato &c1, const Contrato &c2);
//int operator+(const Contrato &c, const int &n);

#endif // CONTRATO_H
