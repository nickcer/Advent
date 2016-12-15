import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("input.txt");
        Scanner sc = new Scanner(inFile);

        String first = "";
        String second = "";
        String third = "";
        String fourth = "";
        String fifth = "";
        String sixth = "";
        String seventh = "";
        String eighth = "";

        String line = "";

        String message = "";

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            first += line.substring(0,1);
            second += line.substring(1, 2);
            third += line.substring(2,3);
            fourth += line.substring(3,4);
            fifth += line.substring(4,5);
            sixth += line.substring(5,6);
            seventh += line.substring(6,7);
            eighth += line.substring(7,8);

        }
        sc.close();

        //message += mostFrequent(first);
        //message += mostFrequent(second);
        //message += mostFrequent(third);
        //message += mostFrequent(fourth);
        //message += mostFrequent(fifth);
        //message += mostFrequent(sixth);
        //message += mostFrequent(seventh);
        //message += mostFrequent(eighth);

        message += leastFrequent(first);
        message += leastFrequent(second);
        message += leastFrequent(third);
        message += leastFrequent(fourth);
        message += leastFrequent(fifth);
        message += leastFrequent(sixth);
        message += leastFrequent(seventh);
        message += leastFrequent(eighth);

        System.out.println("The message is: "+ message);
        System.out.println("END PROG");
    }

    private static String leastFrequent(String signal) {
        int[] frequencies = new int[256];

        for (int i = 0; i < signal.length(); i++) {
            frequencies[signal.charAt(i)]++;
        }
        return getHighestIndex(frequencies);
    }



    private static String getHighestIndex(int[] frequencies) {
        int max = 50;
        int highestIndex = -1;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] < max && frequencies[i] != 0) {
                max = frequencies[i];
                highestIndex = i;
            }
        }
        return ((char)highestIndex) + "";
    }

}
