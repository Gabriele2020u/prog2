import java.util.Scanner;
import java.util.List;

public class soluzione {

public static void main(String[] args) {

       /*  try (final Scanner s = new Scanner (System.in)){

                while(s.hasNextLine()){
                final Scanner line = new Scanner(s.nextLine());
                switch (line.next().charAt(0)){
                        case 'p' :
                        System.out.println("ciao p");
                        break;
                        case 'l':
                        System.out.println("ciao l");
                        break;
                        default:
                        throw new IllegalArgumentException("carattere non valido");
                }
                
                }*/

                PiastrellaQuadrata piastra = new PiastrellaQuadrata(20,10);
                System.out.println(piastra.superficie());
        }

 }


