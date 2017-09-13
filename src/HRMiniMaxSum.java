import java.util.Scanner;

public class HRMiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum=0, min=Long.MAX_VALUE, max=Long.MIN_VALUE;
        for(int i=0; i<5; i++) {
            Long temp = in.nextLong();
            sum += temp;
            if(temp < min) {
                min = temp;
            }
            if(temp > max) {
                max = temp;
            }
        }

        System.out.println(""+(sum-max)+ " "+(sum-min));
    }
}
