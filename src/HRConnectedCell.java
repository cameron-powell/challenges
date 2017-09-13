import java.util.*;

public class HRConnectedCell {

    private static class Node {
        private int n;
        private int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {return this.n;}
        public int getM() {return this.m;}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        // Search for the largest region
        int largestRegion = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int currentRegionCount = dfs(i,j,grid);
                largestRegion = (currentRegionCount > largestRegion) ? currentRegionCount : largestRegion;
            }
        }

        // Print the size of the larges region
        System.out.println(largestRegion);
    }

    // Returns the number of cells in the grid given the starting position
    public static int dfs(int startingN, int startingM, int[][] matrix) {
        // Check if this is a legal starting cell
        if(matrix[startingN][startingM] == 0) {
            return 0;
        }

        // Create a matrix for telling whether a cell has been visited or not in this dfs pass
        int maxN = matrix.length;
        int maxM = matrix[0].length;
        boolean[][] visitedMatrix = new boolean[maxN][maxM];

        // Mark each cell as not visited before beginning.
        for(int i=0; i<maxN; i++) {
            for(int j=0; j<maxM; j++) {
                visitedMatrix[i][j] = false;
            }
        }

        // Setup our DFS stack
        Stack<Node> dfsStack = new Stack();
        Node root = new Node(startingN, startingM);
        dfsStack.push(root);
        visitedMatrix[startingN][startingM] = true;

        // Perform DFS to find the number of cells in the current region
        int regionCellCount = 0;
        while(!dfsStack.empty()) {

            // Add the current node to our regional cell count
            Node current = dfsStack.pop();
            regionCellCount++;

            // Add child nodes to the dfs stack
            for(int nMod = -1; nMod <= 1; nMod++) {
                for(int mMod = -1; mMod <= 1; mMod++) {
                    int n = current.getN() + nMod;
                    int m = current.getM() + mMod;
                    // Check that new n and m are within the grid bounds
                    if(n >= 0 && n < maxN && m >= 0 && m < maxM) {
                        // Check that the cell is filled
                        if(matrix[n][m] == 1) {
                            // Check that we haven't visited that cell yet
                            if(visitedMatrix[n][m] == false) {
                                // Add to our dfs stack
                                dfsStack.push(new Node(n, m));
                                // Mark that cell as visited
                                visitedMatrix[n][m] = true;
                            }
                        }
                    }
                }
            }
        }

        return regionCellCount;
    }

    public static void printIntMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(""+matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void printBooleanMatrix(boolean[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(""+matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}