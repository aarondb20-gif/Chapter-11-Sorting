import java.io.IOException;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Sorts.initValues();

        //Sorts.selectionSort();
        //System.out.println("Selection sort called.\n");
        //Sorts.printValues();
        //System.out.println("Values is sorted: " + Sorts.isSorted());
        //System.out.println(System.currentTimeMillis() + " ms");

        Sorts.mergeSort(0,Sorts.values.length - 1);
        System.out.println("Merge sort called.\n");
        Sorts.printValues();
        System.out.println("Values is sorted: " + Sorts.isSorted());
        System.out.println(System.currentTimeMillis() + " ms");


    }
}
