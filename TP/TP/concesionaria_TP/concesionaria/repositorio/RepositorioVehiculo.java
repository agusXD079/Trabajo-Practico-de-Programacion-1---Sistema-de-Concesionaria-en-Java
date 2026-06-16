package repositorio;

import interfaces.IRepositorio;
import modelo.Vehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVehiculo implements IRepositorio {

    private static final String ARCHIVO = "vehiculos.dat";

    @Override
    public void guardar(List<Vehiculo> vehiculos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(vehiculos);
            System.out.println("Inventario guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            System.out.println("Operacion de guardado finalizada.");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vehiculo> cargar() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("No se encontro archivo de datos. Iniciando con inventario vacio.");
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Vehiculo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            System.out.println("Operacion de carga finalizada.");
        }
    }
}
