import java.util.*;
import java.text.DecimalFormat;

public class Sorts {
    static final int SIZE = 50;
    static int[] values = new int[SIZE];

    static void initValues(){
        //Initializes the values array with random integers 0-1000
        Random rand = new Random();
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 1000;
    }

    static public boolean isSorted(){
        //Returns false if the array values are not sorted, returns true otherwise
        for (int index = 0; index < (SIZE - 1); index++)
            if(values[index] > values[index + 1])
                return false;
        return true;
    }

    static public void swap(int index1, int index2){
        //Swaps the integers at locations index1 and index2 of the values array
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    static public void printValues(){
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("The values array is: ");
        for (int index = 0; index < (SIZE); index++){
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.println(fmt.format(value) + " ");
        }
        System.out.println();
    }



}
