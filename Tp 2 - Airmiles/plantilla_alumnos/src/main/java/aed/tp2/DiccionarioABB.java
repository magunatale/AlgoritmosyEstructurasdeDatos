package aed.tp2;

public class DiccionarioABB<K extends Comparable<K>, V> {

    private Nodo raiz;
    private int cantidad;

    private class Nodo {
        private K clave;
        private V valor;
        private Nodo izquierdo;
        private Nodo derecho;
        private Nodo padre;

        private Nodo(K clave, V valor, Nodo padre) {
            this.clave = clave;
            this.valor = valor;
            this.padre = padre;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public DiccionarioABB() {
        raiz = null;
        cantidad = 0;
    }

    public int cardinal() {
        return cantidad;
    }

    private Nodo minimoNodo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    private Nodo buscarNodo(K claveBuscada) {
        Nodo actual = raiz;

        while (actual != null) {
            int comparacion = claveBuscada.compareTo(actual.clave);
            if (comparacion == 0) {
                return actual;
            } else if (comparacion < 0) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return null;
    }

    public boolean pertenece(K clave) {
        return buscarNodo(clave) != null;
    }

    public V obtener(K clave) {
        Nodo nodo = buscarNodo(clave);
        if (nodo == null) {
            return null;
        }
        return nodo.valor;
    }

    // Cambio 6: Insertar ahora recibe clave y valor
    public void insertar(K clave, V valor) {
        if (raiz == null) {
            raiz = new Nodo(clave, valor, null);
            cantidad++;
            return;
        }

        Nodo actual = raiz;
        Nodo padre = null;

        while (actual != null) {
            padre = actual;
            int comparacion = clave.compareTo(actual.clave);

            if (comparacion == 0) {
                actual.valor = valor;
                return;
            } else if (comparacion < 0) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }

        Nodo nuevo = new Nodo(clave, valor, padre);
        if (clave.compareTo(padre.clave) < 0) {
            padre.izquierdo = nuevo;
        } else {
            padre.derecho = nuevo;
        }
        cantidad++;
    }

    private void reemplazar(Nodo viejo, Nodo nuevo) {
        if (viejo.padre == null) {
            raiz = nuevo;
        } else if (viejo == viejo.padre.izquierdo) {
            viejo.padre.izquierdo = nuevo;
        } else {
            viejo.padre.derecho = nuevo;
        }

        if (nuevo != null) {
            nuevo.padre = viejo.padre;
        }
    }

    public void eliminar(K clave) {
        Nodo nodo = buscarNodo(clave);

        if (nodo == null) {
            return;
        }

        if (nodo.izquierdo == null) {
            reemplazar(nodo, nodo.derecho);
        } else if (nodo.derecho == null) {
            reemplazar(nodo, nodo.izquierdo);
        } else {
            Nodo sucesor = minimoNodo(nodo.derecho);
            nodo.clave = sucesor.clave;
            nodo.valor = sucesor.valor;
            reemplazar(sucesor, sucesor.derecho);
        }
        cantidad--;
    }
}
