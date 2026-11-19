import java.util.*;
import java.text.DecimalFormat;

public class Sorts {
    static final int SIZE = 50;
    static int[] values = new int[SIZE];
    static int[] tempArray = new int[SIZE];
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
                System.out.print(fmt.format(value) + " ");
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
    //Selection sort uses minIndex and swap
    static void selectionSort() {
        int endIndex = SIZE - 1;
        for (int current = 0; current < endIndex; current++)
            swap(current, minIndex(current, endIndex));
    }
    //Sorts values[leftFirst] to values[rightLast] by merging the two subarrays
    static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast){
        int index = leftFirst;
        int saveFirst = leftFirst; //to remember where to copy back
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if (values[leftFirst] < values[rightFirst]){
                tempArray[index] = values[leftFirst];
                leftFirst++;
            }else{
                tempArray[index] = values[rightFirst];
                rightFirst++;
            }
            index++;
        }
        //copy remaining elements from left half
        while (leftFirst <= leftLast){
            tempArray[index] = values[leftFirst];
            leftFirst++;
            index++;
        }
        //copy remaining elements from right half
        while (rightFirst <= rightLast){
            tempArray[index] = values[rightFirst];
            rightFirst++;
            index++;
        }
        for (index = saveFirst; index <= rightLast; index++)
            values[index] = tempArray[index];
    }
    //mergeSort algorithm uses merge method
    static void mergeSort(int first, int last){
        if (first < last){
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }



}
