package modelos;

public class Pasajero {
    private int id; 
    private String nombre;
    private String destino;

    public Pasajero(int id, String nombre, String destino) {
        this.id = id;
        this.nombre = nombre;
        this.destino = destino;
    }

    // El método getId es indispensable para la lógica del Árbol Binario
    public int getId() {
        return id;
    }

    public String getNombre() { return nombre; }
    public String getDestino() { return destino; }
}