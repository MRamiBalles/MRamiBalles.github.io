#ifndef CONTRATO_H
#define CONTRATO_H
#include "fecha.h"
#include <iostream>
#include <cstring>

using namespace std;

class Contrato{
    static unsigned int contador;

protected:
    int idContrato;
    long int dniContrato;
    Fecha fechaContrato;

    int minutosHablados;

public:
    Contrato(long int dni, Fecha f);
    virtual ~Contrato();

    long int getDniContrato() const {return this->dniContrato;};
    Fecha getFechaContrato() const {return this->fechaContrato;};
    int getIdContrato() const {return this->idContrato;};
    int getMinutosHablados() const {return minutosHablados;};
    void setDniContrato(long int dni){this->dniContrato = dni;};
    void setFechaContrato(Fecha f){this->fechaContrato = f;};
    void setMinutosHablados(int minutosHablados){this->minutosHablados = minutosHablados;};

    virtual void ver() const; //Polimorfismo
    virtual float factura() const = 0; //Abstracto
};

ostream& operator<<(ostream& s, const Contrato &o);

#endif // CONTRATO_H
