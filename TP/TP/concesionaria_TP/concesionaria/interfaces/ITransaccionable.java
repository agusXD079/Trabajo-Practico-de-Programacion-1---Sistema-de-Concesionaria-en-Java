package interfaces;

import excepciones.VehiculoNoDisponibleException;

public interface ITransaccionable {
    void vender() throws VehiculoNoDisponibleException;
    void hacerTestDrive() throws VehiculoNoDisponibleException;
    void mostrarInfo();
}
