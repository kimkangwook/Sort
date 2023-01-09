import sort.HeapSort;
import sort.MergeSort;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 6, 3, 31, 25, 8, 9, 7, 3, 2,48,22,2,1,3,5,1};
        int[] arr2 = new int[]{1, 5, 6, 3, 31, 25, 8, 9, 7, 3, 2,48,22,2,1,3,5,1};
        long a = System.nanoTime();
        MergeSort.merge_sort1(arr1);
        long b = System.nanoTime();
        long c = System.nanoTime();
        HeapSort.heapsort2(arr2);
        MergeSort.merge_sort2(arr2);
        long d = System.nanoTime();

        for(int e : arr1) {
            System.out.println(e);
        }
        for(int f : arr2) {
            System.out.println(f);
        }

        System.out.println((long)(b-a));
        System.out.println((long)(d-c));

    }
}
