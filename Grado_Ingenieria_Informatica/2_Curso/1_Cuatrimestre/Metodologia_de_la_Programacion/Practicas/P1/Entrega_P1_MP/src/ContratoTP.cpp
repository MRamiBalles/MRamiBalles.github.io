#include "ContratoTP.h"

int ContratoTP::limiteMin = 300;
float ContratoTP::precio = 10;
const float ContratoTP::excesoMin = 0.15;

ContratoTP::ContratoTP(long int d, Fecha f, int m): Contrato(d,f){
    setMinutosHablados(m);
}

ContratoTP::ContratoTP(const ContratoTP &c): Contrato(c.getDniContrato(), c.getFechaContrato()){
    setMinutosHablados(c.getMinutosHablados());
}


void ContratoTP::setLimiteMinutos(int lm){ //No puede emplearse this al ser static!
    limiteMin = lm;
}

void ContratoTP::setPrecio(float p){
    precio = p;
}

void ContratoTP::setTarifaPlana(int lm, float p){
    limiteMin = lm;
    precio = p;
}


void ContratoTP::ver() const{ //No vale cout << *this -> Muestra el flujo con factura!
    Contrato::ver();
    cout << " " << getMinutosHablados() << "m, " << ContratoTP::limiteMin << " (" << ContratoTP::precio << ") ";
    cout << "- " << this-> factura() << " euros.";
}

float ContratoTP::factura() const{
    /*
    float fact;
    if (getMinutosHablados() > limiteMin)
        fact = precio + (getMinutosHablados() - limiteMin)*excesoMin;
    else fact = limiteMin;
    return fact;
    */
    return precio + (getMinutosHablados() > limiteMin ? (getMinutosHablados() - limiteMin)*excesoMin: 0);
}

ostream& operator<<(ostream &s, const ContratoTP &c){
    s << (Contrato &)c;
    s << c.getMinutosHablados() << "m, " << ContratoTP::getLimiteMinutos() << " ("
    << ContratoTP::getPrecio() << ") - "
    << c.factura() << " euros.";
    return s;
}

