import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CelebrityJeopardy {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input = in.readLine()) != null) {
            System.out.println(input);
        }
    }
}
