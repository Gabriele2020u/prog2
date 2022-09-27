package algebretta;

import java.util.Objects;

public class MatriceDiagonale extends MatriceAbs {

    //dimensione della matrice
    private final int m;
    private final int[] diagonale;
    

    public MatriceDiagonale( int[] diagonale) {

        Objects.requireNonNull(diagonale);
        this.m = diagonale.length;
        if (this.m == 0) throw new IllegalArgumentException("deve avere almeno un valore");
         this.diagonale = diagonale.clone();
    }

    @Override
    public int dim() {
        
        return m;
    }

    @Override
    public int val(int r, int c) {

        if (r < 0 || r >=  m ) throw new IndexOutOfBoundsException("l indice r non e valido");
        if (c < 0 || c >=  m ) throw new IndexOutOfBoundsException("l indice c non e valido");
        if (c != r){
             return 0;
        }
        else {
             return diagonale[c];
        }

    }

    @Override
    public Matrice per(int alpha) {
        
        if (alpha == 0) return new MatriceNulla(this.dim());
        int [] temp = new int[this.dim()];
        for ( int i = 0 ; i < this.dim(); i++) temp[i] = this.val(i, i) * alpha;
        return new MatriceDiagonale(temp);
    }

    @Override
    //AVREI POTUTO FARLA MEGLIO NON CONSIDERO LA STRUTTURA CARATTERISTICA
    public Matrice per(Matrice m) {
        
        if (!conforme(m)) throw new IllegalArgumentException("matrice non conforme");
        Objects.requireNonNull(m,"matrice nulla");
        if(m instanceof MatriceIdentita) return this;
        if(m instanceof MatriceNulla) return new MatriceNulla(this.dim());

        int [][] temp = new int[this.dim()][this.dim()];

        for(int i = 0; i < this.dim(); i++){
            for(int j = 0; j < this.dim(); j++){
                int somma = 0;
                for(int k = 0; k < this.dim(); k++){
                    somma += this.val(i,k) * m.val(k,j);
                }
                    temp[i][j] = somma;
            }
        }

        return new MatriceDensa(temp);
    }

    @Override
    public Matrice più(Matrice m) {
       
        if (!conforme(m)) throw new IllegalArgumentException("matrice non conforme");
        Objects.requireNonNull(m,"matrice nulla");
        if (m instanceof MatriceNulla) return this;

        if(m instanceof MatriceDiagonale) {
            int [] temp = new int[this.dim()];
            for(int i = 0 ; i < this.dim(); i++){
                    temp[i] = this.val(i,i) + m.val(i,i);
            }
            return new MatriceDiagonale(temp);
        }


        int [][] temp = new int[this.dim()][this.dim()];
        for(int i = 0; i < this.dim(); i++){
            for(int j = 0; j < this.dim(); j++){
                    temp[i][j] = this.val(i,j) + m.val(i,j);
            }
        }

        return new MatriceDensa(temp);
    }

    @Override
    public Boolean conforme(Matrice m) {
        
        Objects.requireNonNull(m,"matrice nulla");
        return this.dim() == m.dim();
    }
    

}
