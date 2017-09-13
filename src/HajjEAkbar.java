import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HajjEAkbar {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int currentCase = 1;
        while(!(line = in.readLine()).equals("*")) {
            System.out.println( (line.contains("Hajj")) ?
                    "Case "+currentCase+": Hajj-e-Akbar":
                    "Case "+currentCase+": Hajj-e-Asghar");
            currentCase++;
        }
    }
}