import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchingQuickly {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Set<String> ignoreSet = new HashSet<>();
        String ignoreWord;
        while(!(ignoreWord = in.readLine()).equals("::")) {
            ignoreSet.add(ignoreWord);
        }

        List<String> titleList = new ArrayList<>();
        Set<String> kwicWordsSet = new TreeSet<>();
        Map<String, Set<String>> titleContains = new HashMap<>();

        String titleIn;
        while((titleIn = in.readLine()) != null) {
            titleIn = titleIn.toLowerCase();
            titleList.add(titleIn);

            String[] splitTitle = titleIn.split(" ");
            for(String word: splitTitle) {
                if(!ignoreSet.contains(word)) {
                    boolean isNew = kwicWordsSet.add(word);
                    if(isNew) {
                        titleContains.put(word, new HashSet<String>());
                    }
                    titleContains.get(word).add(titleIn);
                }
            }
        }

        for(String kwicWord: kwicWordsSet) {
            for(String title: titleList) {
                if(titleContains.get(kwicWord).contains(title)) {
                    Pattern patt = Pattern.compile("\\b" + kwicWord + "\\b");
                    Matcher match = patt.matcher(title);
                    while (match.find()) {             // true while the pattern still matches
                        int start = match.start();     // starting index of match (inclusive)
                        int end = match.end();         // ending index of match (exclusive)
                        System.out.println(title.substring(0, start) + match.group().toUpperCase() + title.substring(end));
                    }
                }
            }
        }
    }
}
