package estructuras;

import java.util.Stack;

public class PilaHistorial {
    private Stack<String> historial = new Stack<>();

    public void guardarAccion(String accion) { historial.push(accion); }

    public String deshacerAccion() {
        return historial.isEmpty() ? "No hay acciones" : historial.pop();
    }

    public String verTop() {
        return historial.isEmpty() ? "Vacío" : historial.peek();
    }
}