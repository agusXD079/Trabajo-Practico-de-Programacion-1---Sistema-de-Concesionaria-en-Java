import concesionaria.Concesionaria;
import java.util.Scanner;
import modelo.*;

public class Main {

    private static Concesionaria concesionaria = new Concesionaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
                continue;
            }
            procesarOpcion(opcion);
        } while (opcion != 0);

        concesionaria.guardarDatos();
        System.out.println("Hasta luego!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n======= CONCESIONARIA =======");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Vender vehiculo");
        System.out.println("4. Mostrar vehiculos disponibles");
        System.out.println("5. Mostrar inventario ordenado por precio");
        System.out.println("7. Realizar test drive");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarVehiculo();
                break;
            case 2:
                registrarCliente();
                break;
            case 3:
                venderVehiculo();
                break;
            case 4:
                concesionaria.mostrarVehiculosDisponibles();
                break;
            case 5:
                concesionaria.mostrarInventarioOrdenadoPorPrecio();
                break; 


                
            case 7:
                realizarTestDrive();
                break;
            case 0:
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static void agregarVehiculo() {
        System.out.println("Tipo de vehiculo: 1) Auto  2) Moto  3) Camion");
        int tipo;
        try {
            tipo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tipo no valido.");
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        switch (tipo) {
            case 1:
                concesionaria.agregarVehiculo(new Auto(marca, modelo, precio));
                break;
            case 2:
                System.out.print("Tipo de moto (deportiva/scooter/cross): ");
                String tipoMoto = scanner.nextLine();
                concesionaria.agregarVehiculo(new Moto(marca, modelo, precio, tipoMoto));
                break;
            case 3:
                System.out.print("Capacidad de carga (tn): ");
                double carga = Double.parseDouble(scanner.nextLine());
                concesionaria.agregarVehiculo(new Camion(marca, modelo, precio, carga));
                break;
            default:
                System.out.println("Tipo no valido.");
        }
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        int dni = Integer.parseInt(scanner.nextLine());
        concesionaria.registrarCliente(new Cliente(nombre, apellido, dni));
    }

    private static void venderVehiculo() {
        System.out.print("Modelo del vehiculo a vender: ");
        String modelo = scanner.nextLine();
        System.out.print("DNI del cliente: ");
        int dni = Integer.parseInt(scanner.nextLine());
        concesionaria.venderVehiculo(modelo, dni);
    }
    
    private static void realizarTestDrive() {

    System.out.print("Modelo del vehiculo para test drive: ");
    String modelo = scanner.nextLine();

    concesionaria.realizarTestDrive(modelo);
}
}
