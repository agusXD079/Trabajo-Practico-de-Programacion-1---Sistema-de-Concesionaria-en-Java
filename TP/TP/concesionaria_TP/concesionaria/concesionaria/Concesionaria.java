package concesionaria;

import excepciones.VehiculoNoDisponibleException;
import java.util.*;
import java.util.stream.Collectors;
import modelo.*;
import repositorio.RepositorioVehiculo;

public class Concesionaria {

    private List<Vehiculo> inventario;
    private HashMap<Integer, Cliente> clientes;
    private HashMap<Integer, Vendedor> vendedores;
    private HashSet<Persona> clientesConCompras;
    private RepositorioVehiculo repositorio;

    public Concesionaria() {
        this.repositorio = new RepositorioVehiculo();
        this.inventario = repositorio.cargar();
        this.clientes = new HashMap<>();
        this.vendedores = new HashMap<>();
        this.clientesConCompras = new HashSet<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        inventario.add(v);
        System.out.println("Vehiculo agregado: " + v.getMarca() + " " + v.getModelo());
    }

    public void venderVehiculo(String modelo, int dniCliente) {
        Optional<Vehiculo> resultado = inventario.stream()
            .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
            .findFirst();

        try {
            if (!resultado.isPresent()) {
                System.out.println("No se encontro el vehiculo: " + modelo);
                return;
            }
            Vehiculo v = resultado.get();
            v.vender();
            Cliente cliente = clientes.get(dniCliente);
            if (cliente != null) {
                cliente.agregarVehiculo(v);
                clientesConCompras.add(cliente);
            }
            System.out.println("Venta realizada: " + v.getMarca() + " " + v.getModelo());
        } catch (VehiculoNoDisponibleException e) {
            System.out.println("Error en venta: " + e.getMessage());
        } finally {
            System.out.println("Operacion de venta finalizada.");
        }
    }
           
    
    
    public void registrarCliente(Cliente c) {
        clientes.put(c.getDni(), c);
        System.out.println("Cliente registrado: " + c.getNombreCompleto());
    }

    public void registrarVendedor(Vendedor v) {
        vendedores.put(v.getDni(), v);
        System.out.println("Vendedor registrado: " + v.getNombreCompleto());
    }

    public List<Vehiculo> getVehiculosDisponibles() {
        return inventario.stream()
            .filter(v -> v.getEstado() == EstadoVehiculo.DISPONIBLE)
            .collect(Collectors.toList());
    }

    public void mostrarInventarioOrdenadoPorPrecio() {
        System.out.println("\n--- Inventario ordenado por precio ---");
        inventario.stream()
            .sorted((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()))
            .forEach(Vehiculo::mostrarInfo);
    }

    public void mostrarVehiculosDisponibles() { 
        System.out.println("\n--- Vehiculos disponibles ---");
        List<Vehiculo> disponibles = getVehiculosDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay vehiculos disponibles.");
        } else {
            disponibles.forEach(Vehiculo::mostrarInfo);
        }
    }
    

    public void ordenarClientesPorApellido() {
        List<Persona> lista = new ArrayList<>(clientes.values());
        Collections.sort(lista);
        System.out.println("\n--- Clientes ordenados por apellido ---");
        lista.forEach(p -> System.out.println(p.getNombreCompleto()));
    }

    public void guardarDatos() {
        repositorio.guardar(inventario);
    }

    public List<Vehiculo> getInventario() { return inventario; }
    public HashMap<Integer, Cliente> getClientes() { return clientes; }

    public void realizarTestDrive(String modelo) {

    Optional<Vehiculo> resultado = inventario.stream()
            .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
            .findFirst();

    try {

        if (resultado.isEmpty()) {
            System.out.println("Vehiculo no encontrado.");
            return;
        }

        Vehiculo vehiculo = resultado.get();

        vehiculo.hacerTestDrive();

        System.out.println("Test Drive realizado correctamente.");

    } catch (VehiculoNoDisponibleException e) {

        System.out.println(e.getMessage());

    } finally {

        System.out.println("Operacion finalizada.");
    }
}
}
