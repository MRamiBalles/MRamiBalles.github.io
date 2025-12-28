#ifndef CONTRATO_H
#define CONTRATO_H
#include "fecha.h"

class Contrato{

    static int contador;

    const int idContrato;
    long int dniContrato;
    Fecha fechaContrato;
    int minutosHablados;

public:
    Contrato(long int dni, Fecha f);
    virtual ~Contrato();

    long int getDniContrato() const {return this-> dniContrato;};
    Fecha getFechaContrato() const {return this-> fechaContrato;};
    int getIdContrato() const {return this-> idContrato;};
    int getMinutosHablados() const {return this-> minutosHablados;};
    void setDniContrato(long int dni){this-> dniContrato = dni;};
    void setFechaContrato(Fecha f){this-> fechaContrato = f;};
    void setMinutosHablados(int m){this-> minutosHablados = m;};

    virtual void ver() const;
    virtual float factura() const=0; //Para la prueba 2 no requiere que sean virtuales
    friend ostream& operator<<(ostream& s, const Contrato &c);
};



#endif // CONTRATO_H
