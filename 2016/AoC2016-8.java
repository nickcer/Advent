import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("input.txt");
        Scanner sc = new Scanner(inFile);
        int count = 0;
        String line = "";

        int[][] display = new int[6][50];

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] linePieces = line.split(" ");

            if(linePieces.length == 2){ //This must be a RECT command
                String[] dimensions = linePieces[1].split("x");
                int Awidth = Integer.parseInt(dimensions[0]);
                int Btall = Integer.parseInt(dimensions[1]);

                turnOn(display, Awidth, Btall);

            }
            else{

                String indexInstruction = linePieces[2];
                int delta = Integer.parseInt(linePieces[4]);
                int index = Integer.parseInt(indexInstruction.split("=")[1]);

                if(linePieces[1].equals("column")){//we will rotate a column
                    shiftColumn(display, index, delta);

                }
                else if (linePieces[1].equals("row")) {//we will rotate a row
                    shiftRow(display, index, delta);
                }
            }
        }
        sc.close();
        count = countLights(display);
        printBoard(display);
        System.out.println("The number of pixels is: "+ count);
        System.out.println("END PROG");
    }

    private static void shiftColumn(int[][] display, int index, int delta) {
        for (int deltaCounter = 0; deltaCounter < delta; deltaCounter++) {
            int[] copy = {display[0][index],
                    display[1][index],
                    display[2][index],
                    display[3][index],
                    display[4][index],
                    display[5][index]
            };
            for (int i = 0; i < 6 - 1; i++) {
                display[i + 1][index] = copy[i];
            }
            display[0][index] = copy[copy.length - 1];


        }
    }

    private static void shiftRow(int[][] display, int index, int delta) {
        for(int deltaCounter = 0; deltaCounter < delta; deltaCounter++){
            int[] copy = display[index].clone();
            for(int i = 0; i < 50 - 1; i++){
                display[index][i + 1] = copy[i];
            }
            display[index][0] = copy[copy.length - 1];
        }
    }

    private static int countLights(int[][] display) {
        int count = 0;
        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[i].length; j++) {
                if(display[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private static void printBoard(int[][] display) {
        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[i].length; j++) {
                if(display[i][j] == 1)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println("");
        }
    }

    private static void turnOn(int[][] display, int awidth, int btall) {
        for(int i = 0; i < btall; i++){
            for(int j = 0; j < awidth; j++){
                display[i][j] = 1;
            }
        }
    }

}
