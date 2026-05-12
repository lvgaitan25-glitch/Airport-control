package modelos;

public class Pasajero {
    private int id; // Atributo para el ID del ticket
    private String nombre;
    private String destino;

    public Pasajero(int id, String nombre, String destino) {
        this.id = id;
        this.nombre = nombre;
        this.destino = destino;
    }

    // EL MÉTODO QUE FALTA: Este es el que resuelve el error
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    // Setters por si necesitas modificar datos luego
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDestino(String destino) { this.destino = destino; }
}