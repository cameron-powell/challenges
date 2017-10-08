public class CTCI1_3 {

    public static void main(String[] args) {
        char[] nonUrl = {'m', 'i', 's', 't', 'e', 'r', ' ', 'j', 'o', 'h', 'n', ' ', 's', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};

        printCharArr(nonUrl);
        // URLIFY
        for(int i=0; i<nonUrl.length; i++) {
            // If we run across a space4
            if(nonUrl[i] == ' ') {
                // shift everything right 2 spaces
                for(int j=nonUrl.length-1; j>=i+2; j--) {
                    nonUrl[j] = nonUrl[j-2];
                }
                // Set the space and next characters to be %20
                nonUrl[i] = '%';
                nonUrl[i+1] = '2';
                nonUrl[i+2] = '0';
            }
        }
        printCharArr(nonUrl);
    }

    private static void printCharArr(char[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ' ') {
                System.out.print('`');
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print('\n');
    }
}
