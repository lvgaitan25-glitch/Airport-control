package estructuras;

import java.util.*;

public class GrafoRutas {
    private Map<String, List<String>> adyacencia = new HashMap<>();

    public void agregarConexion(String origen, String destino) {
        adyacencia.putIfAbsent(origen, new ArrayList<>());
        adyacencia.putIfAbsent(destino, new ArrayList<>());
        
        if (!adyacencia.get(origen).contains(destino)) {
            adyacencia.get(origen).add(destino);
            adyacencia.get(destino).add(origen); // Grafo no dirigido (conexión doble)
        }
    }

    // NUEVO MÉTODO PARA BORRAR
    public void eliminarConexion(String origen, String destino) {
        if (adyacencia.containsKey(origen)) adyacencia.get(origen).remove(destino);
        if (adyacencia.containsKey(destino)) adyacencia.get(destino).remove(origen);
    }

    @Override
    public String toString() {
        if (adyacencia.isEmpty()) return " [ SISTEMA SIN RUTAS ACTIVAS ]";
        StringBuilder sb = new StringBuilder("MAPA DE CONEXIONES (GRAFO DE RED):\n");
        sb.append("========================================\n");
        for (String nodo : adyacencia.keySet()) {
            sb.append(" [").append(nodo).append("] <---> ").append(adyacencia.get(nodo)).append("\n");
        }
        return sb.toString();
    }
}