import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UVA10895 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = in.readLine()) != null) {
            String[] matrixSize = input.split(" ");
            int m = Integer.parseInt(matrixSize[0]);
            int n = Integer.parseInt(matrixSize[1]);
            ArrayList<ArrayList<IntegerPair>> adjacencyList = new ArrayList<>();
            for(int i=1; i<=n; i++) {
                adjacencyList.add(new ArrayList<IntegerPair>());
            }

            for(int i=0; i<m; i++) {
                String[] line1 = (in.readLine()).split(" ");
                String[] line2 = (in.readLine()).split(" ");
                int r = Integer.parseInt(line1[0]);
                if(r == 0) {
                    continue;
                }

                // Construct the transposed adjacency list
                for(int j=0; j<line2.length; j++) {
                    int newRow = Integer.parseInt(line1[j+1]);
                    int value = Integer.parseInt(line2[j]);

                    // TODO: If this isn't working, assume we didn't get the reference by value
                    ArrayList<IntegerPair> row = adjacencyList.get(newRow-1);
                    IntegerPair ip = new IntegerPair(i+1, value);
                    row.add(ip);
                }
            }
            // Print out the new transposed matrix
            System.out.println(""+n+" "+m);
            for(int row=0; row<adjacencyList.size(); row++) {
                String row2 = "";
                System.out.print(adjacencyList.get(row).size());
                Collections.sort(adjacencyList.get(row));
                if(adjacencyList.get(row).size() == 0) {
                    System.out.print("\n");
                    System.out.println();
                    continue;
                }
                for(IntegerPair ip: adjacencyList.get(row)) {
                    System.out.print(" "+ip.getColumn());
                    row2+=" "+ip.getVal();
                }
                System.out.print("\n");
                System.out.println(row2.trim());
            }
        }
    }

    private static class IntegerPair implements Comparable {
        private int column;
        private int value;

        public IntegerPair(int col, int val) {
            this.column = col;
            this.value = val;
        }

        @Override
        public int compareTo(Object otherObject) {
            IntegerPair other = (IntegerPair)otherObject;
            if(column < other.getColumn()) {
                return -1;
            }
            if(column > other.getColumn()) {
                return 1;
            }
            return 0;
        }

        public int getColumn() {
            return this.column;
        }

        public int getVal() {
            return this.value;
        }

        public void setColumn(int newCol) {
            this.column = newCol;
        }

        public void setVal(int newVal) {
            this.value = newVal;
        }
    }

}
