#ifndef CONTRATOMOVIL_H
#define CONTRATOMOVIL_H

#include <Contrato.h>


class ContratoMovil : public Contrato
{
    float minutosHablados; //Pueden cambiar pero siempre son los mismos para todos
    int minutosHablados;
    char *nacionalidad;

    public:
        ContratoMovil();
        virtual ~ContratoMovil();
        ContratoMovil(const ContratoMovil& c);

        float getPrecioMinuto(){;}
        void setPrecio (float p) {;}
        int getMinutosHablados() {;}
        void setMinutosHablados(int m){;}

        const char *getNacionalidad() const {return this -> nacionalidad;}
        void setNacionalidad(char* n){;}

        void ver() const;

        float factura() const;
};

#endif // CONTRATOMOVIL_H
