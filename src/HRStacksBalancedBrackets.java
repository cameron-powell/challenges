import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HRStacksBalancedBrackets {

    public static boolean isBalanced(String expression) {
        if(expression.length()%2 != 0) {
            return false;
        }
        Stack<Character> leftBrackets = new Stack<>();
        for(int i=0; i<expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if(currentChar == '{' || currentChar == '[' || currentChar == '(') {
                leftBrackets.push(currentChar);
            }
            if(currentChar == '}' || currentChar == ']' || currentChar == ')') {
                Character leftBracket = null;
                try {
                    leftBracket = leftBrackets.pop();
                } catch(EmptyStackException ese) {
                    return false;
                }

                if(!isBracketSet(leftBracket, currentChar)) {
                    return false;
                }
            }
        }
        if(!leftBrackets.empty()) {
            return false;
        }
        return true;
    }

    public static boolean isBracketSet(char leftBracket, char rightBracket) {
        if(leftBracket == '{' && rightBracket == '}' ||
                leftBracket == '[' && rightBracket == ']' ||
                leftBracket == '(' && rightBracket == ')') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
