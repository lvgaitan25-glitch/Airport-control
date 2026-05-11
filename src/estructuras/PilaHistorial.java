package estructuras;
import java.util.Stack;

public class PilaHistorial {

    Stack<String> historial = new Stack<>();

    public void guardarAccion(String accion) {

        historial.push(accion);
    }

    public void deshacerAccion() {

        if (!historial.isEmpty()) {

            System.out.println("Deshaciendo: " + historial.pop());
        }
    }

    public void mostrarHistorial() {

        System.out.println("\n=== HISTORIAL ===");

        System.out.println(historial);
    }
}