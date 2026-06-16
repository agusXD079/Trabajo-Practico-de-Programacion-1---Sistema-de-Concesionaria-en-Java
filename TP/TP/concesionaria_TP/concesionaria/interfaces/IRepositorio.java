package interfaces;

import java.util.List;
import modelo.Vehiculo;

public interface IRepositorio {
    void guardar(List<Vehiculo> vehiculos);
    List<Vehiculo> cargar();
}
