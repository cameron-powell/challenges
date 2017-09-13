import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CombinationLock {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while(!(input = reader.readLine()).equals("0 0 0 0")) {
            String[] splinput = input.split(" ");
            int start = new Integer(splinput[0]);
            int first = new Integer(splinput[1]);
            int second = new Integer(splinput[2]);
            int third = new Integer(splinput[3]);
            int numDegrees = 120;

            numDegrees += (start > first) ? (start-first) : (start + 40 - first);
            numDegrees += (second > first) ? (second-first) : (40 - first + second);
            numDegrees += (second > third) ? (second-third) : (second + 40 - third);

            System.out.println(numDegrees * 9);
        }
    }
}
