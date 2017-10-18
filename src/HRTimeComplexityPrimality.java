import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HRTimeComplexityPrimality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    private static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        if (n % 2 == 0 && n != 2) {
            return false;
        }
        for(int i=3; i<=Math.ceil(Math.sqrt(n)); i+=2) {
            if(n % i == 0 && i != n) {
                return false;
            }
        }
        return true;
    }
}