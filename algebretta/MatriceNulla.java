package algebretta;

import java.util.Objects;

public class MatriceNulla extends MatriceAbs{

    //dimensione matrice
    private final int m;

    public MatriceNulla(int m) {
        this.m = m;
    }

    @Override
    public int dim() {
        
        return 0;
    }

    @Override
    public int val(int r, int c) {
        
        if (r < 0 || r >=  m ) throw new IndexOutOfBoundsException("l indice r non e valido");
        if (c < 0 || c >=  m ) throw new IndexOutOfBoundsException("l indice c non e valido");
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        
        Matrice nuova = new MatriceNulla(this.dim());
        return nuova;
    }

    @Override
    public Matrice per(Matrice m) {


        Objects.requireNonNull(m,"matrice nulla");
        if (!conforme(m)) throw new  IllegalArgumentException("matrice non conforme");
        return  new MatriceNulla(this.dim());
    }

    @Override
    public Matrice più(Matrice m) {
       
        Objects.requireNonNull(m,"matrice nulla");
        if (!conforme(m)) throw new  IllegalArgumentException("matrice non conforme");
        return m;
    }

    @Override
    public Boolean conforme(Matrice m) {
        
        Objects.requireNonNull(m,"matrice nulla");
        return this.dim() == m.dim();
    }
    
}
