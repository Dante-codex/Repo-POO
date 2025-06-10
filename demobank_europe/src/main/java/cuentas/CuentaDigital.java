package cuentas;

public class CuentaDigital extends CuentaBancaria {
    public CuentaDigital() {
        super();
    }

    @Override
    public double calcularInteres() {
        return saldo * 0.03; 
    }
}
