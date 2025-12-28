#include "ContratoTP.h"

int ContratoTP::minutosTP = 300;
float ContratoTP::precioTP = 10;

const float ContratoTP::precioExceso = 0.15;

ContratoTP::ContratoTP(long int dni, Fecha f, int m) {
    //ctor
}


ostream& operator<<(ostream &s, const Contrato &c) {
    s << (Contrato &)c << c.getMinutosHablados() << ...
}

ContratoTP::ContratoTP(const ContratoTP& c)
{
    //copy ctor
}
