package clientes;

import cuentas.CuentaBancaria;

public class Cliente implements InfoCliente {
    private String nombre;
    private String rut;
    private CuentaBancaria cuenta;

    public Cliente(String nombre, String rut, CuentaBancaria cuenta) {
        this.nombre = nombre;
        this.rut = rut;
        this.cuenta = cuenta;
    }

    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Cliente: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Número de Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: $" + cuenta.getSaldo());
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }
}