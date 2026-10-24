package aed;

import java.util.NoSuchElementException;

public class ABB<T extends Comparable<T>> implements Conjunto<T> {

    private Nodo raiz;
    private int cantidad;

    private class Nodo {
        private T elemento;
        private Nodo izquierdo;
        private Nodo derecho;
        private Nodo padre;

        private Nodo(T elemento, Nodo padre) {
            this.elemento = elemento;
            this.padre = padre;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public ABB() {
        raiz = null;
        cantidad = 0;
    }

    @Override
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

    private Nodo maximoNodo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        while (nodo.derecho != null) {
            nodo = nodo.derecho;
        }
        return nodo;
    }

    @Override
    public T minimo() {
        if (raiz == null) {
            throw new NoSuchElementException("No se puede obtener el mínimo de un conjunto vacío");
        }
        return minimoNodo(raiz).elemento;
    }

    @Override
    public T maximo() {
        if (raiz == null) {
            throw new NoSuchElementException("No se puede obtener el máximo de un conjunto vacío");
        }
        return maximoNodo(raiz).elemento;
    }

    private Nodo buscarNodo(T elem) {
        Nodo actual = raiz;

        while (actual != null) {
            int comparacion = elem.compareTo(actual.elemento);
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

    @Override
    public boolean pertenece(T elem) {
        return buscarNodo(elem) != null;
    }

    @Override
    public void insertar(T elem) {
        if (raiz == null) {
            raiz = new Nodo(elem, null);
            cantidad++;
            return;
        }

        Nodo actual = raiz;
        Nodo padre = null;

        while (actual != null) {
            padre = actual;
            int comparacion = elem.compareTo(actual.elemento);

            if (comparacion == 0) {
                // El conjunto no admite elementos repetidos.
                return;
            } else if (comparacion < 0) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }

        Nodo nuevo = new Nodo(elem, padre);
        if (elem.compareTo(padre.elemento) < 0) {
            padre.izquierdo = nuevo;
        } else {
            padre.derecho = nuevo;
        }
        cantidad++;
    }

    // Reemplaza el subárbol cuya raíz es viejo por el subárbol cuya raíz es nuevo.
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

    @Override
    public void eliminar(T elem) {
        Nodo nodo = buscarNodo(elem);

        // Si no existe, el conjunto queda sin cambios.
        if (nodo == null) {
            return;
        }

        if (nodo.izquierdo == null) {
            // No tiene hijo izquierdo (puede tener hijo derecho o ninguno).
            reemplazar(nodo, nodo.derecho);
        } else if (nodo.derecho == null) {
            // Tiene hijo izquierdo y no tiene hijo derecho.
            reemplazar(nodo, nodo.izquierdo);
        } else {
            // Tiene dos hijos: se copia el sucesor in-order y se elimina su nodo.
            Nodo sucesor = minimoNodo(nodo.derecho);
            nodo.elemento = sucesor.elemento;
            // El sucesor no puede tener hijo izquierdo.
            reemplazar(sucesor, sucesor.derecho);
        }

        cantidad--;
    }

    private void agregarEnOrden(Nodo nodo, StringBuilder resultado, boolean[] primerElemento) {
        if (nodo == null) {
            return;
        }

        agregarEnOrden(nodo.izquierdo, resultado, primerElemento);
        if (!primerElemento[0]) {
            resultado.append(',');
        }
        resultado.append(nodo.elemento);
        primerElemento[0] = false;
        agregarEnOrden(nodo.derecho, resultado, primerElemento);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("{");
        agregarEnOrden(raiz, resultado, new boolean[] { true });
        resultado.append('}');
        return resultado.toString();
    }

    public class ABB_Iterador implements Iterador<T> {
        private Nodo actual;

        public ABB_Iterador() {
            actual = minimoNodo(raiz);
        }

        @Override
        public boolean haySiguiente() {
            return actual != null;
        }

        private Nodo sucesorDe(Nodo nodo) {
            if (nodo.derecho != null) {
                return minimoNodo(nodo.derecho);
            }

            Nodo padre = nodo.padre;
            while (padre != null && nodo == padre.derecho) {
                nodo = padre;
                padre = padre.padre;
            }
            return padre;
        }

        @Override
        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException("El iterador no tiene un siguiente elemento");
            }

            T elemento = actual.elemento;
            actual = sucesorDe(actual);
            return elemento;
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }
}
