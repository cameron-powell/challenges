import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HRSortingBubbleSort {

    public static void main(String[] args) throws IOException {
        // Read in inputs
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] a = in.readLine().split(" ");
        // Convert inputs to integer array
        int[] inputs = new int[n];
        for(int i=0; i<n; i++) {
            inputs[i] = Integer.parseInt(a[i]);
        }
        // Sort the array and count the swaps
        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (inputs[j] > inputs[j + 1]) {
                    // Swap
                    int temp = inputs[j+1];
                    inputs[j+1] = inputs[j];
                    inputs[j] = temp;
                    numberOfSwaps++;
                }
            }

            // Add to total swaps
            totalSwaps += numberOfSwaps;

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        // Print the requested values
        System.out.println("Array is sorted in "+Integer.toString(totalSwaps)+" swaps.");
        System.out.println("First Element: "+Integer.toString(inputs[0]));
        System.out.println("Last Element: "+Integer.toString(inputs[n-1]));
    }
}
