import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MachinedSurfaces {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String numLines;
        while(!(numLines = in.readLine()).equals("0")) {
            int[] numBinLine = new int[new Integer(numLines)];
            int minB = 25;
            for(int i=0; i<new Integer(numLines); i++) {
                int blankCount = 0;
                String line = in.readLine();
                for(int j=0; j<line.length(); j++) {
                    if(Character.isWhitespace(line.charAt(j))) {
                        blankCount++;
                    }
                }
                if(blankCount < minB) {
                    minB = blankCount;
                }
                numBinLine[i] = blankCount;
            }

            int totalVoid = 0;
            for(int i=0; i<numBinLine.length; i++) {
                totalVoid += numBinLine[i] - minB;
            }

            System.out.println(totalVoid);
        }
    }
}
