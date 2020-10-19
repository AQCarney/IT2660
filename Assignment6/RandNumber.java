package Assignment6;

import java.util.Arrays;
import java.util.Random;

public class RandNumber {
    public static void main(String[] args){
        int i;
        Random rnd = new Random();
        int[] rnArray1 = new int[100];
        for (i = 0; i < rnArray1.length; i++){
            int randNumber = rnd.nextInt(100);
            rnArray1[i] = i +1;
            System.out.println(randNumber);
        }
        int [] rnArray = rnArray1.clone();
        for (i = 0; i < rnArray.length; i++){
            rnArray[i] = i +1;
        }
        new MergeSort();
        System.out.println("Merge sort equals " + Arrays.toString(rnArray));
    }
    
}
