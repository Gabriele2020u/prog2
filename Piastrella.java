public abstract class Piastrella implements Rivestimento {


    private final int costo;

    /**
     * costruisce una piastrella dato il costo
     * @param il costo della piastrella =
     * @throws IllegalArgumentException se il costo non e positivo
     */
    public Piastrella(int costo) {
    
        if (costo < 0 ) throw new IllegalArgumentException("il costo della piastrella deve essere positivo");
        this.costo = costo;

    }


    @Override 
    public int costo(){
        return costo;
    }


}