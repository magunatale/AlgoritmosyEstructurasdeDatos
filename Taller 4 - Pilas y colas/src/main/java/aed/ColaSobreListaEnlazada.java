package aed;

public class ColaSobreListaEnlazada implements Cola {
    private Node head;
    private Node tail;

    public ColaSobreListaEnlazada() {
        head = null;
        tail = null;
    }

    public void enqueue(int elem) {
        Node nuevo = new Node(elem);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            this.tail.next = nuevo;
            this.tail = nuevo;
        }
    }
    
    public int dequeue() {
        Node desencolado = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return (desencolado.data);
    }

    public int front() {
        return head.data;
    }

    public int rear() {
        return tail.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }
}
