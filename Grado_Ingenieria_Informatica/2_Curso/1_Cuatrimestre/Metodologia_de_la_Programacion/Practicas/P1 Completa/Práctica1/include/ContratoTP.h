#ifndef CONTRATOTP_H
#define CONTRATOTP_H
#include "contrato.h"
#include <iostream>

/**
 * @class ContratoTP
 * @brief Represents a Flat Rate (Tarifa Plana) telephone contract.
 * @details Inherits from the base Contrato class and manages consolidated costs per minute.
 */
class ContratoTP : public Contrato{
private:
    static int limiteMinutos;    /**< Maximum minutes allowed in the flat rate. */
    static float precio;         /**< Fixed monthly price for the flat rate. */
    static const float PRECIO_EXCESO; /**< Penalty cost per minute exceeding the limit. */

public:
    /**
     * @brief Constructor for ContratoTP.
     * @param dni Client's identity number.
     * @param f Date of the contract.
     * @param minutosHablados Total minutes consumed.
     */
    ContratoTP(long int dni, Fecha f, int minutosHablados);

    /**
     * @brief Copy constructor.
     */
    ContratoTP(const ContratoTP &c);

    /**
     * @brief Destructor.
     */
    ~ContratoTP();

    // Static getters and setters
    static int getLimiteMinutos();
    static float getPrecio();
    static void setLimiteMinutos(int l);
    static void setPrecio(float p);
    static void setTarifaPlana(int limiteMinutos, float precio);

    /**
     * @brief Displays the contract details on the standard output.
     */
    void ver() const;

    /**
     * @brief Calculates the total invoice amount for the contract.
     * @return Final amount including excess minutes charges.
     */
    float factura() const;

};

/**
 * @brief Overloads the stream output operator for ContratoTP.
 */
ostream& operator<<(ostream& s, const ContratoTP &o);

#endif // CONTRATOTP_H
