#ifndef CONTRATOTP_H
#define CONTRATOTP_H

#include <Contrato.h>


class ContratoTP : public Contrato
{
    static int minutosTP;
    static float precioTP; //Pueden cambiar pero siempre son los mismos para todos

    int minutosHablados;
    static const float precioExceso;


    public:
        ContratoMovil(long int dni, Fecha f, int m);
        //virtual ~ContratoMovil();
        //ContratoMovil(const ContratoMovil& c);

        static int getLimiteMinutos() {return ContratoTP::minutosTP;}
        static floar getPrecio() {return ContratoTP::precioTP;}

        static void setTarifaPlana(int m, float p);

        int getMinutosHablados() const {return (this -> minutosHablados);}
        void setMinutosHablados(int m) {this -> minutosHablados = m;}

        void ver();
        float factura() const;

};


ostream& operator<<(ostream &s, const Contrato &c);

#endif // CONTRATOTP_H
