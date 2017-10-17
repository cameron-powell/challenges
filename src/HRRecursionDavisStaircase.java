import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class HRRecursionDavisStaircase {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numStairs = Integer.parseInt(in.readLine());
        for(int i=0; i<numStairs; i++) {
            int stairHeight = Integer.parseInt(in.readLine());
            HashMap<Integer, Integer> memo = new HashMap<>();
            System.out.println(stairWays(stairHeight, memo));
        }
    }

    private static int stairWays(int height, HashMap<Integer, Integer> memo) {
        if(height == 0) {
            return 1;
        } else if(height < 0) {
            return 0;
        } else {
            Integer ways3 = memo.get(height-3);
            if(ways3 == null) {
                ways3 = stairWays(height-3, memo);
                memo.put(height-3, ways3);
            }
            Integer ways2 = memo.get(height-2);
            if(ways2 == null) {
                ways2 = stairWays(height-2, memo);
                memo.put(height-2, ways2);
            }
            Integer ways1 = memo.get(height-1);
            if(ways1 == null) {
                ways1 = stairWays(height-1, memo);
                memo.put(height-1, ways1);
            }
            return ways3 + ways2 + ways1;
        }
    }
}
