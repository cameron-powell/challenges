public class CTCI1_6 {

    public static void main(String[] args) {
        char[] cArr = {'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'a', 'a', 'a'};

        StringBuilder newString = new StringBuilder();

        char prev = cArr[0];
        char prevCount = 1;
        for(int i=1; i<cArr.length; i++) {
            if(cArr[i] == prev) {
                prevCount++;
            } else {
                newString.append(""+prev+""+Integer.toString(prevCount));
                prev=cArr[i];
                prevCount=1;
            }
        }
        newString.append(""+prev+""+Integer.toString(prevCount));
        System.out.println((newString.length() < cArr.length) ? newString : cArr);
    }
}
