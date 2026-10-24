package aed.tp2;

public class Trie<T> {
    
    private class Nodo {
        public T valor;
        public Nodo[] hijos;

        public Nodo() {
        this.valor = null;
        this.hijos = (Nodo[]) new Trie.Nodo[256]; 
    }
    }

    private Nodo raiz;

    public Trie() {
        raiz = new Nodo();
    }

    public void insertar(String clave, T valor) {
        Nodo actual = raiz;
        for (int i = 0; i < clave.length(); i++) {
            int indice = clave.charAt(i); 
            
            if (actual.hijos[indice] == null) {
                actual.hijos[indice] = new Nodo();
            }
            actual = actual.hijos[indice];
        }
        actual.valor = valor; 
    }

    public T obtener(String clave) {
        Nodo actual = raiz;
        for (int i = 0; i < clave.length(); i++) {
            int indice = clave.charAt(i);
            
            if (actual.hijos[indice] == null) {
                return null; 
            }
            actual = actual.hijos[indice];
        }
        return actual.valor;
    }


    public void eliminar(String clave) {
        Nodo actual = raiz;
        for (int i = 0; i < clave.length(); i++) {
            int indice = clave.charAt(i);
            
            if (actual.hijos[indice] == null) {
                return;
            }
            actual = actual.hijos[indice];
        }
        actual.valor = null; 
    }
}
