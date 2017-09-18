import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Set;
import java.util.TreeSet;

public class UVA599 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(in.readLine());
        for(int tc=0; tc<testCases; tc++) {
            ArrayList<String> edgeList = new ArrayList<>(); // edgeList.get(0).charAt(0) is vertex 1, ...charAt(1) is vertex 2
            String[] vertices;

            // Read the edges in
            String line;
            while((line=in.readLine()).charAt(0) != '*') {
                // Convert to our expected vertex form
                line = Character.toString(line.charAt(1)) + Character.toString(line.charAt(3));
                edgeList.add(line);
            }
            vertices = (line = in.readLine()).split(",");

            // Keep track of which letters of the alphabet we're using
            BitSet usedVertices = new BitSet(26);
            for(String vertex: vertices) {
                usedVertices.flip(charToUDFSSet(vertex.charAt(0)));
            }

            // Keep track of connections (assume all are TREES by definition)
            UnionFind forest = new UnionFind(26);
            for(String edge: edgeList) {
                int vertex1 = charToUDFSSet(edge.charAt(0));
                int vertex2 = charToUDFSSet(edge.charAt(1));
                forest.unionSet(vertex1, vertex2);
            }

            // Determine the number of trees in the forest
            int numTrees = 0;
            int numAcorns = 0;
            Set treeRepElements = new TreeSet();
            for(int i=0; i<26; i++) {
                if(usedVertices.get(i)) {
                    treeRepElements.add(forest.findSet(i));
                    if(forest.sizeOfSet(i) == 1) {
                        numAcorns++;
                    }
                }
            }
            numTrees = treeRepElements.size() - numAcorns;

            System.out.println("There are "+numTrees+" tree(s) and "+numAcorns+" acorn(s).");
        }
    }

    private static int charToUDFSSet(char c) {
        return Character.getNumericValue(c)-10;
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
