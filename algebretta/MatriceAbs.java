package algebretta;

public abstract class MatriceAbs implements Matrice {
    

    
    @Override
    public String toString() {
        
        StringBuilder stringa = new StringBuilder();
        stringa.append("[");
        for (int i = 0; i < dim(); i++) {
            for (int j = 0; j < dim(); j++) stringa.append(val(i, j) + (j < dim() - 1 ? ", " : ""));
            if (i < dim() - 1) stringa.append("; ");
          }
        stringa.append("]");
        return  stringa.toString();
    }
}
