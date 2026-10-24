package aed;

public class Horario {

    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return this.hora + ":" + this.minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || otro.getClass() != this.getClass()) {
            return false;    
        }
        else {
            Horario horarioAComparar = (Horario) otro;
            return horarioAComparar.hora == this.hora && 
            horarioAComparar.minutos == this.minutos;
        }
    }
}
