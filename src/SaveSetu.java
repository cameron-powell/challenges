import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SaveSetu {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numTests = new Integer(in.readLine());
        int sumMoney = 0;
        for(int t=0; t<numTests; t++) {
            String line = in.readLine();
            if(line.contains("donate")) {
                sumMoney += new Integer(line.split(" ")[1]);
            } else {
                System.out.println(sumMoney);
            }
        }
    }
}