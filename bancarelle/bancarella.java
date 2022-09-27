import java.util.Objects;

public class bancarella {
    
    private String propietario;
    Inventario  inventario;
    Listino     listino;

    /**
     * costruttore di una bancarella
     * @param propietario non deve essere null
     * @param inventario
     * @param listino
     */
    public bancarella(String propietario, Inventario inventario, Listino listino) {
        Objects.requireNonNull(propietario,"propietario non valido";)
        Objects.requireNonNull(inventario,"inventario non valido";)
        Objects.requireNonNull(listino,"listino non valido";)
        this.propietario = propietario;
        this.inventario = inventario;
        this.listino = listino;
    }
        
    
        //funzione vendita
        //funcione mostra listino
}
