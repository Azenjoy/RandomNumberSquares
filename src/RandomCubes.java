import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.IntStream;

public class RandomCubes {

    static int randomnumber;
//    static int[] randomsquares = new int[289];
//    List<Integer> randomsquareslist = new ArrayList<Integer>(Arrays.asList(randomsquares));
static ArrayList<Integer> randomsquares = new ArrayList<Integer>();
    public static int randomnumbermethod() {
        int randomnumber = (int)(Math.random()*10);
        return randomnumber;
    }
    public static void main(String[] args) {
        System.out.println();
        for (int c = 0; c < 10; c++) {
            for (int i = 0; i <= 16; i++) {
                for (int j = 0; j <= 16; j++) {

                    randomnumber = randomnumbermethod();
                    System.out.print(randomnumber + "  ");
                    randomsquares.add(randomnumber);
                }
                System.out.println();
            }
        }
        System.out.println();
        Date date = new Date();
        System.out.println();
        System.out.println("______________________________________________");
        System.out.println("Current Time is : " + date);
        // set format in 12 hours
        SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm aa");
        System.out.println("______________________________________________");
//        for (Iterator itr = randomsquares.iterator(); itr.hasNext(); ) {
//            // Print the elements
//            System.out.print(itr.next() + "  ");
//        }
        System.out.println();
//        System.out.println(randomsquares);
        Collections.sort(randomsquares, Collections.reverseOrder());
//        System.out.println(randomsquares);
        Collections.sort(randomsquares);
//        System.out.println(randomsquares);
        System.out.println("______________________________________________");
        int[] indexInteger = new int[10];
        int counter = 0;
        int temp = 0;
        int prevtemp = 0;
        for (int i = 0; i < randomsquares.size(); i++) {
            temp = randomsquares.get(i);
            if (temp == prevtemp) counter++;
            if (temp != prevtemp) {
                indexInteger[prevtemp] = counter;
                counter = 1;
            prevtemp = temp;
            }
        }
        indexInteger[prevtemp] = counter;
            System.out.println(Arrays.toString(indexInteger));
        System.out.println("______________________________________________");
            for(int i = 0; i<10; i++)System.out.println(i + "    totals:    " + indexInteger[i]);System.out.println();
            int min = Arrays.stream(indexInteger).min().getAsInt();
            int max = Arrays.stream(indexInteger).max().getAsInt();
        System.out.println("______________________________________________");
        System.out.println("total random numbers: "+randomsquares.size());
        System.out.println("______________________________________________");
        System.out.println("min: "+ min);
        System.out.println("max: "+ max);
        System.out.println("______________________________________________");
        int sum = IntStream.of(indexInteger).sum();
        System.out.println("sum: "+ sum);
        System.out.println("______________________________________________");
        int count = (int) IntStream.of(indexInteger).count();
        System.out.println("count: "+ count);
        System.out.println("______________________________________________");
        double average = IntStream.of(indexInteger).average().getAsDouble();
        System.out.println("average: "+average);
        System.out.println("______________________________________________");
        double tempdiffsquaresum = 0;
        for(int i = 0; i<10; i++) {
            double diff = Math.abs(indexInteger[i]-average);
//            double vars = Math.abs(indexInteger[i]-average);
            double tempvars = Math.pow(diff,2);
            tempdiffsquaresum += tempvars;
        }
        double variances = tempdiffsquaresum/10;
        System.out.printf("variance: %7.5f", variances);
        System.out.println();
        System.out.println("______________________________________________");
        double sd = Math.sqrt(variances);
        System.out.printf("standard deviation: %7.5f", sd);
        System.out.println();
        System.out.println("______________________________________________");
        System.out.println();
        System.out.println("____________________________");
    }

}
