import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HRThePowerSum {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int X = Integer.parseInt(in.readLine());
        final int N = Integer.parseInt(in.readLine());
        System.out.println(findWays(X, N, 1));
    }

    private static int findWays(int total, int power, int starting) {
        int startingPower = (int)Math.pow(starting, power);
        int left = total - startingPower;

        if(left < 0) {
            return 0; // Not it
        } else if(left == 0) {
            return 1; // We found it
        } else {
            return findWays(left, power, starting+1) + findWays(total, power, starting+1);
        }
    }
}