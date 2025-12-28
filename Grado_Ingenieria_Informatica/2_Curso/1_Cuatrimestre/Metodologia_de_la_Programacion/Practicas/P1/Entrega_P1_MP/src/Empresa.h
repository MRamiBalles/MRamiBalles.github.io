#ifndef EMPRESA_H
#define EMPRESA_H

#include "Fecha.h"
#include "Cliente.h"
#include "Contrato.h"
#include "ContratoTP.h"
#include "ContratoMovil.h"

#include <iostream>
using namespace std;

class Empresa
{
    Cliente *clientes[100]; //estático
    int nCli;
    const int nMaxCli;
    Contrato **contratos; //dinámico
    int nCon;
    int nMaxCon; //No es constante al ser variable

    public:
        Empresa();
        virtual ~Empresa();

        int buscarContrato(int id) const;
        void crearContrato();
        int buscarCliente(long int d) const;
        void altaContrato(Contrato *c);
        int altaCliente(Cliente *c);
        bool cancelarContrato(int id);
        bool bajaCliente(long int d);
        int nContratosTP() const;
        void descuento(float porc);

        void ver() const;
        void cargarDatos();
};

#endif // EMPRESA_H
