#include "ContratoTP.h"
#include <iostream>

using namespace std;

int ContratoTP::limiteMinutos = 300;
float ContratoTP::precio = 10;
const float ContratoTP::PrecioExceso = 0.15;

ContratoTP::ContratoTP(long int dni, Fecha f, int m) : Contrato(dni, f){
    setMinutosHablados(m);
}

ContratoTP::ContratoTP(const ContratoTP &c) : Contrato(c.getDniContrato(), c.getFechaContrato()){
    setMinutosHablados(c.getMinutosHablados());
}

ContratoTP::~ContratoTP(){
}

void ContratoTP::ver() const{
    cout << *this;
}
float ContratoTP::factura() const{
    int m = getMinutosHablados();
    return precio + (m > limiteMinutos?(m-limiteMinutos)*PrecioExceso:0);
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
    s << c.getDniContrato() << " (" << c.getIdContrato() << " - " << c.getFechaContrato() << ") " << c.getMinutosHablados() << "m, " << ContratoTP::getLimiteMinutos() << " (" << ContratoTP::getPrecio() << ") " << " - " << c.factura() << " euros.";
    return s;
}
