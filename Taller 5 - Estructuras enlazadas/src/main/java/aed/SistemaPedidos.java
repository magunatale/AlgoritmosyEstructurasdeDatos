package aed;
import java.util.ArrayList;

public class SistemaPedidos {
    private ListaEnlazada<Pedido> pedidosOrdenLlegada;
    private ArrayList<Handle<Pedido>> pedidosId;


    public SistemaPedidos(){
        this.pedidosOrdenLlegada = new ListaEnlazada<>();
        this.pedidosId = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido){
        Handle<Pedido> h = this.pedidosOrdenLlegada.agregarAtras(pedido);
        agregarOrdenado(h);
    }

    private void agregarOrdenado(Handle<Pedido> p){
        int i = 0;
        while (i < this.pedidosId.size() && this.pedidosId.get(i).compareTo(p) > 0) {
            i++;
        }
        this.pedidosId.add(i, p);
    }

    public Pedido proximoPedidoPorId(){
        Handle<Pedido> h = this.pedidosId.get(this.pedidosId.size() - 1);
        this.pedidosId.remove(this.pedidosId.size() - 1);
        h.eliminar();
        return h.valor();
    }

    public Pedido proximoPedidoPorLlegada(){
        Pedido p = this.pedidosOrdenLlegada.obtenerPrimero();
        this.pedidosOrdenLlegada.eliminar(0);
        int i = busquedaBinariaIndice(this.pedidosId,p);
        this.pedidosId.remove(i);
        return p;
    }

    private int busquedaBinariaIndice(ArrayList<Handle<Pedido>> ls, Pedido pedido){
        int min = 0;
        int max = ls.size() -1;
        while (min <= max) {
            int mitad = (min + max) / 2;
            Pedido pedidoMedio = ls.get(mitad).valor();
            int comparacion = pedidoMedio.compareTo(pedido);
            if (comparacion == 0) {
                return mitad;
            }
            else if (comparacion < 0) {
                max = mitad -1;
            }
            else {
                min = mitad + 1;
            }
        }
        return -1;
    }

    public Pedido pedidoMenorId(){
        return this.pedidosId.get(this.pedidosId.size() - 1).valor();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        return this.pedidosOrdenLlegada.toString();
    }

    public String obtenerPedidosOrdenadosPorId(){
        String res = "[";
        for (int i = this.pedidosId.size() - 1; i >= 0; i--) {
            res += this.pedidosId.get(i).valor();
            if (i > 0) {
                res = res + ", ";
            }
        }
        res += "]";
        return res;
    }
}