#ifndef CONTRATOTP_H
#define CONTRATOTP_H

#include <Contrato.h>

class ContratoTP : public Contrato
{
    static int limiteMin;
    static float precio;
    static const float excesoMin;

    public:
        ContratoTP(long int d, Fecha f, int m);
        ContratoTP(const ContratoTP &c);

        static int getLimiteMinutos() {return ContratoTP::limiteMin;} // !!!
        static float getPrecio() {return ContratoTP::precio;}
        static void setLimiteMinutos(int lm);
        static void setPrecio(float p);
        static void setTarifaPlana(int lm, float p);

        void ver() const;
        float factura() const;
};

ostream& operator<<(ostream &s, const ContratoTP &c);

#endif // CONTRATOTP_H
