#ifndef CLIENTE_H
#define CLIENTE_H
#include "Fecha.h"

class Cliente  //Clase robusta (sin friend, encapsulamiento)
{
    long int dni;
    char *nombre;
    Fecha fechaAlta;

    public:
        Cliente (long int d, char *n, Fecha f);
        Cliente (const Cliente &c); //Ctor copia -> Puntero (nombre)
        ~Cliente();

        Cliente& operator=(const Cliente &c);
        bool operator==(const Cliente &c) const;

        long int getDni() const {return dni;}
        const char* getNombre() const {return nombre;}
        Fecha getFecha() const {return fechaAlta;}
        void setNombre(char *n);
        void setFecha(const Fecha &f);
};
ostream& operator<<(ostream& s, const Cliente &c);

#endif // CLIENTE_H
