package estructuras;

import java.util.ArrayList;
import modelos.Avion;

public class ArregloAviones {

    private ArrayList<Avion> lista = new ArrayList<>();

    public void agregar(Avion a) {
        lista.add(a);
    }

    public ArrayList<Avion> obtener() {
        return lista;
    }
}