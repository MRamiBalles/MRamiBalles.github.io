#ifndef CONTRATOMOVIL_H
#define CONTRATOMOVIL_H
#include "contrato.h"

class ContratoMovil : public Contrato{
    float precioMinuto;
    char *nac;
public:
    ContratoMovil(long int dni, Fecha f, float precioMinuto, int m, const char *nac);
    ContratoMovil(const ContratoMovil &c);
    ~ContratoMovil();

    void ver() const;
    float factura() const;

    void setNacionalidad(const char *nac);
    void setPrecioMinuto(float precioMinuto){this->precioMinuto = precioMinuto;};
    const char* getNacionalidad() const {return nac;};
    float getPrecioMinuto() const {return precioMinuto;};

};

ostream& operator<<(ostream& s, const ContratoMovil &c);

#endif // CONTRATOMOVIL_H
