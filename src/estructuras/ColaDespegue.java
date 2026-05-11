package estructuras;

import java.util.*;

public class ColaDespegue {

    private Queue<String> cola = new LinkedList<>();

    public void encolar(String avion) {
        cola.add(avion);
    }

    public String despegar() {
        return cola.isEmpty() ? "Vacío" : cola.poll();
    }

    public Queue<String> obtener() {
        return cola;
    }
}