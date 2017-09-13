import java.util.Scanner;

public class HRBirthdayCandles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxHeight = 0;
        int candleCount = 1;
        for(int i=0; i<n; i++) {
            int temp = in.nextInt();
            if(temp > maxHeight) {
                maxHeight = temp;
                candleCount = 1;
            } else if(temp == maxHeight) {
                candleCount++;
            }
        }
        System.out.println(candleCount);
    }
}
