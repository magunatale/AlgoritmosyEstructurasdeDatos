package aed.tp2;

public class ListaEnlazada<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;
    private class Nodo {
        private T valor;
        private Nodo anterior;
        private Nodo siguiente;

        public Nodo(T valor) {
            this.valor = valor;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    public int longitud() {
        return tamaño;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null && ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        tamaño++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null && ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamaño++;
    }

    public T obtener(int i) {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            if (contador != i) { 
                contador++;
                actual = actual.siguiente;
            } else {
                return actual.valor;
            }
        }
        return null;
    }

    public void eliminar(int i) {
        int contador = 0;
        Nodo actual = primero;

        while (actual != null) {
            if (contador != i) {
                contador++;
                actual = actual.siguiente;
            } else {
                if (actual.siguiente == null && actual.anterior == null) {
                    // Único elemento
                    primero = null;
                    ultimo = null;
                } else if (actual.anterior == null) {
                    // Primero
                    primero = primero.siguiente;
                    primero.anterior = null;
                } else if (actual.siguiente == null) {
                    // Último
                    ultimo = ultimo.anterior;
                    ultimo.siguiente = null;
                } else {
                    // Medio
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                tamaño--;
                break;
            }
        }
    }

    public void modificarPosicion(int indice, T elem) {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            if (contador != indice) { 
                contador++;
                actual = actual.siguiente;
            } else {
                actual.valor = elem;
                break;
            }
        }
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        primero = null;
        ultimo = null;
        tamaño = 0;
        Nodo actual = lista.primero;

        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }
        
    @Override
    public String toString() {
        String texto = "";
        Nodo actual = primero;

        while (actual != null) {
            if (actual == primero && actual.siguiente == null) {
                texto = texto + "[" + actual.valor + "]";
            } else if (actual.siguiente == null) {
                texto = texto + actual.valor + "]";
            } else if (actual == primero) {
                texto = texto + "[" + actual.valor + ", ";
            } else {
                texto = texto + actual.valor + ", ";
            }
            actual = actual.siguiente;
        }
        return texto;
    }

    public class ListaIterador {
        private Nodo actual;

        public ListaIterador() {
            actual = primero;
        }

        public boolean haySiguiente() {
            return actual != null;
        }

        public boolean hayAnterior() {
            if (actual == null) {
                return ultimo != null;
            } else {
                return actual.anterior != null;
            }
        }

        public T siguiente() {
            T resultado = actual.valor;
            actual = actual.siguiente;
            return resultado;
        }

        public T anterior() {
            if (actual == null) {
                actual = ultimo;
            } else {
                actual = actual.anterior;
            }
            return actual.valor;
        }
    }

    public ListaIterador iterador() {
        return new ListaIterador();
    }
}