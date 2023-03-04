package Laborator1;
import java.util.Arrays;

public class Lab1_homework {

    static void latinSquare(int n) {
        long startTime = System.nanoTime();
        int[][] square = new int[n][n];


        for (int i = 0; i < n; i++) {
            int p = 1;

            for (int j = i; j < n; j++) {
                square[i][j] = p;
                p++;
            }
            int copie = n;
            for (int k = i; k >= 0; k--) {
                square[i][k] = copie;
                copie--;
            }
        }

        if (n >= 30000) {
            long elapsedTime = System.nanoTime() - startTime; ///endtime-starttime
            System.out.println("Time of execution in nanoseconds : " + elapsedTime );


        } else {
            System.out.println(Arrays.deepToString(square));
            ///System.out.println(Arrays.deepToString(square).replaceAll("],", System.lineSeparator()).replaceAll(",", "").replaceAll("\\["," ").replaceAll("]",""));

        }
    }


    public static void main(String[] args){
        if(args.length>0){
            int n = Integer.parseInt(args[0]);
            System.out.println("n=" + n);
            latinSquare(n);
        }

    }
}
