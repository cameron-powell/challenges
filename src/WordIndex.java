import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class WordIndex {

    public static void main(String[] args) throws IOException {
        // Generate all words.
        Map<String, Integer> allWords = new TreeMap<>();
        int count = 1;
        // Single letters.
        for(int i=97; i<123; i++) {
            String key = "" + (char)i;
            allWords.put(key, count++);
        }
        // Double letters.
        for(int i=97; i<122; i++) {
            for(int j=i+1; j<123; j++) {
                String key = "" + (char)i + "" + (char)j;
                allWords.put(key, count++);
            }
        }
        // Triple letters.
        for(int i=97; i<121; i++) {
            for(int j=i+1; j<122; j++) {
                for(int k=j+1; k<123; k++) {
                    String key = "" + (char)i + "" + (char)j + "" + (char)k;
                    allWords.put(key, count++);
                }
            }
        }
        // Quadruple letters.
        for(int i=97; i<120; i++) {
            for(int j=i+1; j<121; j++) {
                for(int k=j+1; k<122; k++) {
                    for(int l=k+1; l<123; l++) {
                        String key = "" + (char)i + "" + (char)j + "" + (char)k + "" + (char)l;
                        allWords.put(key, count++);
                    }
                }
            }
        }
        // Pentuple letters.
        for(int i=97; i<119; i++) {
            for(int j=i+1; j<120; j++) {
                for(int k=j+1; k<121; k++) {
                    for(int l=k+1; l<122; l++) {
                        for(int m=l+1; m<123; m++) {
                            String key = "" + (char)i + "" + (char)j + "" + (char)k + "" + (char)l + "" + (char)m;
                            allWords.put(key, count++);
                        }
                    }
                }
            }
        }

        // Get the input and output each word's value.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = in.readLine()) != null) {
            if(allWords.containsKey(input)) {
                System.out.println(allWords.get(input));
            } else {
                System.out.println("0");
            }
        }
    }
}
