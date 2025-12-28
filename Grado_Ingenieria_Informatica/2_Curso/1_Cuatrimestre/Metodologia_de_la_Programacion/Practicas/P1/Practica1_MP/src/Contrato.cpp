#include "Contrato.h"
#include <iostream>

using namespace std;

int Contrato::contador = 1;

Contrato::Contrato(long int dni, Fecha f):fechaContrato(f), idContrato(dni){
    this->dniContrato = dni;
}

Contrato::~Contrato(){
}

void Contrato::ver() const{
    cout << dniContrato << "(" << idContrato << " - " << fechaContrato << ")";
}


ostream& operator<<(ostream& s, const Contrato &c) {
    s << c.getDniContrato() << "(" << c.getIdContrato() << " - " << c.getFechaContrato() << ")";
    return s;
}
