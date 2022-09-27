package algebretta;

import java.util.Scanner;

public class input {
    
    public static Matrice iniz_Matrice (char s,int [][] dati){


        switch (s) {
            case ' ':

                return new MatriceDensa(dati);
            case 'Z':
                return new MatriceNulla(dati[0].length);
            case 'I':
                return new MatriceIdentita(dati[0].length);
            case 'D':
                return new MatriceDiagonale(dati[0]);

            default:

                throw new IllegalArgumentException("stringa non valida");
        }
    }





    public static void main(String[] args) {
     
        try (Scanner s = new Scanner(System.in)) {
            while( s.hasNextLine() ){
                
                String[] riga = Parser.partiOperazione(s.nextLine());
                String left = riga[0];
                String right = riga[2];
                switch (riga[1]) {

                    // gestisco la somma
                    case "+":

                        if (Parser.èMatrice(left) && Parser.èMatrice(right)){

                            //Parser.tipoMatrice(operando);
                            int[][] val1 = Parser.valoriMatrice(left);
                            int[][] val2 = Parser.valoriMatrice(right);
                            Matrice m1 = iniz_Matrice(Parser.tipoMatrice(left),val1);
                            Matrice m2 = iniz_Matrice(Parser.tipoMatrice(right),val2);
                            System.out.println(m1.più(m2).toString());
                        }
                        else if(Parser.èVettore(left) && Parser.èVettore(right)){
                            Vettore v1 =   new VettoreDenso  (Parser.valoriVettore(left));
                            Vettore v2 =   new VettoreDenso  (Parser.valoriVettore(right));
                            System.out.println(v1.più(v2).toString());;

                        }

                        
                        break;
                    //gestisco prodotto
                    case "*":
                        
                    break;



                    default:
                       throw new IllegalArgumentException("valore non valido");
                }
               
            }

      
        }

    }
}
