#include <typeinfo>
#include <cstdio>
#include "Empresa.h"
#include "Fecha.h"

using namespace std;

Empresa::Empresa() : nmaxcli(100){
    ncli = 0;

    ncon = 0;
    nmaxcon = 10;

    this -> contratos = new Contrato*[10];
}

Empresa::~Empresa(){
    for(int i = 0; i < ncli; i++)
        delete clientes[i];
    for(int i = 0; i < ncon; i++)
        delete contratos[i];
    delete [] contratos;
}

int Empresa::buscarCliente(long int dni) const {
    bool encontrado=false;
    int i=0;
    while(i<this->ncli && !encontrado){
        if(this->clientes[i]->getDni()==dni)
            encontrado=true;
        else i++;
    }
    if (i==ncon) i=-1;

    return i;
}

void Empresa::altaCliente(Cliente *c){
    if (this->ncli < this->nmaxcli) {
        this->clientes [ncli]=c;
        this->ncli++;
    }
}

void Empresa::crearContrato(){
    long int dni;
    cout << "Introduzca DNI: ";
    cin >> dni;

    int iCliente = -1, i = 0;
    while(i < this->ncli && iCliente == -1){
        if(this->clientes[i]->getDni() == dni)
            iCliente = i;
        else i++;
    }

    if(iCliente == -1 && this->ncli < this->nmaxcli){
        iCliente = this->ncli++;
        char nombre[50];
        int dia, mes, anio;
        cout << "Nombre del cliente: ";
        cin.ignore();
        cin.getline(nombre, 50);
        cout << "Fecha de registro (dia, mes, anio): ";
        cin >> dia >> mes >> anio;
        this->clientes[iCliente] = new Cliente(dni, nombre, Fecha(dia, mes, anio));
    }

    if(iCliente != -1){
        int tipoContrato;
        cout << "Tipo de contrato a abrir (1-Tariafa Plana, 2-Movil): ";
        cin >> tipoContrato;

        int dia, mes, anio;
        cout << "Fecha del contrato (dia, mes, anio): ";
        cin >> dia >> mes >> anio;

        int minutosHablados;
        cout << "Introduzca los minutos hablados: ";
        cin >> minutosHablados;


        if(tipoContrato == 2){
            float precioMinuto;
            cout << "Precio minuto: ";
            cin >> precioMinuto;
            char nac[20];
            cout << "Nacionalidad: ";
            cin >> nac;
            this->contratos[this->ncon++] = new ContratoMovil(dni, Fecha(dia, mes, anio), precioMinuto, minutosHablados, nac);
        }else if(tipoContrato == 1){
            //El contrato de tarifa plana no requiere mas datos
            this->contratos[this->ncon++] = new ContratoTP(dni, Fecha(dia, mes, anio), minutosHablados);
        }else{
            cout << "Tipo de contrato invalido.\n Operación cancelada.\n";
        }

        //Si la tabla esta llena, la amplio al doble
        if(this->ncon == this->nmaxcon){
            this->nmaxcon *= 2;
            Contrato **tmp = new Contrato*[nmaxcon];
            for(int i = 0; i < ncon; i++)
                tmp[i] = this->contratos[i];

            delete [] contratos;
            this->contratos = tmp;
        }
    }else{
        cout << "No se pudo registrar al cliente.\n";
    }
    cout << endl;
}

bool Empresa::cancelarContrato(int idContrato){
    bool eliminado = false;
    int i = 0;

    while(i < this->ncon && !eliminado){
        if(this->contratos[i]->getIdContrato() == idContrato){
            delete contratos[i];
            while(i < this->ncon-1)
                this->contratos[i] = this->contratos[++i];
            this->ncon--;
            eliminado = true;
        }else i++;
    }

    //Si la tabla esta menos de medio vacia, la reduzco a la mitad
    if(this->ncon < this->nmaxcon/2){
        this->nmaxcon /= 2;
        Contrato **tmp = new Contrato*[nmaxcon];
        for(int i = 0; i < this->ncon; i++)
            tmp[i] = this->contratos[i];

        delete [] contratos;
        contratos = tmp;
    }

    return eliminado;
}

bool Empresa::bajaCliente(long int dni){
    bool eliminado = false;
    int i = 0;

    while(i < this->ncon){
        if(this->contratos[i]->getDniContrato() == dni){
            cancelarContrato(this->contratos[i]->getIdContrato());
        }else i++;
    }

    i = 0;
    while(i < this->ncli && !eliminado){
        if(this->clientes[i]->getDni() == dni){
            delete clientes[i];
            while(i < this->ncli-1){
                this->clientes[i] = this->clientes[i+1];    //Aqui no le daba la gana de dejarme hacerlo todo una linea
                i++;
            }
            this->ncli--;
            eliminado = true;
        }else i++;
    }
    return eliminado;
}

int Empresa::descuento(float porcentaje)const{
    int afectados = 0;
    porcentaje = 1 - porcentaje/100;

    for(int i = 0; i < this->ncon; i++){ //typeid sirve para comprobar si un punteros de la clase base apunta hacia una de sus clases derivadas
        if(ContratoMovil *c = dynamic_cast<ContratoMovil*>(this->contratos[i])){
            c->setPrecioMinuto(c->getPrecioMinuto()*porcentaje);
            afectados++;
        }
    }

    return afectados;
}

int Empresa::nContratosTP() const{
    int tarifasPlanas = 0;

    for(int i = 0; i < ncon; i++)
        if(typeid(*contratos[i]) == typeid(ContratoTP))
            tarifasPlanas++;

    return tarifasPlanas;
}

void Empresa::ver() const {
    cout << "La Empresa tiene "<<ncli<<" clientes y "<<ncon<<" contratos" << endl;

    cout << "Clientes:" << endl;
    for(int i = 0; i < ncli; i++)
        cout << *clientes[i] << endl;

    cout << endl << "Contratos:" << endl;
    for(int i = 0; i < ncon; i++){
        contratos[i]->ver();
        cout << endl;
    }
}



void Empresa::cargarDatos(){
    clientes[ncli++] = new Cliente(75547001, "Peter Lee", Fecha(28, 2, 2001));
    clientes[ncli++] = new Cliente(45999000, "Juan Perez", Fecha(29, 2, 2000));
    clientes[ncli++] = new Cliente(37000017, "Luis Bono", Fecha(31, 1, 2002));

    contratos[ncon++] = new ContratoMovil(75547001, Fecha(28, 2, 2001), 0.12, 110, "DANES");
    contratos[ncon++] = new ContratoMovil(75547001, Fecha(31, 1, 2002), 0.09, 170, "DANES");
    contratos[ncon++] = new ContratoTP(37000017, Fecha(1, 2, 2002), 250);
    contratos[ncon++] = new ContratoTP(75547001, Fecha(28, 2, 2001), 312);
    contratos[ncon++] = new ContratoMovil(45999000, Fecha(31, 1, 2002), 0.10, 202, "ESPANOL");
    contratos[ncon++] = new ContratoMovil(75547001, Fecha(31, 1, 2002), 0.15, 80, "DANES");
    contratos[ncon++] = new ContratoTP(45999000, Fecha(1, 2, 2002), 400);
}
