package Control;

import estructuras.*;
import modelos.*;

public class ControlCentral {
    private ArregloAviones aviones = new ArregloAviones();
    private ArbolPasajeros pasajeros = new ArbolPasajeros();
    private ColaDespegue cola = new ColaDespegue();
    private GrafoRutas rutas = new GrafoRutas();
    private MatrizRadar radar = new MatrizRadar();
    private PilaHistorial historial = new PilaHistorial();

    public ControlCentral() {
        inicializar();
    }

    private void inicializar() {
        // CORRECCIÓN: Usa paréntesis (), NO corchetes [] para los parámetros
        aviones.agregar(new Avion("AV001", "Boeing 737", "Hangar"));
        aviones.agregar(new Avion("AV002", "A320", "Pista"));
        
        cola.encolar("AV001");
        
        rutas.conectar("Bogotá", "Miami");
        
        // El error probablemente estaba aquí:
        radar.ocupar(1, 2); 
        radar.ocupar(3, 4);
        
        pasajeros.insertar(new Pasajero(100, "Juan Carlos", "Madrid"));
        
        historial.guardarAccion("Sistema Inicializado");
    }

    // Getters... (asegúrate de tenerlos)
    public ArregloAviones getAviones() { return aviones; }
    public ArbolPasajeros getPasajeros() { return pasajeros; }
    public ColaDespegue getCola() { return cola; }
    public GrafoRutas getRutas() { return rutas; }
    public MatrizRadar getRadar() { return radar; }
    public PilaHistorial getHistorial() { return historial; }
}