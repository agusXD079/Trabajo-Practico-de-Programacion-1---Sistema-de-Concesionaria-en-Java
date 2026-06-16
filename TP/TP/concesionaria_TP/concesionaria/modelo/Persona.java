package modelo;

import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Comparable<Persona>, Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private int dni;

    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public int compareTo(Persona otra) {
        return this.apellido.compareToIgnoreCase(otra.apellido);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona otra = (Persona) obj;
        return this.dni == otra.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public String getNombre()   { return nombre; }
    public String getApellido() { return apellido; }
    public int getDni()         { return dni; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
