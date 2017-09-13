import java.util.Scanner;

public class HRCamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int wordCount = 1;
        for(int i=0; i<input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
