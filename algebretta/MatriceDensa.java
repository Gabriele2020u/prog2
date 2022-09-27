package algebretta;

import java.util.Objects;

public class MatriceDensa  extends MatriceAbs{
    
    private int [][] mat ;


    public MatriceDensa(int[][] mat) {

        Objects.requireNonNull(mat, "matrice nulla");
        if(mat.length <= 0 ) throw new IllegalArgumentException("la matrice deve essere popolata");
        this.mat = mat.clone();
    }

    @Override
    public int dim() {

        return  mat[0].length;
    }

    @Override
    public int val(int r, int c) {
        
        if (r < 0 || r >=  this.dim() ) throw new IndexOutOfBoundsException("l indice r non e valido");
        if (c < 0 || c >=  this.dim() ) throw new IndexOutOfBoundsException("l indice c non e valido");
        return mat[r][c];
    }

    @Override
    public Matrice per(int alpha) {
        
        if  (alpha == 0) return new MatriceNulla(this.dim());
        int [][] temp = new int[this.dim()][this.dim()];
        for(int i = 0; i < this.dim(); i++){
            for(int j = 0; j < this.dim(); j++){
                    temp[i][j] = this.val(i,j) * alpha;
            }
        }
        return new MatriceDensa(temp);
    }

    @Override
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

    public static void main(String[] args) {
        int[][] val1 = {{ 1, 2 }, { 2,2}};
        int[][] val2 = {{4,3}, {6,3}} ;
        int []  val3 = {10,5};
        Matrice v1 = new MatriceDensa(val1);
        Matrice v2 = new MatriceDensa(val2);
        Matrice v3 = new MatriceIdentita(2);
        Matrice v4 = new MatriceDiagonale(val3);
        System.out.println(v1.più(v2).toString()) ;
        System.out.println(v1.per(v2).toString()) ;
        System.out.println(v1.per(v3).toString()) ;
        System.out.println(v4.per(v2).toString());
        
    }


}
