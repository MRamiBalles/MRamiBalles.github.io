#ifndef CONTRATO_H
#define CONTRATO_H

#include <fstream>

#include "Fecha.h"


class Contrato
{
    static int contador; //Para asociar el contador al id segun los objetos creados

    const int idContrato;
    long int dniContrato;
    Fecha fechaContrato;

    public:
        Contrato(long int dni, Fecha f);
        //Contrato(const Contrato &c); //Tener cuidado porque la copia tendría el mismo id
        //virtual ~Contrato();
        int getIdContrato() const {return idContrato;}
        long int getDniContrato() const {return dniContrato;}
        void setDniContrato(long int dni) {this -> dniContrato = dni;}

        Fecha getFechaContrato() const {return fechaContrato;}
        void setFechaContrato(Fecha f) {this -> fechaContrato = f;}

        /*virtual*/ void ver() const; //Virtual permite el uso del polimorfismo
};

ostream& operator<<(ostream &s, const Contrato &c);

#endif // CONTRATO_H
