import java.util.LinkedList;
import java.util.Queue;

public class ColaDespegue {

    Queue<String> cola = new LinkedList<>();

    public void encolarAvion(String avion) {

        cola.add(avion);

        System.out.println("Avión agregado a cola: " + avion);
    }

    public void atenderDespegue() {

        String avion = cola.poll();

        System.out.println("Despegando avión: " + avion);
    }

    public void mostrarCola() {

        System.out.println("\n=== COLA DE DESPEGUE ===");

        System.out.println(cola);
    }
}