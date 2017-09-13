import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tests = new Integer(in.readLine());
        for(int t=0; t<tests; t++) {
            String useless = in.readLine();
            String[] splinput = in.readLine().split(" ");
            int least = new Integer(splinput[0]);
            int max = new Integer(splinput[0]);
            for(int i=1; i<splinput.length; i++) {
                int current = new Integer(splinput[i]);
                least = (current < least) ? current : least;
                max = (current > max) ? current : max;
            }
            System.out.println(2*(max-least));
        }

    }
}
