package estructuras;
import modelos.Pasajero;

public class NodoPasajero {
    private Pasajero pasajero;
    private NodoPasajero izquierdo, derecho;

    public NodoPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.izquierdo = this.derecho = null;
    }
    // Getters y Setters...
    public Pasajero getPasajero() { return pasajero; }
    public void setPasajero(Pasajero p) { this.pasajero = p; }
    public NodoPasajero getIzquierdo() { return izquierdo; }
    public void setIzquierdo(NodoPasajero n) { this.izquierdo = n; }
    public NodoPasajero getDerecho() { return derecho; }
    public void setDerecho(NodoPasajero n) { this.derecho = n; }
}