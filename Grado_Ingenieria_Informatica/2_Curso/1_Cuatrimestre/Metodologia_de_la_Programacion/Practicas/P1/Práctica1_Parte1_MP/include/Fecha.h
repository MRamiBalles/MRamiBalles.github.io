#ifndef FECHA_H
#define FECHA_H


#include <iomanip>
#include <iostream>

using namespace std;

class Fecha {

    int dia, mes, anio;

    public:
        //Constructores:
        Fecha(const int &d, const int &m, const int &a);
        //Fecha() {;}

        //El constructor copia no es necesario porque no tenemos punteros!


        int getDia() const {return dia;}
        int getMes() const {return mes;}
        int getAnio() const {return anio;}

        void setFecha (const int &d, const int &m, const int &a);
        void ver();

        bool bisiesto();

        //Sobrecargas:

        Fecha operator++(); //++f
        Fecha operator++(int i); //f++
        //Fecha operator+(Fecha f); //f1 + f2
        Fecha operator+(int n); //f + int
};

#endif // FECHA_H
