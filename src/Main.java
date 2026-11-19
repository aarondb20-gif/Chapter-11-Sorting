import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Sorts.initValues();
        Sorts.printValues();
        System.out.println("Values is sorted: " + Sorts.isSorted());
        System.out.println();
    }
}
