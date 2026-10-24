package aed.tp2;

public class InfoUsuario {
    public double millasTotales;
    public double millasDisponibles;
    public Historial historial;

    public InfoUsuario() {
        this.millasTotales = 0.0;
        this.millasDisponibles = 0.0;
        this.historial = new Historial();
    }
}