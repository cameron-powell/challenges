import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class SynchingSignals {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int set = 1;
        while((input = in.readLine()) != null) {
            String[] splinput = input.split(" ");
            BitSet[] cycles = new BitSet[splinput.length];

            ArrayList<Integer> cycleTimes = new ArrayList<>();
            for(int i=0; i<splinput.length; i++) {
                BitSet cycle = new BitSet(4000);
                int cycleTime = new Integer(splinput[i]);
                cycleTimes.add(cycleTime);
                for(int j=0; j<4000; j+=cycleTime*2) {
                    cycle.set(j, j+cycleTime-5);
                }
                cycles[i] = cycle;
            }

            //remove early error.
            int minCycleTime = 90;
            for(int time: cycleTimes) {
                if(time < minCycleTime) {
                    minCycleTime = time;
                }
            }

            BitSet finalSet = cycles[0];
            for(BitSet bs: cycles) {
                finalSet.and(bs);
            }

            finalSet.clear(0, minCycleTime);

            int seconds = finalSet.nextSetBit(0);
            if(seconds > 3600) { seconds = -1; }

            if(seconds == -1) {
                System.out.println("Set " + set + " is unable to synch after one hour.");
            } else {
                int mins = seconds / 60;
                int secs = seconds % 60;
                System.out.println("Set " + set + " synchs again at " + mins + " minute(s) and " + secs + " second(s) after all turning green.");
            }

            set++;
        }
    }
}
