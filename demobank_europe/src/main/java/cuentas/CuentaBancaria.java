package cuentas;

import java.util.Random;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;

    // Constructor: genera número de cuenta y saldo inicial en 0
    public CuentaBancaria() {
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = 0;
    }

    private String generarNumeroCuenta() {
        return String.valueOf(100000000 + new Random().nextInt(900000000)); // Número de 9 dígitos
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public abstract double calcularInteres();
}
