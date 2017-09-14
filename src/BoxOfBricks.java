import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BoxOfBricks {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int setNum = 1;
        while(!(input = in.readLine()).equals("0")) {
            String[] splinput = in.readLine().split(" ");
            int total = 0;
            for(String item: splinput) {
                total += Integer.parseInt(item);
            }

            int average = total/splinput.length;
            int moves = 0;
            for(String item: splinput) {
                moves += Math.abs(average - Integer.parseInt(item));
            }

            System.out.println("Set #" + setNum++);
            System.out.println("The minimum number of moves is " + moves/2 + ".");
            System.out.println();
        }
    }
}
