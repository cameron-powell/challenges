import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class OneTwoThree {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numTests = new Integer(in.readLine());
        for(int t=0; t<numTests; t++) {
            String input = in.readLine();

            // Check if it's three.
            if(input.length() == 5) {
                System.out.println("3");
                continue;
            }

            // Diff the input with "one".
            String oneStr = "one";
            int diff = 0;
            for(int i=0; i<3; i++) {
                if(oneStr.charAt(i) != input.charAt(i)) {
                    diff++;
                }
            }

            if(diff <= 1) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

}
