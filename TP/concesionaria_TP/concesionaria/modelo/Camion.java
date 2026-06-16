package modelo;

public class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String marca, String modelo, double precio, double capacidadCarga) {
        super(marca, modelo, precio);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String getTipo() { return "Camion"; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("   Capacidad de carga: " + capacidadCarga + " tn");
    }

    public double getCapacidadCarga() { return capacidadCarga; }
}
