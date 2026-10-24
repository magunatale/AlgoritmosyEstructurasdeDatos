package aed.tp2;

public class AirMiles implements SistemaAirMiles {
    // obs usuarios: dicc (Usuario, InfoUsuario)
    private DiccionarioABB<Integer, InfoUsuario> usuarios; 
    // obs promosSinTope: dicc (NombrePromo, Factor)
    private Trie<Double> promosSinTope; 
    // obs promosConTope: dicc (NombrePromo, InfoPromoTope)
    private Trie<InfoPromoTope> promosConTope; 


    public AirMiles() {
        this.usuarios = new DiccionarioABB<>();
        this.promosSinTope = new Trie<>();
        this.promosConTope = new Trie<>();
        this.promosSinTope.insertar("NoPromo", 1.0);
    }

    public void registrarUsuario(int id) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void registrarUsuarioConReferidor(int id, int ref) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void acumularMillas(int id, double distancia, String nombrePromo) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void canjearMillas(int id, double cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void transferirMillas(int origen, int destino, double cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public double consultarSaldo(int u) {
            InfoUsuario info = usuarios.obtener(u);
            return info.millasDisponibles;
        }

    public String consultarCategoria(int id) {
        InfoUsuario info = usuarios.obtener(id);
        double totales = info.millasTotales;
        
        if (totales < 10000.0) {
            return "Bronce";
        } else if (totales < 50000.0) {
            return "Plata";
        } else if (totales < 1000000.0) {
            return "Oro";
        } else {
            return "Platino";
        }
    }

    public int[] rankingMillas(int n) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void iniciarPromocion(String nombre, double factor) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void iniciarPromocionConTope(String nombre, double factor, double tope) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void finalizarPromocion(String nombre) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public int elMasAcumulador() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public int elMasCanjeador() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public int[][] paresTransferidoresExclusivos() {
        throw new UnsupportedOperationException("Sin implementar");
    }
}
