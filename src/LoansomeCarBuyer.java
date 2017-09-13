import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LoansomeCarBuyer {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = in.readLine()) != null) {
            String[] splitLine = line.split(" ");
            int duration = new Integer(splitLine[0]);
            double downPayment = Double.parseDouble(splitLine[1]);
            double loanAmount = Double.parseDouble(splitLine[2]);
            int numDepRecords = new Integer(splitLine[3]);
            double[] depreciations = new double[110];
            for(int i=0; i<110; i++) {
                depreciations[i] = -1;
            }

            if(duration < 0) break;

            for(int i=0; i<numDepRecords; i++) {
                String[] depRecord = in.readLine().split(" ");
                depreciations[Integer.parseInt(depRecord[0])] = Double.parseDouble(depRecord[1]);
            }

            for(int i=0; i<110; i++) {
                if(depreciations[i] < 0) {
                    depreciations[i] = depreciations[i-1];
                }
            }

            double car = (loanAmount + downPayment) * (1.0 - depreciations[0]);
            if(loanAmount < car) System.out.println("0 months");
            else simulation(1, car, loanAmount, loanAmount / duration, depreciations);
        }
    }

    public static void simulation(int month, double car, double loan, double payment, double[] dep) {
        loan -= payment;
        car -= dep[month] * car;

        if(loan < car) {
            System.out.println( (month == 1) ? "1 month" : ""+month+" months" );
            return;
        }

        simulation(month+1, car, loan, payment, dep);
    }
}
