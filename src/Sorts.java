import java.util.*;
import java.text.DecimalFormat;

public class Sorts {
    static final int SIZE = 50;
    static int[] values = new int[SIZE];

    //Initializes the values array with random integers 0-1000
    static void initValues(){
        Random rand = new Random();
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 1000;
    }
    //Returns false if the array values are not sorted, returns true otherwise
    static public boolean isSorted(){
        for (int index = 0; index < (SIZE - 1); index++)
            if(values[index] > values[index + 1])
                return false;
        return true;
    }
    //Swaps the integers at locations index1 and index2 of the values array
    static public void swap(int index1, int index2){
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
    //returns the index of the smallest value
    static int minIndex(int startIndex, int endIndex){
        int indexOfMin = startIndex;
        for(int index = startIndex + 1; index <= endIndex; index++)
            if (values[index] < values[indexOfMin])
                indexOfMin = index;
        return indexOfMin;
    }

    static void selectionSort() {
        int endIndex = SIZE - 1;
        for (int current = 0; current < endIndex; current++)
            swap(current, minIndex(current, endIndex));
    }



}
