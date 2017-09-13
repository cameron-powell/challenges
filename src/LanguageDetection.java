import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LanguageDetection {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int testNo = 1;
        while((line = in.readLine()) != "#") {
            String answer = "Case " + testNo + ": ";
            if(line.equals("#")) {
                break;
            } else if(line.equals("HELLO")) {
                answer += "ENGLISH";
            } else if(line.equals("HOLA")) {
                answer += "SPANISH";
            } else if(line.equals("HALLO")) {
                answer += "GERMAN";
            } else if(line.equals("BONJOUR")) {
                answer += "FRENCH";
            } else if(line.equals("CIAO")) {
                answer += "ITALIAN";
            } else if(line.equals("ZDRAVSTVUJTE")) {
                answer += "RUSSIAN";
            } else {
                answer += "UNKNOWN";
            }
            testNo++;
            System.out.println(answer);
        }
    }

}
