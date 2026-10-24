package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String texto = this.fechaActual + "\n=====\n";
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            Recordatorio recordatorio = this.recordatorios.obtener(i);
            if (recordatorio.fecha().equals(this.fechaActual)) {
                texto += recordatorio + "\n";
            }
        }
        return texto;
    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(this.fechaActual);
    }

}
