
public class PiastrellaQuadrata extends Piastrella {

        public final int lato ;
        
        /**
         * costruisce una piastrella di costo costo e di superficie lato * lato
         * 
         * @param costo il costo della piastrella
         * @param lato  la dimensione di un lato
         * @throws illegal argument exception se  lato minore di zero
         */
        public PiastrellaQuadrata(int costo, int lato) {
            super(costo);
            if (lato<0) throw new IllegalArgumentException("il lato della piastrella quadrata essere maggiore di zero");
            this.lato = lato;
        }


        @Override
        public  int superficie(){
            return lato*lato;
        }


}