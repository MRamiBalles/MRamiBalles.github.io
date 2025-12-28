#ifndef COMPLEJO_H
#define COMPLEJO_H

#include <iostream>

using namespace std;

class complejo
{
    int real;
    int imaginario;

    public:
        complejo(int r, int i=0);
        //complejo(int r) {real=r; imaginario=0;}
        //complejo (const complejo& c) {real = c.real; imaginario=c.imaginario;} //No es necesario en esta práctica.
        virtual ~complejo();

        int getr() const {return real;}
        int geti() const {return imaginario;}
        void set();
        void set(int r, int i);
        void ver() const;

        complejo operator+(complejo c) const;
        complejo operator+(int n) const;
        complejo operator-() const;

        //friend complejo operator+(int n, complejo c);
        //friend ostream& operator<<(ostream& s, complejo c);

        //PARTE 2:

        //void operator++();
        //void operator++(int);

        complejo operator++();
        complejo operator++(int);

        bool operator==(complejo c);
        bool operator==(int i);

        operator int();
};

complejo operator+(int n, complejo c);
ostream& operator<<(ostream& s, complejo c);



#endif // COMPLEJO_H
