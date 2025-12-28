#ifndef CONTRATOMOVIL_H
#define CONTRATOMOVIL_H

#include <Contrato.h>
#include <cstring>

class ContratoMovil : public Contrato
{
    float precioMin;
    char *nacionalidad;

    public:
        ContratoMovil(long int d, Fecha f, float p, int m, char *nac);
        ContratoMovil(const ContratoMovil &c); //Necesario para incrementar el contador y no repetir idContrato
        ~ContratoMovil();

        void setNacionalidad(char *nac) {strcpy(this-> nacionalidad, nac);}
        void setPrecioMinuto(float p){this-> precioMin = p;}
        char* getNacionalidad() const {return nacionalidad;}
        float getPrecioMinuto() const {return precioMin;}

        //ContratoMovil& operator=(const ContratoMovil& c);
        virtual void ver() const;
        float factura() const;
};
ostream& operator<<(ostream &s, const ContratoMovil &c);

#endif // CONTRATOMOVIL_H
