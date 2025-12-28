#include "ContratoMovil.h"
#include <cstring>
#include "Contrato.h"
#include <iostream>

using namespace std;

ContratoMovil::ContratoMovil(long int d, Fecha f, float p, int m, char *nac):Contrato(d, f) {
    this-> precioMin = p;
    this-> setMinutosHablados(m);
    this-> nacionalidad = new char [strlen(nac)+1];
    strcpy(this-> nacionalidad, nac);
}

ContratoMovil::ContratoMovil(const ContratoMovil &c): Contrato(c.getDniContrato(), c.getFechaContrato()){
    this-> precioMin = c.precioMin;
    this-> setMinutosHablados(c.getMinutosHablados());
    this-> nacionalidad = new char [strlen(c.nacionalidad)+1];
    strcpy(this-> nacionalidad, c.nacionalidad);
}

ContratoMovil::~ContratoMovil(){
    delete [] nacionalidad;
}

void ContratoMovil::ver() const{
    Contrato::ver();  //Muestra lo heredado del padre
    cout << " " << this-> getMinutosHablados() << "m, " << this-> nacionalidad << " " << this-> precioMin;
    cout << " - " << this-> factura() << " euros."; //Para ver la factura en la prueba3
}

float ContratoMovil::factura() const{
    return precioMin * getMinutosHablados();
}

/*
ContratoMovil& ContratoMovil::operator=(const ContratoMovil& c){
    if (this != c) { //ver que no es el mismo objeto
        setDniContrato(c.getDniContrato());
        delete [] nacionalidad;
        this-> nacionalidad = new char [strlen(c.nacionalidad+1)];
        strcpy(this-> nacionalidad, c.nacionalidad);
        setFechaContrato(c.getFechaContrato());
    }
    return *this;
}
*/

ostream& operator<<(ostream &s, const ContratoMovil &c){
    s << (Contrato&) c; //Mostramos lo heredado de Contrato
    s << c.getNacionalidad() << " ";
    s << c.getPrecioMinuto() << " - " << c.factura() << " euros.";
    return s;
}
