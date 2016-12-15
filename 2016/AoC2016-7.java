import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("input.txt");
        Scanner sc = new Scanner(inFile);
        int count = 0;
        String line = "";

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] linePieces = line.split("[\\[\\]]");

            ArrayList<String> ABAs = findABAs(linePieces);

            for (int i = 0; i < ABAs.size(); i++){
                String aba = ABAs.get(i);
                String bab = babify(aba);
                System.out.println("ABA was: " + aba);
                System.out.println("BAB was: " + bab);


                if(hasBAB(linePieces, bab)){
                    count++;
                    break;

                }
            }


        }
        sc.close();

        System.out.println("The number of valid IPs is: "+ count);
        System.out.println("END PROG");
    }

    private static boolean hasBAB(String[] linePieces, String bab) {
        for (int i = 1; i < linePieces.length; i += 2) {
            if(linePieces[i].contains(bab)){
                return true;
            }
        }
        return false;
    }

    private static String babify(String aba) {
        return aba.substring(1,2) + aba.substring(0,1) + aba.substring(1,2);
    }

    private static ArrayList<String> findABAs(String[] supernetSequences) {

        ArrayList<String> abas = new ArrayList<String>();

        for(int i = 0; i < supernetSequences.length; i +=2){
            for(int index = 0; index < supernetSequences[i].length() - 2; index++){
                String triplet = supernetSequences[i].substring(index, index + 3);

                if(isABA(triplet)){
                    System.out.println(triplet);
                    abas.add(new String(triplet));
                }
            }

        }
        return abas;
    }

    private static boolean isABA(String substring) {
        return substring.charAt(0) == substring.charAt(2) && substring.charAt(0) != substring.charAt(1);
    }

}
