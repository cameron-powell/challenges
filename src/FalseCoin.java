import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class FalseCoin {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(in.readLine());

        for(int t=0; t<M; t++) {
            int N, K;
            // read blank line.
            in.readLine();

            String[] nkStrings = in.readLine().split(" ");
            N = Integer.parseInt(nkStrings[0]);
            K = Integer.parseInt(nkStrings[1]);

            // p_i is at i-1
            // true means potentially false
            BitSet coins = new BitSet(N);
            coins.set(0, N, true);

            for(int c=0; c<K; c++) {
                ArrayList<Integer> leftPan = new ArrayList<>(), rightPan = new ArrayList<>();
                String[] line1 = in.readLine().split(" ");
                String comparator = in.readLine();
                int panContains = Integer.parseInt(line1[0]);
                for(int i=1; i<line1.length; i++) {
                    if(i<=panContains) {
                        leftPan.add(Integer.parseInt(line1[i]));
                    } else {
                        rightPan.add(Integer.parseInt(line1[i]));
                    }
                }

                if(comparator.equals("=")) {
                    for(int coinNo: leftPan) {
                        coins.set(coinNo-1, false);
                    }
                    for(int coinNo: rightPan) {
                        coins.set(coinNo-1, false);
                    }
                } else if(comparator.equals("<") || comparator.equals(">")) {
                    BitSet prev = (BitSet)coins.clone();
                    coins.clear();
                    for(int coinNo: leftPan) {
                        coins.set(coinNo-1, true);
                    }
                    for(int coinNo: rightPan) {
                        coins.set(coinNo-1, true);
                    }
                    coins.and(prev);
                }
            }

            if(coins.cardinality() == 1) {
                System.out.println(coins.nextSetBit(0) + 1);
            } else {
                System.out.println(0);
            }

            if(t != M-1) {
                System.out.println();
            }
        }
    }
}
