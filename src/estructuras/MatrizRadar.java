package estructuras;

public class MatrizRadar {

    private int[][] radar = new int[5][5];

    public void ocupar(int f, int c) {
        if (f < 5 && c < 5) radar[f][c] = 1;
    }

    public int[][] obtener() {
        return radar;
    }
}