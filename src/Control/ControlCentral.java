package Control;

import estructuras.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ControlCentral {

    private ArbolPasajeros pasajeros;

    private MatrizRadar radar;

    private GrafoRutas rutas;

    private Queue<String> colaDespegue;

    private Historial historial;

    // =====================================================
    // LISTA DE AVIONES EN HANGAR
    // =====================================================

    private ArrayList<String> hangares;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public ControlCentral() {

        this.pasajeros = new ArbolPasajeros();

        this.radar = new MatrizRadar(5, 5);

        this.rutas = new GrafoRutas();

        this.colaDespegue = new LinkedList<>();

        this.historial = new Historial();

        this.hangares = new ArrayList<>();
    }

    // =====================================================
    // INICIAR SISTEMA
    // =====================================================

    public void iniciarSistema() {

        System.out.println(
                "Sistema aeroportuario iniciado");
    }

    // =====================================================
    // COLA FIFO
    // =====================================================

    public void encolarAvion(String avion) {

        colaDespegue.add(avion);
    }

    public String despacharAvion() {

        return colaDespegue.poll();
    }

    public Queue<String> getColaDespegue() {

        return colaDespegue;
    }

    // =====================================================
    // HANGARES
    // =====================================================

    public void registrarAvionHangar(String avion) {

        hangares.add(avion);
    }

    public ArrayList<String> getHangares() {

        return hangares;
    }

    public boolean avionExiste(String avion) {

        return hangares.contains(avion);
    }

    // =====================================================
    // GETTERS
    // =====================================================

    public ArbolPasajeros getPasajeros() {

        return pasajeros;
    }

    public MatrizRadar getRadar() {

        return radar;
    }

    public GrafoRutas getRutas() {

        return rutas;
    }

    public Historial getHistorial() {

        return historial;
    }

    // =====================================================
    // HISTORIAL
    // =====================================================

    public class Historial {

        private ArrayList<String> logs =
                new ArrayList<>();

        public void guardarAccion(String accion) {

            logs.add(accion);
        }

        public ArrayList<String> getListaLogs() {

            return logs;
        }
    }
}