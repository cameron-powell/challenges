import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UVA11078 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int t=0; t<T; t++) {
            int numStudents = Integer.parseInt(in.readLine());

            int biggestDiff = Integer.MIN_VALUE;
            int biggestIQ = Integer.parseInt(in.readLine());
            for(int i=0; i<numStudents-1; i++) {
                int currentStudent = Integer.parseInt(in.readLine());
                if(biggestIQ-currentStudent > biggestDiff) {
                    biggestDiff = biggestIQ - currentStudent;
                }
                if(currentStudent > biggestIQ) {
                    biggestIQ = currentStudent;
                }
            }
            System.out.println(""+biggestDiff);
        }
    }
}
