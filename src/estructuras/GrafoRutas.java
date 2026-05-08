import java.util.*;

public class GrafoRutas {

    Map<String, List<String>> rutas = new HashMap<>();

    public void conectar(String origen, String destino) {

        rutas.putIfAbsent(origen, new ArrayList<>());
        rutas.putIfAbsent(destino, new ArrayList<>());

        rutas.get(origen).add(destino);
        rutas.get(destino).add(origen);
    }

    public void mostrarRutas() {

        System.out.println("\n=== RUTAS DE VUELO ===");

        for (String ciudad : rutas.keySet()) {

            System.out.println(ciudad + " -> " + rutas.get(ciudad));
        }
    }
}