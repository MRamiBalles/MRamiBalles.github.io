#include "complejo.h"
#include <iostream>

using namespace std;

complejo::complejo(int r, int i)
{
    //ctor

    real = r;
    imaginario = i;
}

complejo::~complejo()
{
    //dtor
}


void complejo::set(){
    cout << "Valor parte real: ";
    cin >> real;

    cout << "Valor parte imaginaria: ";
    cin >> imaginario;
}


void complejo::set(int r, int i){
    /* this -> real */ real = r; //complejo::real = r;
    /* this -> imaginario */ imaginario = +i; //complejo::imaginario = i;
}


void complejo::ver() const {
    if (imaginario >= 0)
        cout << real << "+" << imaginario << "i";
    else
        cout << real << imaginario << "i";

    //cout << c1.getr() <<  (c1.geti() > 0) ? "+" : "-" << abs(c1.geti()) << "i" << endl;
}


complejo complejo::operator+(complejo c) const{
    complejo resultado(0,0);
    resultado.real = c.real + real;
    resultado.imaginario = c.imaginario + imaginario;
    return resultado;
}


complejo complejo::operator+(int n) const{
    complejo resultado(real + n, imaginario);
    //resultado.real = real + n;
    return resultado;
}


complejo complejo::operator-() const{
    complejo resultado(-real, -imaginario);
    return resultado;
}



//Funciones amigas:

complejo operator+(int n, complejo c){
    return c+n;
}

ostream& operator<<(ostream& s, complejo c){
    if (c.geti() >= 0) {
        s << c.getr() << "+" << c.geti() << "i";
    } else {
        s << c.getr() << c.geti() << "i";
    }
}

//PARTE 2:

/*
void complejo::operator++() {
    real++;
}

void complejo::operator++(int) {
    real++;
}
*/

complejo complejo::operator++() {
    this -> real++;
    return *this;
}

complejo complejo::operator++(int) {
    complejo c(real, imaginario);
    real++;
    return c;
}

bool complejo::operator==(complejo c) {
    bool iguales = false;
    if (this -> real == c.real && this -> imaginario == c.imaginario)
        iguales = true;
    return iguales;
}

bool complejo::operator==(int i){
    bool iguales = false;
    if(real == i && imaginario == 0)
        iguales = true;
    return iguales;
}

complejo::operator int() {
    return real;
}




