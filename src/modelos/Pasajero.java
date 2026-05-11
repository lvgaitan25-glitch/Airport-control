package modelos;

public class Pasajero {
    private int ticket;
    private String nombre;
    private String destino;

    // Constructor completo
    public Pasajero(int ticket, String nombre, String destino) {
        this.ticket = ticket;
        this.nombre = nombre;
        this.destino = destino;
    }

    // Getters (necesarios para mostrar los datos en las tablas)
    public int getTicket() { return ticket; }
    public String getNombre() { return nombre; }
    public String getDestino() { return destino; }

    @Override
    public String toString() {
        return "Ticket: " + ticket + " | Pasajero: " + nombre;
    }
}