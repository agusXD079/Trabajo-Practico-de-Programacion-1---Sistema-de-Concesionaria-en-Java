package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private List<Vehiculo> vehiculosComprados;

    public Cliente(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        this.vehiculosComprados = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculosComprados.add(v);
    }

    public List<Vehiculo> getVehiculosComprados() {
        return vehiculosComprados;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNombreCompleto() + " (DNI: " + getDni() + ")";
    }
}
