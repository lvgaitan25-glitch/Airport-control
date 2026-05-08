class Nodo {

    int ticket;

    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int ticket) {

        this.ticket = ticket;
    }
}

public class ArbolPasajeros {

    Nodo raiz;

    public void insertar(int ticket) {

        raiz = insertarRecursivo(raiz, ticket);
    }

    private Nodo insertarRecursivo(Nodo actual, int ticket) {

        if (actual == null) {

            return new Nodo(ticket);
        }

        if (ticket < actual.ticket) {

            actual.izquierdo = insertarRecursivo(actual.izquierdo, ticket);

        } else if (ticket > actual.ticket) {

            actual.derecho = insertarRecursivo(actual.derecho, ticket);
        }

        return actual;
    }

    public boolean buscar(int ticket) {

        boolean encontrado = buscarRecursivo(raiz, ticket);

        if (encontrado) {

            System.out.println("Pasajero encontrado con ticket: " + ticket);

        } else {

            System.out.println("Pasajero NO encontrado");
        }

        return encontrado;
    }

    private boolean buscarRecursivo(Nodo actual, int ticket) {

        if (actual == null) {

            return false;
        }

        if (ticket == actual.ticket) {

            return true;
        }

        if (ticket < actual.ticket) {

            return buscarRecursivo(actual.izquierdo, ticket);

        } else {

            return buscarRecursivo(actual.derecho, ticket);
        }
    }
}