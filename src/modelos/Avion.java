package modelos;

public class Avion {

    private String id;
    private String modelo;
    private String estado;

    public Avion(String id, String modelo, String estado) {
        this.id = id;
        this.modelo = modelo;
        this.estado = estado;
    }

    public String getId() { return id; }
    public String getModelo() { return modelo; }
    public String getEstado() { return estado; }

    public String info() {
        return id + " | " + modelo + " | " + estado;
    }
}