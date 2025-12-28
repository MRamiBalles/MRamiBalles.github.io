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
    s << c.getDniContrato() << "(" << c.getIdContrato() << " - " << c.getFechaContrato() << ") "<< c.getMinutosHablados();
    return s;
}

int operator+(const Contrato &c1, const Contrato &c2){
    int minutos;
    minutos = c1.getMinutosHablados() + c2.getMinutosHablados();
    return minutos;
}

int operator+(const Contrato &c, const int &n){
    int minutos;
    minutos = n + c.getMinutosHablados();
    return minutos;
}
