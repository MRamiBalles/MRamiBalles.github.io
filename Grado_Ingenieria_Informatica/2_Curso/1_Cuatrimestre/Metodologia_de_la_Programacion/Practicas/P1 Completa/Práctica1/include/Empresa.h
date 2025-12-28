#ifndef EMPRESA_H
#define EMPRESA_H


#include "Fecha.h"
#include "Cliente.h"
#include "Contrato.h"
#include "ContratoTP.h"
#include "ContratoMovil.h"

using namespace std;

class Empresa{
    Cliente *clientes[100];//array estático de punteros a Clientes. Usamos punteros porque Cliente no dispone de un constructor sin parámetros.
    int ncli;           //número clientes que hay en el array (al principio 0)
    const int nmaxcli;//número máximo de clientes que caben en el array (100)
    Contrato **contratos;//array dinámico de punteros a Contratos
    int ncon;            //número de Contratos que hay en el array (al principio 0)
    int nmaxcon;//número máximo de Contratos que caben en el array


    void altaCliente(Cliente *c); //Añade un nuevo Cliente al array
    int buscarCliente(long int dni) const;

public:
    Empresa();
    virtual ~Empresa();
    //EL CONTRUCTOR DE COPIA Y EL OPERADOR DE ASIGNACION NO SE IMPLEMENTAN
    //PORQUE EXPLICITAMENTE SE INDICA EN LA PRACTICA QUE NO SE HAGA

    void crearContrato();
    bool cancelarContrato(int idContrato); //true si existe, false si no
    bool bajaCliente(long int dni);        //true si existe, false si no
    int descuento(float porcentaje) const;//devuelve a cuantos Clientes aplica el descuento
    int nContratosTP() const;
    void ver() const;

    void cargarDatos();

};

#endif // EMPRESA_H
