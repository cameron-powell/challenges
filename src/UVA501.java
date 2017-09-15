import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVA501 {

    public static void main(String[] args) {
        // Input Setup
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        // Play K games
        for(int plays=0; plays<K; plays++) {
            in.nextLine(); // Read the blank line between games
            int m,numGets;
            m = in.nextInt();
            numGets = in.nextInt();

            ArrayList<Integer> adds = new ArrayList<>();
            ArrayList<Integer> gets = new ArrayList<>();
            // Read Add's
            for(int j=0; j<m; j++) {
                adds.add(in.nextInt());
            }
            // Read updates
            for(int j=0; j<numGets; j++) {
                gets.add(in.nextInt());
            }

            //
            ArrayList<Integer> blackBox = new ArrayList<>();
            int index=0;
            int getsIndex=0;
            for(int i=0; i<adds.size(); i++) {
                int insertAt = Collections.binarySearch(blackBox,new Integer(adds.get(i)));
                if(insertAt < 0) {
                    blackBox.add((-1*(insertAt + 1)), adds.get(i));
                } else {
                    blackBox.add(insertAt, adds.get(i));
                }

/*                if(insertAt < 0){
                    blackBox.add(adds.get(i));
                } else {
                    blackBox.add(insertAt+1, adds.get(i));
                }*/
                //blackBox.add(adds.get(i));                                   //System.out.println("ADD("+adds.get(i)+")");
                //Collections.sort(blackBox);

                while(true) {
                    if(gets.size() <= getsIndex) {
                        break;
                    }
                    if(gets.get(getsIndex) == blackBox.size()) {
                        index++;
                        System.out.println(blackBox.get(index-1));             //System.out.println("GET");
                        getsIndex++;
                    } else {
                        break;
                    }
                }
            }
            if(plays != K-1) {
                System.out.println();//print blank between games
            }

        }
    }
}
