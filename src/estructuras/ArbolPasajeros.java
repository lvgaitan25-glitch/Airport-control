package estructuras;

import modelos.Pasajero;
import java.util.ArrayList;
import java.util.List;

/**
 * Estructura de Árbol Binario de Búsqueda para gestionar pasajeros.
 * Los pasajeros se ordenan automáticamente por su ID de ticket.
 */
public class ArbolPasajeros {
    private NodoPasajero raiz;

    public ArbolPasajeros() {
        this.raiz = null;
    }

    // --- MODO: INSERTAR ---
    public void insertar(Pasajero nuevo) {
        raiz = insertarRec(raiz, nuevo);
    }

    private NodoPasajero insertarRec(NodoPasajero actual, Pasajero nuevo) {
        if (actual == null) {
            return new NodoPasajero(nuevo);
        }

        if (nuevo.getId() < actual.getPasajero().getId()) {
            actual.setIzquierdo(insertarRec(actual.getIzquierdo(), nuevo));
        } else if (nuevo.getId() > actual.getPasajero().getId()) {
            actual.setDerecho(insertarRec(actual.getDerecho(), nuevo));
        }
        // Si el ID es igual, no se inserta (evita duplicados)
        return actual;
    }

    // --- MODO: ELIMINAR ---
    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    private NodoPasajero eliminarRec(NodoPasajero actual, int id) {
        if (actual == null) return null;

        if (id < actual.getPasajero().getId()) {
            actual.setIzquierdo(eliminarRec(actual.getIzquierdo(), id));
        } else if (id > actual.getPasajero().getId()) {
            actual.setDerecho(eliminarRec(actual.getDerecho(), id));
        } else {
            // Nodo encontrado: Caso 1 y 2 (Sin hijos o un solo hijo)
            if (actual.getIzquierdo() == null) return actual.getDerecho();
            if (actual.getDerecho() == null) return actual.getIzquierdo();

            // Caso 3 (Dos hijos): Obtener el sucesor más pequeño del subárbol derecho
            actual.setPasajero(encontrarMinimo(actual.getDerecho()));
            // Eliminar el sucesor
            actual.setDerecho(eliminarRec(actual.getDerecho(), actual.getPasajero().getId()));
        }
        return actual;
    }

    private Pasajero encontrarMinimo(NodoPasajero nodo) {
        Pasajero min = nodo.getPasajero();
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
            min = nodo.getPasajero();
        }
        return min;
    }

    // --- MODO: LISTAR (RECORRIDO IN-ORDER) ---
    /**
     * Retorna una lista de pasajeros ordenada por ID (de menor a mayor).
     */
    public List<Pasajero> getListaOrdenada() {
        List<Pasajero> lista = new ArrayList<>();
        recorrerInOrder(raiz, lista);
        return lista;
    }

    private void recorrerInOrder(NodoPasajero nodo, List<Pasajero> lista) {
        if (nodo != null) {
            recorrerInOrder(nodo.getIzquierdo(), lista);
            lista.add(nodo.getPasajero());
            recorrerInOrder(nodo.getDerecho(), lista);
        }
    }

    // --- MODO: BUSCAR ---
    public Pasajero buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Pasajero buscarRec(NodoPasajero actual, int id) {
        if (actual == null) return null;
        if (id == actual.getPasajero().getId()) return actual.getPasajero();
        
        return id < actual.getPasajero().getId() 
            ? buscarRec(actual.getIzquierdo(), id) 
            : buscarRec(actual.getDerecho(), id);
    }
}