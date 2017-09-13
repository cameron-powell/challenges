import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SecretResearch {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(in.readLine());
        for(int t=0; t<tests; t++) {
            String line = in.readLine();

            if(line.equals("1") || line.equals("4") || line.equals("78")) {
                System.out.println("+");
            } else if(line.substring(line.length()-2, line.length()).equals("35")) {
                System.out.println("-");
            } else if(line.charAt(0) == '9' && line.charAt(line.length()-1) == '4') {
                System.out.println("*");
            } else {
                System.out.println("?");
            }
        }
    }
}
