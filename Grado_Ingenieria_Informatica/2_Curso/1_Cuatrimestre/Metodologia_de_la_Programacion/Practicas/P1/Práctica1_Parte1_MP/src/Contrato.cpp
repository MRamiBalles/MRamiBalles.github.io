#include "Contrato.h"

int Contrato::contador = 1;

Contrato::Contrato(long int dni, Fecha f) : idContrato(contador), fechaContrato(f) {
    Contrato::contador++;
    //this -> idContrato = contador; En la zona de inicializacion al ser constante
    this -> dniContrato = dni;
    //this -> fechaContrato = f; En la zona de inicializacion, ya que no tenemos un constructor sin parámetros
}

Contrato::Contrato(const Contrato &c) : idContrato(contador), fechaContrato(c.fechaContrato) {
    Contrato::contador++;
    this -> dniContrato = c.dniContrato;
}


void Contrato::ver() const {
    cout << this -> dniContrato << " (" << this -> idContrato
    << " - " << this -> fechaContrato.ver() << " )";
}

//void Contrato::operator<<() const {}



