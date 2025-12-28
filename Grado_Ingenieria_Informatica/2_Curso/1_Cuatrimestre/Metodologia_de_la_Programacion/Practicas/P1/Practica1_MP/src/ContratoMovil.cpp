#include "ContratoMovil.h"
#include "string.h"
#include <iostream>

using namespace std;

ContratoMovil::ContratoMovil(long int dni, Fecha f, float precioMinuto, int m, const char *nac) : Contrato(dni, f){
    this->precioMinuto = precioMinuto;
    this-> setMinutosHablados(m);
    //this-> nacionalidad = nac MAL!!!
    this->nac = new char[strlen(nac)+1];
    strcpy(this->nac, nac);

}
ContratoMovil::ContratoMovil(const ContratoMovil &c) : Contrato(c.getDniContrato(), c.getFechaContrato()){
    this-> precioMinuto = c.precioMinuto;
    this-> setMinutosHablados(c.getMinutosHablados());
    this-> nac = new char[strlen(c.nac)+1];
    strcpy(this->nac, c.nac);
}

ContratoMovil::~ContratoMovil(){
    delete [] this->nac;
}


void ContratoMovil::ver() const{
    cout << *this;
}
float ContratoMovil::factura() const{
    return precioMinuto*getMinutosHablados();
}

void ContratoMovil::setNacionalidad(const char *nac){
    delete this->nac;
    this->nac = new char[strlen(nac)+1];
    strcpy(this->nac, nac);
}


ostream& operator<<(ostream& s, const ContratoMovil &c) {
    s << c.getDniContrato() << " (" << c.getIdContrato() << " - " << c.getFechaContrato() << ") " << c.getMinutosHablados() << "m, " << c.getNacionalidad() << " " << c.getPrecioMinuto() << " - " << c.factura() << " euros";
    return s;
}
