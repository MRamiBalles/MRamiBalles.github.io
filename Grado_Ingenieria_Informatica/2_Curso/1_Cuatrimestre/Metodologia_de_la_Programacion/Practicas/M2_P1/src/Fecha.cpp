#include "Fecha.h"
#include <iostream>

using namespace std;

Fecha::Fecha(const int &d, const int &m, const int &a){
    setFecha(d, m, a);
}

bool Fecha::bisiesto() const{
    return (this-> anio%400 == 0 || (this-> anio%4 == 0 && this-> anio%100 != 0));
}

void Fecha::setFecha(const int &d, const int &m, const int &a){
    int diaMax;

    this-> dia = d;
    this-> mes = m;
    this->anio = a;

    if (m < 1) this-> mes = 1;
    else if (m > 12) this-> mes = 12;

    int DiaMes [] = {0,31,bisiesto()?29:28,31,30,31,30,31,31,30,31,30,31};
    diaMax = DiaMes [this-> mes];

    if (d < 1) this-> dia = 1;
    else if(d > diaMax) this-> dia = diaMax;
}

void Fecha::ver() const{
    cout << (this-> dia < 10?"0":"") << this-> dia << "/" << (this-> mes < 10?"0":"") << this-> mes << "/" << this-> anio;
}

Fecha Fecha::operator++(){
    int diaMax;
    int DiaMes [] = {0,31,bisiesto()?29:28,31,30,31,30,31,31,30,31,30,31};
    diaMax = DiaMes [this-> mes];

    this-> dia++;
    if (this-> dia > diaMax) {
        this-> dia = 1;
        this-> mes++;

        if (this-> mes > 12){
            this-> mes = 1;
            this-> anio++;
        }
    }
    return *this;
}


Fecha Fecha::operator++(int i){
    Fecha f(*this);
    ++*this;
    return f;
}

Fecha Fecha::operator+(const int &n) const{
    int diaMax;
    int DiaMes [] = {0,31,bisiesto()?29:28,31,30,31,30,31,31,30,31,30,31};
    diaMax = DiaMes [this-> mes];

    Fecha f(*this);
    f.dia += n;

    while (f.dia>diaMax) {
        f.dia -= diaMax;
        f.mes++;
        if(f.mes > 12){
            f.mes = 1;
            f.anio++;
        }
    }
    return f;
}

Fecha operator+(const int &a, const Fecha &f){
    return f+a;
}

ostream& operator<<(ostream &s, const Fecha &f){
    s << (f.getDia()<10?"0":"") << f.getDia() << " ";
    switch(f.getMes()){
        case 1: s << "ene";
        break;
        case 2: s << "feb";
        break;
        case 3: s << "mar";
        break;
        case 4: s << "abr";
        break;
        case 5: s << "may";
        break;
        case 6: s << "jun";
        break;
        case 7: s << "jul";
        break;
        case 8: s << "ago";
        break;
        case 9: s << "sep";
        break;
        case 10: s << "oct";
        break;
        case 11: s << "nov";
        break;
        case 12: s << "dic";
        break;
    }
    s << " " << f.getAnio();

    return s;
}
