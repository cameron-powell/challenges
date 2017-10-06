import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UVA484 {

    public static void main(String[] args) throws IOException {
        // Read the inputs
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inputs = new ArrayList<>();
        String line = "";
        while((line = in.readLine()) != null) {
            String[] stringInputs = line.split(" ");
            for(int i=0; i<stringInputs.length; i++) {
                try{
                    inputs.add(Integer.parseInt(stringInputs[i]));
                } catch(NumberFormatException nfe) {}
            }
        }

        // Collect frequencies and order
        ArrayList<Integer> ordering = new ArrayList<Integer>();
        HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        inputs.forEach( (input) -> {
            Integer mapVal = frequencies.get(input);
            // Check if we've seen this before
            if(mapVal != null) {
                // Add 1 to the frequency
                frequencies.put(input, ++mapVal);
            } else { // We haven't seen it before
                // Setup a frequency for it
                frequencies.put(input, 1);
                // Add it to the ordering list
                ordering.add(input);
            }
        });

        // Print the frequencies
        ordering.forEach( (key) -> {
            System.out.println(""+key+" "+frequencies.get(key));
        });
    }
}
