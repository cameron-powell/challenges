import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PackingForHoliday {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numTests = new Integer(in.readLine());
        for(int t=0; t<numTests; t++) {
            String[] splinput = in.readLine().split(" ");
            int[] dimensions = new int[3];
            for(int i=0; i<3; i++) {
                dimensions[i] = new Integer(splinput[i]);
            }

            System.out.println( (dimensions[0] <= 20 && dimensions[1] <= 20 && dimensions[2] <= 20) ?
                    "Case " + (t+1) + ": good" : "Case " + (t+1) + ": bad");
        }
    }
}
