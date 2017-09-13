import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EcologicalPremium {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i=0; i<n; i++) {
            int farmers = Integer.parseInt(in.readLine());
            int answer = 0;
            for(int j=0; j<farmers; j++) {
                String[] data = in.readLine().split(" ");
                answer += Integer.parseInt(data[0]) * Integer.parseInt(data[2]);
            }
            System.out.println(answer);
        }
    }
}
