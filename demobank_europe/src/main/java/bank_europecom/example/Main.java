package bank_europecom.example;

import cuentas.*;
import clientes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;

        while (true) {
            System.out.println("\n--- Menu Banco Europe ---");
            System.out.println("1. Registrar Cliente y Cuenta Bancaria");
            System.out.println("2. Ver datos del Cliente y Cuenta");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Girar dinero");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    if (cliente == null) {
                        System.out.print("Ingrese nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese RUT del cliente: ");
                        String rut = scanner.nextLine();

                        System.out.println("Seleccione el tipo de cuenta:");
                        System.out.println("1. Cuenta Corriente");
                        System.out.println("2. Cuenta Ahorros");
                        System.out.println("3. Cuenta Digital");
                        System.out.print("Ingrese opción: ");
                        int tipoCuenta = scanner.nextInt();
                        scanner.nextLine(); 

                        CuentaBancaria cuenta = switch (tipoCuenta) {
                            case 1 -> new CuentaCorriente();
                            case 2 -> new CuentaAhorros();
                            case 3 -> new CuentaDigital();
                            default -> null;
                        };

                        if (cuenta == null) {
                            System.out.println("Opcion invalida.");
                            continue;
                        }

                        cliente = new Cliente(nombre, rut, cuenta);
                        System.out.println("\nCliente registrado exitosamente!");
                        System.out.println("Numero de cuenta generado: " + cuenta.getNumeroCuenta());
                    } else {
                        System.out.println("Ya existe un cliente registrado. No se puede crear otra cuenta.");
                    }
                    break;
                    
                case 2:
                    if (cliente != null) cliente.mostrarInformacionCliente();
                    else System.out.println("No hay cliente registrado aun.");
                    break;

                case 3:
                    if (cliente != null) {
                        System.out.print("Ingrese monto a depositar: ");
                        double monto = scanner.nextDouble();
                        cliente.getCuenta().depositar(monto);
                        System.out.println("Deposito realizado exitosamente.");
                    } else {
                        System.out.println("Debe registrar un cliente primero.");
                    }
                    break;

                case 4:
                    if (cliente != null) {
                        System.out.print("Ingrese monto a girar: ");
                        double monto = scanner.nextDouble();
                        if (cliente.getCuenta().retirar(monto)) System.out.println("Giro exitoso.");
                        else System.out.println("Fondos insuficientes.");
                    } else {
                        System.out.println("Debe registrar un cliente primero.");
                    }
                    break;

                case 5:
                    if (cliente != null) System.out.println("Saldo actual: $" + cliente.getCuenta().getSaldo());
                    else System.out.println("Debe registrar un cliente primero.");
                    break;

                case 6:
                    System.out.println("Gracias por usar Banco Europe.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
