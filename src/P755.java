import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P755 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numDatasets = Integer.parseInt(in.readLine());
        for(int t=0; t<numDatasets; t++) {
            in.readLine(); // Read a blank line.
            int numTelNumbers = Integer.parseInt(in.readLine());
            ArrayList<String> convertedNumbers = new ArrayList<>();
            HashMap<String, Integer> countMap = new HashMap<>();
            for(int i=0; i<numTelNumbers; i++) {
                String rawNumber = in.readLine().replaceAll("-", "");
                String resultNum = "";
                for(int j=0; j<rawNumber.length(); j++) {
                    int converted = convert(rawNumber.charAt(j));
                    resultNum += ""+converted;
                }
                convertedNumbers.add(resultNum);
            }

            for(String number: convertedNumbers) {
                if(countMap.containsKey(number)) {
                    int countBefore = countMap.get(number);
                    countMap.put(number, countBefore+1);
                } else {
                    countMap.put(number, 1);
                }
            }

            ArrayList<String> noDuplicates = new ArrayList<>();
            for(String key: countMap.keySet()) {
                noDuplicates.add(key);
            }

            Collections.sort(noDuplicates);

            boolean duplicateFound = false;
            for(String number: noDuplicates) {
                int numOfThisNum = countMap.get(number);
                if(numOfThisNum > 1) {
                    System.out.println(number.substring(0,3) + "-" + number.substring(3) + " " + numOfThisNum);
                    duplicateFound = true;
                }
            }

            if(!duplicateFound) {
                System.out.println("No duplicates.");
            }

            if(t != numDatasets-1) {
                System.out.println();
            }
        }
    }

    public static int convert(char c) {
        if(c == '0') {
          return 0;
        } else if(c == '1') {
          return 1;
        } else if(c == 'A' || c == 'B' || c == 'C' || c == '2') {
            return 2;
        } else if(c == 'D' || c == 'E' || c == 'F' || c == '3') {
            return 3;
        } else if(c == 'G' || c == 'H' || c == 'I' || c == '4') {
            return 4;
        } else if(c == 'J' || c == 'K' || c == 'L' || c == '5') {
            return 5;
        } else if(c == 'M' || c == 'N' || c == 'O' || c == '6') {
            return 6;
        } else if(c == 'P' || c == 'R' || c == 'S' || c == '7') {
            return 7;
        } else if(c == 'T' || c == 'U' || c == 'V' || c == '8') {
            return 8;
        } else {
            return 9;
        }
    }
}
