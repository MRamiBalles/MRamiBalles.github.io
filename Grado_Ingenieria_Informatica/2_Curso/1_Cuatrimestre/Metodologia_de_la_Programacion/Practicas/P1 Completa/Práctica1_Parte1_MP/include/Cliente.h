#ifndef CLIENTE_H
#define CLIENTE_H

#include "Fecha.h"


class Cliente {

    long int dni;
    char *nombre;
    Fecha fechaAlta;


    public:
        //Constructores:
        Cliente(long int d, char *n, Fecha f);

        //Destructor:
        //Por las reservas de memoria!
        virtual ~Cliente();

        //char letraDNI(long int d);
        void setNombre(char *n);

};

#endif // CLIENTE_H
