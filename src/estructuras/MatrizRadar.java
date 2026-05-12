package estructuras;

public class MatrizRadar {
    private int[][] matriz;
    private int filas;
    private int columnas;

    public MatrizRadar(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = 0; // 0 = Libre
            }
        }
    }

    public boolean estaOcupado(int f, int c) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            return matriz[f][c] == 1;
        }
        return true; 
    }

    public void ocuparHangar(int f, int c) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            matriz[f][c] = 1; // 1 = Ocupado
        }
    }

    public void liberarHangar(int f, int c) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            matriz[f][c] = 0;
        }
    }

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}