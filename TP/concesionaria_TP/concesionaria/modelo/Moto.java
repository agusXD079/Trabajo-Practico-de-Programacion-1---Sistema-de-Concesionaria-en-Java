package modelo;

public class Moto extends Vehiculo {
    private String tipo;

    public Moto(String marca, String modelo, double precio, String tipo) {
        super(marca, modelo, precio);
        this.tipo = tipo;
    }

    @Override
    public String getTipo() { return "Moto"; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("   Tipo: " + tipo);
    }

    public String getTipoMoto() { return tipo; }
}
