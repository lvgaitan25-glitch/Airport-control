package estructuras;

import modelos.Pasajeros;

class Nodo {

    Pasajeros pasajero;

    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Pasajeros pasajero) {

        this.pasajero = pasajero;
    }
}

public class ArbolPasajeros {

    Nodo raiz;

    // INSERTAR
    public void insertar(Pasajeros pasajero) {

        raiz = insertarRecursivo(raiz, pasajero);
    }

    private Nodo insertarRecursivo(
            Nodo actual,
            Pasajeros pasajero) {

        if (actual == null) {

            return new Nodo(pasajero);
        }

        if (pasajero.getTicket()
                < actual.pasajero.getTicket()) {

            actual.izquierdo =
                    insertarRecursivo(
                            actual.izquierdo,
                            pasajero);

        } else if (pasajero.getTicket()
                > actual.pasajero.getTicket()) {

            actual.derecho =
                    insertarRecursivo(
                            actual.derecho,
                            pasajero);
        }

        return actual;
    }

    // BUSCAR
    public boolean buscar(int ticket) {

        boolean encontrado =
                buscarRecursivo(raiz, ticket);

        if (encontrado) {

            System.out.println(
                    "Pasajero encontrado");
        } else {

            System.out.println(
                    "Pasajero NO encontrado");
        }

        return encontrado;
    }

    private boolean buscarRecursivo(
            Nodo actual,
            int ticket) {

        if (actual == null) {

            return false;
        }

        if (ticket ==
                actual.pasajero.getTicket()) {

            return true;
        }

        if (ticket
                < actual.pasajero.getTicket()) {

            return buscarRecursivo(
                    actual.izquierdo,
                    ticket);

        } else {

            return buscarRecursivo(
                    actual.derecho,
                    ticket);
        }
    }

    // MOSTRAR INORDEN
    public void mostrarInOrden() {

        System.out.println(
                "\n=== PASAJEROS ===");

        mostrarInOrdenRecursivo(raiz);
    }

    private void mostrarInOrdenRecursivo(
            Nodo actual) {

        if (actual != null) {

            mostrarInOrdenRecursivo(
                    actual.izquierdo);

            actual.pasajero.mostrarInfo();

            mostrarInOrdenRecursivo(
                    actual.derecho);
        }
    }
}
