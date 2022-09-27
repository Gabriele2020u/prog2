package algebretta;

import java.util.Objects;

public class VettoreDenso implements Vettore {

    private final int[] vettore;
    
    @Override
    public int dim(){
        return vettore.length;
    }

    /**
     * costruttore del VettoreDenso
     * @param v, vettore col quale popolare il vettoreDenso
     * @throws  IllegalArgumentException se il vettore in input e vuoto
     */
    public VettoreDenso(int[] v) {
        
        Objects.requireNonNull(v,"vettore nullo");
        if (v.length == 0 ) throw new IllegalArgumentException("il vettore deve essere non vuoto");
        vettore = v.clone();
    }

    @Override
    public Boolean  conforme (final Vettore v){

        Objects.requireNonNull(v,"vettore nullo");
        return this.dim() == v.dim();
    }

    @Override
    public int val(int i) {
        
        if(i < 0 || i > vettore.length  ) throw new IndexOutOfBoundsException("indice non valido");
        return vettore[i];
    }

    @Override
    public Vettore per(int alpha) {
        
        int [] vetsup = new int[vettore.length];
        for(int i = 0 ; i < vettore.length ; i++){
            vetsup[i] =  vettore[i] * alpha;
        }

        return new VettoreDenso(vetsup);
    }

    @Override
    public Vettore più(Vettore v) {
       
        Objects.requireNonNull(v,"vettore nullo");
        if (!conforme(v)) throw new  IllegalArgumentException("vettore non conforme");
        int [] vetsomma = new int[vettore.length];
        for(int i = 0 ; i < vettore.length ; i++){
            vetsomma[i] =  this.val(i) + v.val(i);
        }
        return  new VettoreDenso(vetsomma);
    }

    @Override
    public String toString() {
        StringBuilder stringa = new StringBuilder() ;
        stringa.append("( ");
        stringa.append(this.val(0));
        for(int i = 1 ; i < this.dim() ; i++) stringa.append( " , " + this.val(i));
        stringa.append(" )");
        return  stringa.toString();
    }

    public static void main(String[] args) {
        int[] val1 = {10,5,10};
        int[] val2 = {5,10,2} ;
        Vettore v1 = new VettoreDenso(val1);
        Vettore v2 = new VettoreDenso(val2);
        System.out.println(v1.più(v2).toString()) ;
        System.out.println(v1.per(2)) ;
        System.out.println( v1.getClass());
        
    }

}