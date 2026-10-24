package aed;

public class ColaSobreArregloCircular implements Cola {
    private int[] array;
    private int inicio;
    private int fin;

    public ColaSobreArregloCircular(int i) {
        this.array = new int[i + 1];
        this.inicio = 0;
        this.fin = 0;
    }

    // Inserta en el final (tail)
    public void enqueue(int elem) {
        if (isFull()) {
            throw new RuntimeException("Overflow"); // no se si hace falta :p
        }
        else {
            array[fin] = elem;
            fin = (fin + 1) % array.length;
        }
    }

    // Obtiene el elemento del frente (head)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow");
        } else {
            int desencolado = array[inicio];
            inicio = (inicio + 1) % array.length;
            return desencolado;
        }
    }

    // Obtiene el elemento del frente (head)
    public int front() {
        return array[inicio];
    }

    // Obtiene el elemento del final (tail)
    public int rear() {
        int posicion = (fin - 1 + array.length) % array.length;
        return array[posicion];
    }

    public boolean isEmpty() {
        return (inicio == fin);
    }

    public boolean isFull() {
        return ((fin + 1) % array.length == inicio);
    }
}
