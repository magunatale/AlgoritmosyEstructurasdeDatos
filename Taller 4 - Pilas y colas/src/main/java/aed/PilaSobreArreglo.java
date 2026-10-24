package aed;

public class PilaSobreArreglo implements Pila {
    private int[] array;
    private int top;

    public PilaSobreArreglo(int capacity) {
        this.array = new int[capacity];
        this.top = -1;
    }

    public void push(int elem) {
        if (isFull()) {
            throw new RuntimeException("Overflow"); // no se si hace falta :p
        }
        else {
            top = top + 1;
            array[top] = elem;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        int desapilado = array[top];
        top = top - 1;
        return desapilado;
    }

    public int top() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == array.length - 1;
    }
}
