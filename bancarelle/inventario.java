import java.util.Objects;

public class inventario {
    
    

    /**
     * 
     * @param n  numero di giocattoli d aggiungere all inventario
     * @param giocattolo da aggiungere all inventario
     * @throws IllegalArgumentException se il numero di giocattoli e minore o uguale a zero
     * @throws NullPointerExceptionException se giocattolo e null
     */
    public void aggiungi (int n, Giocattolo giocattolo){

        Objects.requireNonNull(giocattolo,"giocattolo  non deve essre null");
        if(n <= 0 ) throw new IllegalArgumentException("numero di giocattoli non valido");

    }
}
