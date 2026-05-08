public class ArregloAviones {

    Avion[] aviones = new Avion[10];

    int contador = 0;

    public void agregarAvion(Avion avion) {

        aviones[contador] = avion;
        contador++;

        System.out.println("Avión agregado correctamente");
    }

    public void mostrarAviones() {

        System.out.println("\n=== LISTA DE AVIONES ===");

        for (int i = 0; i < contador; i++) {

            aviones[i].mostrarInfo();
        }
    }
}