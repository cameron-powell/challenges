import java.util.Scanner;

public class HRCompTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0, a1, a2, b0, b1, b2;
        a0 = in.nextInt();
        a1 = in.nextInt();
        a2 = in.nextInt();
        b0 = in.nextInt();
        b1 = in.nextInt();
        b2 = in.nextInt();

        int aliceScore = 0, bobScore = 0;
        if(a0 < b0) {
            bobScore++;
        } else if(a0 > b0) {
            aliceScore++;
        }
        if(a1 < b1) {
            bobScore++;
        } else if(a1 > b1) {
            aliceScore++;
        }
        if(a2 < b2) {
            bobScore++;
        } else if(a2 > b2) {
            aliceScore++;
        }

        System.out.println(""+aliceScore+" "+bobScore);
    }
}
