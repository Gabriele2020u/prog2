package algebretta;

public interface Matrice {
    
    /**
     * restituisce la dimensione della matrice sempre positiva 
     * @return la dimensione della matrice
     */
    int dim();


    /**
     * restituisce il valore della matrice r esima riga e cesiama colonna
     * @param r  la riga
     *  @param c la colonna
     * @return il valore il valore della matrice r esima riga e cesiama colonna
     * @throws indexoutofboundsexception se r o c sono negativi o maggiore uguale alla dimensione del vettore
     */
    int val(final int r,final int c);

    
    /**
     * restituisce il prodotto fra il vettore e lo scalare
     * @param alpha scalare da moltiplicare
     * @return il prodotto fra la matrice e lo scalare
     */
   Matrice per(final int alpha);




      /**
     * restituisce il prodotto fra 2 matrici conformi
     * @param m matrice da moltiplicare
     * @return il prodotto fra la nostra matrice e la matrice m
     * @throws illegalargumentexception se la matrice m non e conforme (dimensione diversa dalla nostra matrice)
     * @throws NullPointerException {@code null}  se m e null
     */
    Matrice per(Matrice m);

    /**
     * restituisce la somma matriciale fra il vettore e  m
     * @param m  mnatrice col quale eseguire la somma matriciale
     * @return la somma fra il vettori e il vettore v
     * @throws  illegalargumentexception se la matrice m non e conforme (dimensione diversa dalla nostra matrice)
     * @throws NullPointerException {@code null}  se m e null
     */
    Matrice più(final Matrice m);

     
    /**
     * restituisce true se la matrice  data ha la stessa dimensione di questa matrice, cioe e conforme
     * @param m matrice da confrontare
     * @return true se la matrice e conforme
     * @throws  NullPointerException se il vettore è null.
     */
    Boolean  conforme (final Matrice m);

}
