package estructuras;

public class MatrizRadar {

    int[][] radar = new int[5][5];

    public void ocuparPosicion(int fila, int columna) {

        radar[fila][columna] = 1;
    }

    public void mostrarRadar() {

        System.out.println("\n=== RADAR DE PISTA ===");

        for (int i = 0; i < radar.length; i++) {

            for (int j = 0; j < radar[i].length; j++) {

                System.out.print(radar[i][j] + " ");
            }

            System.out.println();
        }
    }
}