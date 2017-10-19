import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class IceCream {
    int cost;
    int number;
}

public class HRBinarySearchIceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            // Create an array of ice creams
            IceCream[] iceCreams = new IceCream[n];
            for(int i=0; i < n; i++){
                IceCream iceCream = new IceCream();
                iceCream.cost = in.nextInt();
                iceCream.number = i+1;
                iceCreams[i] = iceCream;
            }
            // Sort the array of ice creams, ascending, by cost
            Arrays.sort(iceCreams, (ic1, ic2) -> {
                return ic1.cost - ic2.cost;
            });
            // Go through and find which two add up to the amount of money we have
            for(IceCream iceCream: iceCreams) {
                int moneyLeft = m - iceCream.cost;
                // Binary search ice creams to see if there exists
                int otherIceCream = binarySearch(iceCreams, moneyLeft);
                if(otherIceCream != -1) {
                    if(iceCream.number != otherIceCream){
                        System.out.println(""+Math.min(iceCream.number, otherIceCream)+" "+Math.max(iceCream.number, otherIceCream));
                        break;
                    }
                }
            }
        }
    }

    // Returns number of the ice cream looked for, -1 if doesn't exist
    public static int binarySearch(IceCream[] iceCreams, int searchCost) {
        int left = 0;
        int right = iceCreams.length-1;

        while(left <= right) {
            int mid = left + ((right-left)/2);
            if(iceCreams[mid].cost == searchCost) {
                return iceCreams[mid].number;
            } else if(searchCost < iceCreams[mid].cost) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }
}