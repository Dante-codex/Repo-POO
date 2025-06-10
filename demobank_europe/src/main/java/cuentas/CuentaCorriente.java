package cuentas;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente() {
        super();
    }

    @Override
    public double calcularInteres() {
        return saldo * 0.02; 
    }
}
