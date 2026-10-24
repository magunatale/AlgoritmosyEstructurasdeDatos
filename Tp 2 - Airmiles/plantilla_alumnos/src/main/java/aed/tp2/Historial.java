package aed.tp2;

public class Historial { 
    public ListaEnlazada<Vuelo> vuelos;
    public ListaEnlazada<Double> canjes;
    public ListaEnlazada<Transferencia> transferencias;

    public Historial() {
        this.vuelos = new ListaEnlazada<>();
        this.canjes = new ListaEnlazada<>();
        this.transferencias = new ListaEnlazada<>();
    }
}