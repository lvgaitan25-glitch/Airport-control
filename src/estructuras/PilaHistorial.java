package estructuras;

import java.util.Stack;

public class PilaHistorial {
    private Stack<String> acciones;

    public PilaHistorial() {
        this.acciones = new Stack<>();
    }

    public void guardarAccion(String accion) {
        acciones.push(accion);
    }

    // Método necesario para que el Panel pueda leer la lista
    public Stack<String> getAcciones() {
        return acciones;
    }
}