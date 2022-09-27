package algebretta;

import java.util.Objects;

public class MatriceIdentita extends MatriceAbs {
    
    private int m;

    public MatriceIdentita(int m) {
        
        if (m == 0) throw new IllegalArgumentException("deve avere almeno un valore");
        this.m = m;

    }

    @Override
    public int dim() {
        
        return this.m;
        
    }

    @Override
    public int val(int r, int c) {

        if (r < 0 || r >=  m ) throw new IndexOutOfBoundsException("l indice r non e valido");
        if (c < 0 || c >=  m ) throw new IndexOutOfBoundsException("l indice c non e valido");
        if (c != r){
            return 0;
       }
       else {
            return 1;
       }
    }

    @Override
    public Matrice per(int alpha) {
        
        if (alpha == 0) return new MatriceNulla(this.dim());
        if(alpha == 1)  return new MatriceIdentita(this.dim());

        int [] temp = new int[this.dim()];
        for ( int i = 0 ; i < this.dim(); i++) temp[i] = alpha;
        return new MatriceDiagonale(temp);
    }

    @Override
    public Matrice per(Matrice m) {
        
        if (!conforme(m)) throw new IllegalArgumentException("matrice non conforme");
        Objects.requireNonNull(m,"matrice nulla");
        if(m instanceof MatriceIdentita) return this;
        if(m instanceof MatriceNulla) return new MatriceNulla(this.dim());

        return m;
    }

    @Override
    public Matrice più(Matrice m) {

        if (!conforme(m)) throw new IllegalArgumentException("matrice non conforme");
        Objects.requireNonNull(m,"matrice nulla");
        if (m instanceof MatriceNulla) return this;

        if (m instanceof MatriceDensa){
        int [][] temp = new int[this.dim()][this.dim()];
        for(int i = 0; i < this.dim(); i++){
            for(int j = 0; j < this.dim(); j++){
                    temp[i][j] = this.val(i,j) + m.val(i,j);
                }
            }
            return new MatriceDensa(temp);
        }
        
       
            int [] temp = new int[this.dim()];
            for(int i = 0 ; i < this.dim(); i++){
                    temp[i] = this.val(i,i) + m.val(i,i);
            }
            return new MatriceDiagonale(temp);
    }

    @Override
    public Boolean conforme(Matrice m) {

        Objects.requireNonNull(m,"matrice nulla");
        return this.dim() == m.dim();
    }

    
    
}
