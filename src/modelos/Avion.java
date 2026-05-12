package modelos;

public class Avion {
    private String matricula;
    private String modelo;
    private String hangar;

    public Avion(String matricula, String modelo, String hangar) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.hangar = hangar;
    }

    // Getters para la tabla
    public String getMatricula() { return matricula; }
    public String getModelo() { return modelo; }
    public String getHangar() { return hangar; }
}