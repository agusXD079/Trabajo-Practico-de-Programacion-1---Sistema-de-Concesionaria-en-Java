package modelo;

import excepciones.VehiculoNoDisponibleException;
import interfaces.ITransaccionable;
import java.io.Serializable;

public abstract class Vehiculo implements ITransaccionable, Serializable {

    private static final long serialVersionUID = 1L;

    private String marca;
    private String modelo;
    private double precio;
    private EstadoVehiculo estado;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.estado = EstadoVehiculo.DISPONIBLE;
    }

    public abstract String getTipo();

    @Override
    public void vender() throws VehiculoNoDisponibleException {
        if (estado != EstadoVehiculo.DISPONIBLE) {
            throw new VehiculoNoDisponibleException(
                "El vehiculo " + marca + " " + modelo + " no esta disponible (estado: " + estado + ")"
            );
        }
        estado = EstadoVehiculo.VENDIDO;
    }

        @Override
    public void hacerTestDrive() throws VehiculoNoDisponibleException {

        if (estado != EstadoVehiculo.DISPONIBLE) {
            throw new VehiculoNoDisponibleException(
                "No se puede hacer test drive: estado actual es " + estado
            );
        }

        estado = EstadoVehiculo.EN_TEST_DRIVE;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("[" + getTipo() + "] " + marca + " " + modelo +
            " - $" + precio + " - " + estado);
    }

    public String getMarca()  { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }
    public EstadoVehiculo getEstado() { return estado; }
    public void setEstado(EstadoVehiculo estado) { this.estado = estado; }
    public void setPrecio(double precio) { this.precio = precio; }
}
