#include "Empresa.h"
#include <typeinfo>


Empresa::Empresa(): nMaxCli(100){
    this-> nCli = 0;
    this-> nCon = 0;
    this-> nMaxCon = 10;
    this-> contratos = new Contrato*[nMaxCon];

}

Empresa::~Empresa(){
    for (int i=0; i < nCli; i++)
        delete [] clientes[i];
    for (int i=0; i < nCon; i++)
        delete [] contratos[i];
    delete [] contratos;
}

int Empresa::buscarCliente(long int d) const{
    int i=0, cli=-1;
    while (i < this-> nCli && cli == -1){
        if (this-> clientes[i]-> getDni() == d)
            cli = i;
        else i++;
    }
    return cli;
}

void Empresa::crearContrato(){
    char nom[50];
    int pos, tipo, d, m, a, mi;
    long int dni;
    float p;
    char nac[30];

    cout << "Introduzca dni: ";
    cin >> dni;

    pos = buscarCliente(dni);
    if(pos == -1){
        cout << "Nombre del cliente: ";
        cin.ignore();
        cin.getline(nom, 50);
        cout << "Fecha del contrato" << endl;
        cout << "dia: "; cin >> d;
        cout << "mes: "; cin >> m;
        cout << "anio: "; cin >> a;
        Cliente *cli;
        cli = new Cliente(dni, nom, Fecha(d, m, a));
        pos = this-> altaCliente(cli);

        if (pos == -1) {
            delete cli;
            cout << "Error al dar de alta al cliente."<<endl;
        }
    }
    Contrato *c;
    if(pos != -1){
        cout << "Tipo de contrato a abrir (1-Tarifa Plana, 2-Movil): ";
        cin >> tipo;
        cout << "Fecha del contrato" << endl;
        cout << "dia: "; cin >> d;
        cout << "mes: "; cin >> m;
        cout << "anio: "; cin >> a;
        cout << "minutos hablados: ";
        cin >> mi;

        if(tipo == 2){
            cout << "Precio minuto: ";
            cin >> p;
            cout << "Nacionalidad: ";
            cin >> nac;
            cout << endl;
            c = new ContratoMovil(dni, Fecha(d, m, a), p, mi, nac);
        }
        else if (tipo == 1){
            cout << endl;
            c = new ContratoTP(dni, Fecha(d, m, a), mi);
        }
        else cout << "Tipo de contrato incorrecto.";
        this-> altaContrato(c);
    } else cout << "Error guardando al cliente."<<endl;
}

int Empresa::buscarContrato(int id) const{
    int i=0, con=-1;
    while (i < this-> nCon && con == -1){
        if (this-> contratos[i]-> getIdContrato() == id) con = i;
        else i++;
    }
    return con;
}

int Empresa::altaCliente(Cliente *c){
    int cli = -1;
    if (this-> nCli < this-> nMaxCli){  //Si cabe en el array estático de clientes
        cli = this-> nCli;
        this-> clientes[this-> nCli] = c;
        this-> nCli++;
    }
    return cli;
}

void Empresa::altaContrato(Contrato *c){
    if(this-> nCon < this-> nMaxCon){ //Si no está lleno el array de contratos
        this-> contratos[this-> nCon] = c;
        this->  nCon++;
    }
    else{
        Contrato **nc;
        nc = this-> contratos;
        this-> contratos = new Contrato*[this-> nMaxCon*2];

        for(int i=0; i < this-> nCon; i++) //Copiamos los contratos en el nuevo array ampliado
            this-> contratos[i] = nc[i];
        delete [] nc;
        this-> nMaxCon *= 2;
        this-> contratos [this-> nCon] = c;
        this-> nCon++;
    }
}

bool Empresa::cancelarContrato(int id){
    bool cancelado = false;
    int pos = buscarContrato(id);

    if (pos != -1){  //Si existe el contrato
        delete this-> contratos[pos];
        for (int i = pos; i < this-> nCon-1; i++)
            this-> contratos[i] = this-> contratos[i+1]; // !!
        this-> nCon--; cancelado = true;
    }
    return cancelado;
}

bool Empresa::bajaCliente(long int d){
    bool cancelado = false;
    int pos = buscarCliente(d);

    if (pos != -1){ //Si existe el cliente
        for (int i = this-> nCon-1; i >= 0; i--){
            if (this-> contratos[i]->getDniContrato()==d)
                cancelarContrato(this-> contratos[i]-> getIdContrato()); //Anulamos todos sus contratos asociados al cliente
        }
        delete this-> clientes[pos];
        for (int i=pos; i < this-> nCli-1; i++)
            this-> clientes[i] = this-> clientes[i+1];

        this-> nCli--; cancelado = true;
    }
    return cancelado;
}

int Empresa::nContratosTP() const{
    int nc=0;
    for (int i=0; i < this-> nCon; i++){
        if (typeid(ContratoTP) == typeid(*this->contratos[i]))
            nc++;
    }
    return nc;
}

void Empresa::descuento(float porc){
    for (int i=0; i < this-> nCon; i++){
        if (ContratoMovil *c = dynamic_cast<ContratoMovil*>(contratos[i])){
            c-> setPrecioMinuto(c-> getPrecioMinuto()*(1 - porc/100));
        }
    }
}

void Empresa::ver() const{
    cout << endl;
    cout << "La empresa tiene " << this-> nCli << " clientes y " << this-> nCon << " contratos" <<endl;
    cout << "Clientes: "<< endl;
    for (int i = 0; i < this-> nCli; i++)
        cout << *clientes[i] << endl;
    cout << endl;
    cout << "Contratos: " << endl;
    for (int i = 0; i < this-> nCon; i++) {
        this-> contratos[i] -> ver();
        cout << endl;
    }

}

void Empresa::cargarDatos(){
    this-> clientes[this-> nCli++] = new Cliente(75547001, "Peter Lee", Fecha(28, 2, 2001));
    this-> clientes[this-> nCli++] = new Cliente(45999000, "Juan Perez", Fecha(29, 2, 2000));
    this-> clientes[this-> nCli++] = new Cliente(37000017, "Luis Bono", Fecha(31, 1, 2002));

    this-> contratos[this-> nCon++] = new ContratoMovil(75547001, Fecha(28, 2, 2001), 0.12, 110, "DANES");
    this-> contratos[this-> nCon++] = new ContratoMovil(75547001, Fecha(31, 1, 2002), 0.09, 170, "DANES");
    this-> contratos[this-> nCon++] = new ContratoTP(37000017, Fecha(1, 2, 2002), 250);
    this-> contratos[this-> nCon++] = new ContratoTP(75547001, Fecha(28, 2, 2001), 312);
    this-> contratos[this-> nCon++] = new ContratoMovil(45999000, Fecha(31, 1, 2002), 0.10, 202, "ESPANOL");
    this-> contratos[this-> nCon++] = new ContratoMovil(75547001, Fecha(31, 1, 2002), 0.15, 80, "DANES"); //Warning strings?
    this-> contratos[this-> nCon++] = new ContratoTP(45999000, Fecha(1, 2, 2002), 400);
}
