package cuentas;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente() {
        super(); // Llama al constructor sin parámetros
    }

    @Override
    public double calcularInteres() {
        return saldo * 0.02; // 2% de interés
    }
}
