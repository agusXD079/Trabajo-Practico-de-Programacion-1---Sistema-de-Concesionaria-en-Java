package modelo;

public class Vendedor extends Persona {

    private String legajo;
    private int ventasRealizadas;

    public Vendedor(String nombre, String apellido, int dni, String legajo) {
        super(nombre, apellido, dni);
        this.legajo = legajo;
        this.ventasRealizadas = 0;
    }

    public void registrarVenta() {
        ventasRealizadas++;
    }

    public String getLegajo()        { return legajo; }
    public int getVentasRealizadas() { return ventasRealizadas; }

    @Override
    public String toString() {
        return "Vendedor: " + getNombreCompleto() + " | Legajo: " + legajo +
               " | Ventas: " + ventasRealizadas;
    }
}
