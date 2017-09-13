import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EmoogleBalance {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int testCase = 0;
        while(!(line = in.readLine()).equals("0")) {
            String[] input = in.readLine().split(" ");
            int numZeros = 0;
            for(int i=0; i<input.length; i++) {
                if(input[i].equals("0")) {
                    numZeros++;
                }
            }

            System.out.println("Case " + (++testCase) + ": " + (input.length-(2*numZeros)));
        }
    }

}
