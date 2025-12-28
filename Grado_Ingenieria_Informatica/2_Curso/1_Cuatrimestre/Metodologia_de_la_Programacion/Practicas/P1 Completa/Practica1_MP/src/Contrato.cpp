#include "Contrato.h"
#include <iostream>

using namespace std;

unsigned int Contrato::contador = 1;

Contrato::Contrato(long int dni, Fecha f) : fechaContrato(f), idContrato (contador){
    this->dniContrato = dni;
    Contrato::contador++; //static
}

Contrato::~Contrato(){
}

void Contrato::ver() const{
    cout << this-> dniContrato << "(" << this-> idContrato << " - " << this-> fechaContrato << ")";
}


ostream& operator<<(ostream& s, const Contrato &c) {
    s << c.getDniContrato() << "(" << c.getIdContrato() << " - " << c.getFechaContrato() << ")";
    return s;
}
