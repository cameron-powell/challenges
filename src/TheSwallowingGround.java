import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class TheSwallowingGround {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(in.readLine());
        for(int i=0; i<tests; i++) {
            in.readLine(); // Read a blank line.
            int columns = Integer.parseInt(in.readLine());
            HashSet<Integer> gaps = new HashSet<>();
            for(int j=0; j<columns; j++) {
                String[] colData = in.readLine().split(" ");
                gaps.add(Math.abs(Integer.parseInt(colData[0]) - Integer.parseInt(colData[1])));
            }

            System.out.println( (gaps.size() == 1) ? "yes" : "no" );
            if(i != tests-1) {
                System.out.println();
            }
        }
    }
}
