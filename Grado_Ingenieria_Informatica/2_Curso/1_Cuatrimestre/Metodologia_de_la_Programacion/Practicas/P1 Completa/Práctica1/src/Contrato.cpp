#include "Contrato.h"
#include <iostream>
#include <cstring>

using namespace std;

unsigned int Contrato::contador = 1;

Contrato::Contrato(long int dni, Fecha f) : fechaContrato(f){
    this->dniContrato = dni;
    this->idContrato = contador++;
}

Contrato::~Contrato(){
}

void Contrato::ver() const{
    cout << this->dniContrato << "(" << idContrato << " - " << fechaContrato << ")";
}


ostream& operator<<(ostream& s, const Contrato &o) {
    s << o.getDniContrato() << "(" << o.getIdContrato() << " - " << o.getFechaContrato() << ")";
    return s;
}
