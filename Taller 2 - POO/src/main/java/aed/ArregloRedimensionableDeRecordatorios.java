package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevosRecordatorios = new Recordatorio[this.recordatorios.length + 1];
        for (int j = 0; j < this.recordatorios.length; j++) {
            nuevosRecordatorios[j] = this.recordatorios[j];
        }
        nuevosRecordatorios[nuevosRecordatorios.length -1] = i;
        this.recordatorios = nuevosRecordatorios;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevosRecordatorios = new Recordatorio[this.recordatorios.length -1];
        for (int j = 0; j < nuevosRecordatorios.length; j++) {
            nuevosRecordatorios[j] = this.recordatorios[j];
        }
        this.recordatorios = nuevosRecordatorios;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = new Recordatorio[vector.longitud()];
        // Se usa una única vez el new!!
        for (int i = 0; i < this.recordatorios.length; i++) {
            this.recordatorios[i] = vector.obtener(i);
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }
}
