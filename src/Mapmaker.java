import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mapmaker {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int numArrays = new Integer(in.next());
        int numRefs = new Integer(in.next());

        ArrayList<Array> arrays = new ArrayList<>();

        // Get the array definitions.
        for(int i=0; i<numArrays; i++) {
            String name = in.next();
            int baseAddress = new Integer(in.next());
            int elementByteSize = new Integer(in.next());
            int dimensions = new Integer(in.next());

            Array array = new Array(name, baseAddress, elementByteSize, dimensions);
            // Add the lower and upper bounds of each dimension.
            for(int d=0; d<dimensions; d++) {
                int lower = new Integer(in.next());
                int upper = new Integer(in.next());
                array.setBound(lower, upper, d);
            }
            // Add the array to our arrays.
            arrays.add(array);
        }

        // Solve for each reference.
        for(int r=0; r<numRefs; r++) {
            String refName = in.next();

            Array array = null;
            for(Array ar: arrays) {
                if(ar.getName().equals(refName)) {
                    array = ar;
                    break;
                }
            }

            int[] indexes = new int[array.getDimensions()];
            for(int i=0; i<array.getDimensions(); i++) {
                indexes[i] = new Integer(in.next());
            }

            String output = array.getName() + "[" + indexes[0];
            for(int i=1; i<indexes.length; i++) {
                output += ", " + indexes[i];
            }
            output += "] = ";

            int[] C = new int[array.getDimensions()+1];
            C[array.getDimensions()] = array.getElementByteSize();
            for(int i=array.getDimensions()-1; i>0; i--) {
                C[i] = C[i+1] * (array.getUBound(i) - array.getLBound(i) + 1);
            }
            C[0] = array.getBaseAddress();
            for(int i=1; i<=array.getDimensions(); i++) {
                C[0] -= C[i] * array.getLBound(i-1);
            }

            int physicalAddress = C[0];
            for(int i=0; i<indexes.length; i++) {
                physicalAddress += C[i+1] * indexes[i];
            }

            System.out.println(output + physicalAddress);
        }
    }

    public static class Array {
        private String name;
        private int baseAddress;
        private int elementByteSize;
        private int dimensions;
        private int[] lBounds, uBounds;

        public Array(String n, int ba, int ebs, int d) {
            name = n;
            baseAddress = ba;
            elementByteSize = ebs;
            dimensions = d;
            lBounds = new int[dimensions];
            uBounds = new int[dimensions];
        }

        public String getName() {return name;}
        public int getBaseAddress() {return baseAddress;}
        public int getElementByteSize() {return elementByteSize;}
        public int getDimensions() {return dimensions;}
        public int[] getLBounds() {return lBounds;}
        public int getLBound(int dimension) {return lBounds[dimension];}
        public int[] getUBounds() {return uBounds;}
        public int getUBound(int dimension) {return uBounds[dimension];}
        public String toString() {
            String s = name;
            s += " " + getBaseAddress();
            s += " " + getElementByteSize();
            s += " " + getDimensions();
            for(int i=0; i<getDimensions(); i++) {
                s += " " + getLBound(i) + " " + getUBound(i);
            }
            return s;
        }

        public void setBound(int lower, int upper, int dimension) {
            lBounds[dimension] = lower;
            uBounds[dimension] = upper;
        }
    }
}
