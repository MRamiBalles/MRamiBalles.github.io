#include "Contrato.h"
#include <iostream>

using namespace std;

int Contrato::contador = 1;

Contrato::Contrato(long int d, Fecha f):fechaContrato(f){
    this-> dniContrato = d;
    this-> idContrato = contador;
    contador++;
}

Contrato::Contrato(const Contrato &c): idContrato(contador), fechaContrato(c.getFechaContrato()){
    this-> dniContrato = c.getDniContrato();
    Contrato::contador++;
}

Contrato::~Contrato(){
}

void Contrato::ver() const{
    cout << dniContrato << "(" << idContrato << " - " << fechaContrato << ")";
}

ostream& operator<<(ostream &s, const Contrato &c){
    s << c.getDniContrato() << "(" << c.getIdContrato() << " - " << c.getFechaContrato() << ") ";
    return s;
}
