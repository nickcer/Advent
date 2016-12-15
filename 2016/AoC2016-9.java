import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("input.txt");
        Scanner sc = new Scanner(inFile);
        String line = "";

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            long decompressedForm = decompress2(line);
            System.out.println("The length is: " + decompressedForm);
        }
        sc.close();
        System.out.println("END PROG");
    }

    private static String decompress(String line) {
        if(line.length() == 0){
            return "";
        }
        String[] linePieces = line.split("\\)", 2);
        String[] compressorInstruction = linePieces[0].split("[\\(x]");
        int charactersToRepeatFinalPosition = Integer.parseInt(compressorInstruction[1]);
        int numRepetition = Integer.parseInt(compressorInstruction[2]);
        String result = "";
        for (int i = 0; i < numRepetition; i++) {
            String chunk = linePieces[1].substring(0, charactersToRepeatFinalPosition);
            result += chunk;
        }
        String ignoredCharacters = compressorInstruction[0];
        String tail = linePieces[1].substring(charactersToRepeatFinalPosition);
        return result + ignoredCharacters + decompress(tail);
    }

    private static long decompress2(String line) {
        if (line.length() == 0) {
            return 0;
        }
        String[] linePieces = line.split("\\)", 2);
        if(linePieces.length == 1){
            return linePieces[0].length();
        }
        String[] compressorInstruction = linePieces[0].split("[\\(x]");
        int charactersToRepeatFinalPosition = Integer.parseInt(compressorInstruction[1]);
        int numRepetition = Integer.parseInt(compressorInstruction[2]);
        String result = "";
        for (int i = 0; i < numRepetition; i++) {
            String chunk = linePieces[1].substring(0, charactersToRepeatFinalPosition);
            result += chunk;
        }
        String ignoredCharacters = compressorInstruction[0];
        String tail = linePieces[1].substring(charactersToRepeatFinalPosition);
        return decompress2(result) + ignoredCharacters.length() + decompress2(tail);
    }
}
