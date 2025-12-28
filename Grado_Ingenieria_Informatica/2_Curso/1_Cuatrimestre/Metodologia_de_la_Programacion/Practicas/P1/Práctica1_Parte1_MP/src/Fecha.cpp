#include "Fecha.h"



Fecha::Fecha(const int &d, const int &m, const int &a) {

    /* Hay que restringir los valores:
    this -> dia = d;
    this -> mes = m;
    this -> anio = a;
    */

    int diaMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dmax;

    this -> anio = a;

    if(this -> bisiesto()) diaMes[1] = 29;

    if (m<1) this -> mes = 1;
    else if (m>12) this -> mes = 12;
    else this -> mes = m;

    dmax = diaMes[m-1];

    if (d<1) this -> dia = 1;
    else if(d>dmax) this -> dia = dmax;
    else this -> dia = d;

}

bool Fecha::bisiesto(){
    bool bis;
    if((this -> anio%4 == 0 && this -> anio%100 != 0) || this -> anio%400 == 0)
        bis = true;
    return bis;
}

void Fecha::setFecha (const int &d, const int &m, const int &a){
    int diaMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dmax;

    this -> anio = a;

    if(this -> bisiesto()) diaMes[1] = 29;

    if (m<1) this -> mes = 1;
    else if (m>12) this -> mes = 12;
    else this -> mes = m;

    dmax = diaMes[m-1];

    if (d<1) this -> dia = 1;
    else if(d>dmax) this -> dia = dmax;
    else this -> dia = d;
}

void Fecha::ver(){
    //if (d<10) cout <<"0"<<this->dia<<"/";
    //Otra manera:

    cout << setfill('0') << setw(2) << this->dia << "/";
    cout << setfill('0') << setw(2) << this->mes << "/" << this->anio;
}

Fecha Fecha::operator++(){
    int diaMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dmax;

    if(this -> bisiesto()) diaMes[1] = 29;
    dmax = diaMes[this -> mes-1];
    this -> dia++;

    if (this -> dia > dmax) {
        this -> dia = 1;
        this -> mes++;
        if (this -> mes > 12) {
            this -> mes = 1;
            this -> anio++;
        }
    }
    return *this;
}


Fecha Fecha::operator++(int i){
    int diaMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dmax;
if(this -> bisiesto())
        diaMes[1] = 29;
    if(this -> bisiesto()) diaMes[1] = 29;
    dmax = diaMes[this -> mes-1];
    this -> dia++;

    if (this -> dia > dmax) {
        this -> dia = 1;
        this -> mes++;
        if (this -> mes > 12) {
            this -> mes = 1;
            this -> anio++;
        }
    }
    return *this;
}
/*
Fecha Fecha::operator+(Fecha f){
    int diaMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dmax;

    this -> dia += f.dia;

    this -> mes += f.mes;
    if(this -> bisiesto()) diaMes[1] = 29;

    if(this -> mes > 12) {
        this -> mes -= 12;
        this -> anio++;
        }
    this -> anio += f.€zyanio;
    dmax = diaMes[this -> mes-1];
    if (this -> dia > dmax) {
            this -> dia -= dmax;
            this -> mes++;
    }

    return *this;
}
*/


Fecha Fecha::operator+(int n){
    int diaMes [] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int dmax;

    dmax = diaMes[this -> mes-1];
    while (n > dmax - (this->dia)) {

        this -> mes++;
        n = n + (this -> dia) - dmax;
        this -> dia = 1;

        if(this -> bisiesto())
        diaMes[1] = 29;

        dmax = diaMes [this -> mes];

        if ((this -> mes) > 11){
            this -> mes = 1;
            this -> anio;
            dmax = diaMes [0];
        }
    }
    this -> dia += n;

    return *this;
}

