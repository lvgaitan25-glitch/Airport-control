public class ControlCentral {

    package sistema;

import estructuras.*;
import modelos.*;

    ArregloAviones arreglo = new ArregloAviones();
    ColaDespegue cola = new ColaDespegue();
    PilaHistorial historial = new PilaHistorial();
    GrafoRutas rutas = new GrafoRutas();
    MatrizRadar radar = new MatrizRadar();
    ArbolPasajeros pasajeros = new ArbolPasajeros();

    public void iniciarSistema() {

        System.out.println("=== CYBER AIRPORT CONTROL ===");

        // Registrar aviones
        Avion a1 = new Avion("AV001", "Boeing 737", "Hangar");
        Avion a2 = new Avion("AV002", "Airbus A320", "Pista");

        arreglo.agregarAvion(a1);
        arreglo.agregarAvion(a2);

        historial.guardarAccion("Registro de aviones");

        // Mostrar aviones
        arreglo.mostrarAviones();

        // Cola de despegue
        cola.encolarAvion("AV001");
        cola.encolarAvion("AV002");

        cola.mostrarCola();

        // Grafo de rutas
        rutas.conectar("Bogotá", "Miami");
        rutas.conectar("Bogotá", "Madrid");

        rutas.mostrarRutas();

        // Radar
        radar.ocuparPosicion(1, 2);
        radar.ocuparPosicion(3, 4);

        radar.mostrarRadar();

        // Árbol pasajeros
        Pasajeros p1 =
        new Pasajeros(
                100,
                "Sebastian",
                "Medellin",
                "A12");

Pasajeros p2 =
        new Pasajeros(
                50,
                "Valentina",
                "Bogota",
                "B05");

Pasajeros p3 =
        new Pasajeros(
                150,
                "Carlos",
                "Miami",
                "C18");

pasajeros.insertar(p1);
pasajeros.insertar(p2);
pasajeros.insertar(p3);

pasajeros.buscar(150);

pasajeros.mostrarInOrden();

        // Historial
        historial.mostrarHistorial();
    }
}
