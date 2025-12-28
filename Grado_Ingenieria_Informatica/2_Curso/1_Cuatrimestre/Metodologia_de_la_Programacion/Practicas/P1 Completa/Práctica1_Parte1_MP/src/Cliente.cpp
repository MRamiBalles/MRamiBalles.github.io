#include "Cliente.h"
#include <cstring>
#include <iostream>

using namespace std;

Cliente::Cliente(long int d, char *n, Fecha f) : fechaAlta(f) {
    this -> dni = d;

    //this -> nombre = n; Incorrecto! Reservar memoria!!
    this -> nombre = new char [strlen(n) + 1];
    strcpy(this -> nombre, n);

    //this -> fechaAlta = f; en la zona de inicialización
}

Cliente::~Cliente() {
    cout << "Borrando el nombre...";
    delete [] this -> nombre;
}


void Cliente::setNombre(char *n){
    //Declarar espacio en memoria por si hay diferentes tamaños de cadenas:
    delete [] this -> nombre;
    this -> nombre = new char [strlen(n) + 1];
    strcpy(this -> nombre, n);
}
