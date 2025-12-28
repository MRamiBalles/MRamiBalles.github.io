#include "Cliente.h"
#include <cstring>

Cliente::Cliente (long int d, char *n, Fecha f):fechaAlta(f){
    this-> dni = d;
    this-> nombre = new char[strlen(n)+1];
    strcpy(this-> nombre, n);
}

Cliente::Cliente (const Cliente &c):fechaAlta(c.fechaAlta){
    this-> dni = c.dni;
    this-> nombre = new char[strlen(c.nombre)+1];
    strcpy(this-> nombre, c.nombre);
}

Cliente::~Cliente(){
    delete [] nombre;
}

Cliente& Cliente::operator=(const Cliente &c){
    if (this != &c){ //Comprobar que no copiamos el mismo objeto
        this-> dni = c.dni;
        delete [] this-> nombre;
        this-> nombre = new char [strlen(c.nombre)+1];
        strcpy(this-> nombre, c.nombre);
        this-> fechaAlta = c.fechaAlta;
    }
    return *this;
}

bool Cliente::operator==(const Cliente &c) const{
    return this-> dni == c.dni;
}

void Cliente::setNombre(char *n){
    delete [] this-> nombre;
    this-> nombre = new char [strlen(n)+1];
    strcpy(this-> nombre, n);
}

void Cliente::setFecha(const Fecha &f){
    fechaAlta = f;
}

ostream& operator<<(ostream &s, const Cliente &c){
    s << c.getNombre() << " (" << c.getDni() << " - " << c.getFecha() << ")";
    return s;
}
