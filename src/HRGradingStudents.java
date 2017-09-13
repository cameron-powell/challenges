import java.util.Scanner;

public class HRGradingStudents {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numStudents = in.nextInt();
        int[] grades = new int[numStudents];
        for(int i=0; i<numStudents; i++) {
            int temp = in.nextInt();
            if(temp < 38) {
                grades[i] = temp;
            } else {
                int smallestDigit = temp % 10;
                if(smallestDigit > 5) {
                    int diff = 10-smallestDigit;
                    if(diff < 3) {
                        grades[i] = temp+diff;
                    } else {
                        grades[i] = temp;
                    }
                } else if(smallestDigit < 5) {
                    int diff = 5-smallestDigit;
                    if(diff < 3) {
                        grades[i] = temp+diff;
                    } else {
                        grades[i] = temp;
                    }
                } else {
                    grades[i] = temp;
                }
            }
        }

        for(int i=0; i<numStudents;i++) {
            System.out.println(grades[i]);
        }
    }
}
