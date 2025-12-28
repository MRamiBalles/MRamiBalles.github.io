#ifndef FECHA_H
#define FECHA_H
#include <iostream>

using namespace std;

class Fecha //const y friend para ejecución rápida y eficiente.
{
    int dia;
    int mes;
    int anio;

    public:
        Fecha(const int &d, const int &m, const int &a);

        int getDia() const {return dia;} //Métodos get ctes, no pueden modificar el objeto que los invocan
        int getMes() const {return mes;}
        int getAnio() const {return anio;}
        void setFecha(const int &d, const int &m, const int &a);

        bool bisiesto() const;
        void ver() const;

        Fecha operator++(int i); //fecha++
        Fecha operator++();    //++fecha
        Fecha operator+(const int &n) const; //Método constante

        friend Fecha operator+(const int &a, const Fecha &f);
        friend ostream& operator<<(ostream &s, const Fecha &f);
};

#endif // FECHA_H
