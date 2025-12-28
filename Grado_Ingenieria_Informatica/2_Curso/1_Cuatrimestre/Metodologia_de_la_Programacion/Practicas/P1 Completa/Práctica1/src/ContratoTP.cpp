#include "ContratoTP.h"
#include <iostream>

using namespace std;

int ContratoTP::limiteMinutos = 300;
float ContratoTP::precio = 10;
const float ContratoTP::PRECIO_EXCESO = 0.15;

ContratoTP::ContratoTP(long int dni, Fecha f, int minutosHablados) : Contrato(dni, f){
    this->minutosHablados = minutosHablados;
}
ContratoTP::ContratoTP(const ContratoTP &c) : Contrato(c.getDniContrato(), c.getFechaContrato()){
    this->minutosHablados = c.minutosHablados;
}

ContratoTP::~ContratoTP(){
}

void ContratoTP::ver() const{
    cout << *this;
}
float ContratoTP::factura() const{
    return precio + (minutosHablados>limiteMinutos?(minutosHablados-limiteMinutos)*PRECIO_EXCESO:0);
}



int ContratoTP::getLimiteMinutos(){
    return limiteMinutos;
}
float ContratoTP::getPrecio(){
    return precio;
}

void ContratoTP::setLimiteMinutos(int l){
    limiteMinutos = l;
}
void ContratoTP::setPrecio(float p){
    precio = p;
}

void ContratoTP::setTarifaPlana(int limiteMinutos, float precio){
    ContratoTP::limiteMinutos = limiteMinutos;
    ContratoTP::precio = precio;
}


ostream& operator<<(ostream& s, const ContratoTP &c) {
    s << c.getDniContrato() << " (" << c.getIdContrato() << " - " << c.getFechaContrato() << ") " 
      << c.getMinutosHablados() << "m, " << ContratoTP::getLimiteMinutos() << "(" << ContratoTP::getPrecio() 
      << "€) - Factura: " << c.factura() << "€";
    return s;
}
