import java.util.Objects;
public class Giocattolo {
    
    private String nome;
    private String materiale;

    /**
     * costruisce un giocattolo
     * @param nome il nome del giocattolo, non deve essere null
     * @param materiale il materiale del giocattolo non puo essere null
     * @throws NullPointerException se materiale e null
     * @throws NullPointerException se nome e null
     */
    public Giocattolo(String nome, String materiale) {

        Objects.requireNonNull(nome,"nome non deve essere null");
        Objects.requireNonNull(nome,"materiale non deve essere null");
        this.nome = nome;
        this.materiale = materiale;
    }

    
    
}
