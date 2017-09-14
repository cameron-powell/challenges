import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PermutationArrays {

    public static class Pair implements Comparable<Pair> {

        public int x;
        public String xPrime;

        public Pair(int x1, String xp) {
            this.x = x1;
            this.xPrime = xp;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.x, other.x);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(in.readLine());

        for(int t=0; t<tests; t++) {
            String blankLine = in.readLine();

            String[] xStrings = in.readLine().split(" ");
            String[] xpStrings = in.readLine().split(" ");
            ArrayList<Pair> pairs = new ArrayList<>();

            for(int i=0; i<xStrings.length; i++) {
                pairs.add(new Pair(Integer.parseInt(xStrings[i]), xpStrings[i]));
            }

            Collections.sort(pairs);

            for(Pair pair: pairs) {
                System.out.println(pair.xPrime);
            }

            if(t != tests-1) {
                System.out.println();
            }
        }
    }
}
