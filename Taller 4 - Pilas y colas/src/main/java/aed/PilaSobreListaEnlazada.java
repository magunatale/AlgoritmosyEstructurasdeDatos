package aed;

public class PilaSobreListaEnlazada implements Pila {
    private Node top;

    public PilaSobreListaEnlazada() {
        this.top = null;
    }

    public void push(int elem) {
        Node nuevo = new Node(elem);
        nuevo.next = top;
        top = nuevo;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: la pila está vacía");
        }
        int desapilado = top.data;
        top = top.next;
        return desapilado;
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: la pila está vacía");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false;
    }
}
