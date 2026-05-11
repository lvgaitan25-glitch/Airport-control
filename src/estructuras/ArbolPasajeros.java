package estructuras;
import modelos.Pasajero;

class Nodo {
    Pasajero dato; // Antes tenías 'int ticket', cámbialo por el objeto
    Nodo izquierdo, derecho;

    public Nodo(Pasajero p) {
        this.dato = p;
    }
}

public class ArbolPasajeros {
    private Nodo raiz;

    public void insertar(Pasajero p) {
        raiz = insertarRecursivo(raiz, p);
    }

    private Nodo insertarRecursivo(Nodo actual, Pasajero p) {
        if (actual == null) return new Nodo(p);
        
        // Comparamos los tickets para ordenar el árbol
        if (p.getTicket() < actual.dato.getTicket()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, p);
        } else if (p.getTicket() > actual.dato.getTicket()) {
            actual.derecho = insertarRecursivo(actual.derecho, p);
        }
        return actual;
    }
}
