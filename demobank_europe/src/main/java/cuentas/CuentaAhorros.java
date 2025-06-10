package cuentas;

public class CuentaAhorros extends CuentaBancaria {
    public CuentaAhorros() {
        super();
    }

    @Override
    public double calcularInteres() {
        return saldo * 0.05; // 5% de interés
    }
}
