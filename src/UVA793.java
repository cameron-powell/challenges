import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class UVA793 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        reader.readLine(); // Read the blank line
        ArrayList<String> outputs = new ArrayList<>();
        for(int c=0; c<cases; c++) {
            int numComputers = Integer.parseInt(reader.readLine());
            UnionFind network = new UnionFind(numComputers);

            int successful = 0;
            int unsuccessful = 0;
            String command;

            while((command = reader.readLine()) != null) {
                if(command.equals("")) {
                    break;
                }

                String[] commandChunks = command.split(" ");
                int computer1 = Integer.parseInt(commandChunks[1]) - 1;
                int computer2 = Integer.parseInt(commandChunks[2]) - 1;
                if(commandChunks[0].equals("q")) {
                    if(network.isSameSet(computer1, computer2)) {
                        successful++;
                    } else {
                        unsuccessful++;
                    }
                } else {
                    network.unionSet(computer1, computer2);
                }
            }

            outputs.add(""+successful+","+unsuccessful);
        }

        for(int i=0; i<outputs.size(); i++) {
            String output = outputs.get(i);
            System.out.println((i == outputs.size() - 1) ? output : output+"\n");
        }
    }

    private static class UnionFind {

        /* Private Member Variables */
        private ArrayList<Integer> p;
        private ArrayList<Integer> rank;
        private ArrayList<Integer> setSize;
        private int numSets;

        /* Constructor */
        public UnionFind(int numSets) {
            p = new ArrayList<Integer>(numSets);
            rank = new ArrayList<Integer>(numSets);
            setSize = new ArrayList<Integer>(numSets);
            this.numSets = numSets;

            for(int i=0; i<numSets; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        /* Functions */
    /*
    function: findSet
    purpose: Find the representative element of the passed in element's set
    description: Recursively traverses the "set" (tree) until it finds the representative element (aka the element
    which points to itself) and returns the value of the representative element.
     */
        public int findSet(int element) {
            if(p.get(element) == element) {
                return element;
            } else {
                int ret = findSet(p.get(element));
                p.set(element, ret);
                return ret;
            }
        }

        /*
        function: isSameSet
        purpose: Determine if two elements are within the same set
        description: Performs findSet to get the representative elements of both sets.  Returns true if
        both sets have the same representative element.
         */
        public boolean isSameSet(int element1, int element2) {
            return (findSet(element1) == findSet(element2));
        }

        /*
        function: unionSet
        purpose: combine two disjoint sets into one set given two elements (assuming they're from disjoint sets)
        description: Grabs the representative elements of both sets and updates everything to point to the new
        representative element of both sets.
         */
        public void unionSet(int element1, int element2) {
            // Make sure the elements aren't already in the same set (do nothing if they are)
            if(!isSameSet(element1, element2)) {
                numSets--;
                // Grab the representative elements of both sets
                int representative1 = findSet(element1);
                int representative2 = findSet(element2);
                // Rank is used to keep the tree short
                if(rank.get(representative1) > rank.get(representative2)) {
                    p.set(representative2, representative1);
                    setSize.set(representative1, setSize.get(representative1) + setSize.get(representative2));
                } else {
                    p.set(representative1, representative2);
                    setSize.set(representative2, setSize.get(representative2) + setSize.get(representative1));
                    if(rank.get(representative1) == rank.get(representative2)) {
                        rank.set(representative2, rank.get(representative2) + 1);
                    }
                }
            }
        }

        /*
        function: numDisjointSets
        purpose: to return the number of disjoint sets contained within the UF data structure
        description: Just returns the numSets variable.  numSets is updated when appropriate inside of the constructor
        and within the unionSet function.
         */
        public int numDisjointSets() {
            return numSets;
        }

        /*
        function: sizeOfSet
        purpose: return the size of the set containing the element passed in
        description: finds the representative element of the set containing the element passed in.  Uses that element
        to find the size of its set which is stored in setSize where index = representativeElement
         */
        public int sizeOfSet(int element) {
            return setSize.get(findSet(element));
        }
    }
}
