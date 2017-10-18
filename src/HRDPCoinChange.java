import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HRDPCoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        Arrays.sort(coins);
        HashMap<String, Long> memo = new HashMap<>();
        System.out.println(numWays(coins, n, coins[coins.length-1], memo));
    }

    private static Long numWays(int[] coins, int dollars, int biggestCoin, HashMap<String, Long> memo) {
        if(dollars < 0) {
            return (long)0;
        }
        if(dollars == 0) {
            return (long)1;
        }
        String memoKey = ""+Integer.toString(dollars)+" "+Integer.toString(biggestCoin);
        Long ways = memo.get(memoKey);
        if(ways == null) {
            ways = (long)0;
            for(int i=0; i<coins.length; i++) {
                if(coins[i] <= biggestCoin) {
                    ways += numWays(coins,dollars-coins[i], coins[i], memo);
                } else {
                    break;
                }
            }
            memo.put(memoKey, ways);
        }
        return ways;
    }
}