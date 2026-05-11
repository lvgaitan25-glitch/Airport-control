package modelos;

public class Pasajeros {

    int ticket;
    String nombre;
    String destino;
    String asiento;

    public Pasajeros(int ticket, String nombre,
                      String destino, String asiento) {

        this.ticket = ticket;
        this.nombre = nombre;
        this.destino = destino;
        this.asiento = asiento;
    }

    public int getTicket() {
        return ticket;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public String getAsiento() {
        return asiento;
    }

    public void mostrarInfo() {

        System.out.println(
                "Ticket: " + ticket +
                " | Nombre: " + nombre +
                " | Destino: " + destino +
                " | Asiento: " + asiento
        );
    }
}
