package modelo;

public class Auto extends Vehiculo {

    public Auto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public String getTipo() { return "Auto"; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
    }
}
