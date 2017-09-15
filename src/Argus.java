import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Argus {

    public static class Register implements Comparable<Register> {

        public int id;
        public int period;
        public int time;

        public Register(int i, int p) {
            this.id = i;
            this.period = p;
            this.time = period;
        }

        public Register(int i, int p, int t) {
            this.id = i;
            this.period = p;
            this.time = t;
        }

        public int compareTo(Register otherRegister) {
            if(this.time != otherRegister.time) {
                return Integer.compare(this.time, otherRegister.time);
            }
            return Integer.compare(this.id, otherRegister.id);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Register> registerList = new ArrayList<>();
        while(!(input = in.readLine()).equals("#")) {
            String[] splitInput = input.split(" ");
            registerList.add(new Register(Integer.parseInt(splitInput[1]), Integer.parseInt(splitInput[2])));
        }
        int K = Integer.parseInt(in.readLine());

        Queue<Register> registerQueue = new PriorityQueue<>();
        for(int i=1; i<=K; i++) {
            for(Register reg: registerList) {
                registerQueue.add(new Register(reg.id, reg.period, reg.period*i));
            }
        }

        for(int i=0; i<K; i++) {
            System.out.println(registerQueue.poll().id);
        }
    }
}
