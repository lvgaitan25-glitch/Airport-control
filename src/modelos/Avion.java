public class Avion {

    String id;
    String modelo;
    String estado;

    public Avion(String id, String modelo, String estado) {

        this.id = id;
        this.modelo = modelo;
        this.estado = estado;
    }

    public void mostrarInfo() {

        System.out.println("ID: " + id +
                " | Modelo: " + modelo +
                " | Estado: " + estado);
    }
}