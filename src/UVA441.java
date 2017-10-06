import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class UVA441 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean first = true;
        while(!(line = in.readLine()).equals("0")) {
            if(!first) {
                System.out.println();
            } else {
                first = false;
            }
            String[] set = line.split(" ");
            int k = Integer.parseInt(set[0]);

            for(int a=0; a<k-5; a++) {
                for(int b=a+1; b<k-4; b++) {
                    for(int c=b+1; c<k-3; c++) {
                        for(int d=c+1; d<k-2; d++) {
                            for(int e=d+1; e<k-1; e++) {
                                for(int f=e+1; f<k; f++) {
                                    System.out.format(""+set[a+1]+" "+set[b+1]+" "+set[c+1]+" "+set[d+1]+" "+set[e+1]+" "+set[f+1]+"%n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
