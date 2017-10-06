import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UVA725 {

    public static void main(String[] args) throws IOException {
        // Read inputs
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean first = true;
        while(!(line = in.readLine()).equals("0")) {
            if(!first) {
                System.out.println();
            } else {
                first = false;
            }
            int N = Integer.parseInt(line);
            blackBox(N);
        }
    }

    public static void blackBox(int N) {
        boolean found = false;
        for(int fghij = 1234; fghij <= 98765/N; fghij++) {
            int abcde = fghij * N;
            int temp, used = (fghij < 10000) ? 1 : 0;
            temp = abcde;
            while(temp >= 1) {
                used |= 1 << (temp % 10);
                temp /= 10;
            }
            temp = fghij;
            while(temp >= 1) {
                used |= 1 << (temp % 10);
                temp /= 10;
            }
            if(used == (1<<10) - 1) {
                String zeroNeeded = (Integer.toString(fghij).length() == 4) ? "0":"";
                System.out.println(""+abcde+" / "+zeroNeeded+""+fghij+" = "+N);
                found = true;
            }
        }
        if(!found) {
            System.out.println("There are no solutions for "+N+".");
        }
    }
}
