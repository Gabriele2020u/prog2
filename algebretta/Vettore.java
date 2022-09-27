package algebretta;

public interface Vettore {
    
    /**
     * restituisce la dimensione del vettore, sempre positiva
     * @return la dimensione del vettore
     */
    int dim();
    /**
     * restituisce il valore nell iesima posizione del vettore
     * @param i  la posizione del valore
     * @return il valore nel iesima posizione
     * @throws indexoutofboundsexception se l indice e negativo o maggioe uguale alla dimensione del vettore
     */
    int val(final int i);

    
    /**
     * restituisce il prodotto fra il vettore e lo scalare
     * @param alpha scalare da moltiplicare
     * @return il prodotto fra il vettore e lo scalare
     */
    Vettore per(final int alpha);

    /**
     * restituisce la somma vettoriale fra il vettore e  v
     * @param v , vettore col quale eseguire la somma vettoriale
     * @return la somma fra il vettori e il vettore v
     * @throws  illegalargumentexception se il vettore v non e conforme (dimensione diversa dal nostro vettore)
     * @throws NullPointerException {@code null} 
     */
    Vettore più(final Vettore v);

     
    /**
     * restituisce true se il vettore dato ha la stessa dimensione di questo vettore, cioe e conforme
     * @param v vettore da confrontare
     * @return true se il vettore e conforme
     * @throws  NullPointerException se il vettore è null.
     */
    Boolean  conforme (final Vettore v);

}
