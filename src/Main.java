import sort.HeapSort;
import sort.MergeSort;
import sort.Quick.LeftQuickSort;
import sort.Quick.MiddleQuickSort;
import sort.Quick.RightQuickSort;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 6, 3, 31, 25, 8, 9, 7, 3, 2,48,22,2,1,3,5,1};
        int[] arr2 = new int[]{1, 5, 6, 3, 31, 25, 8, 9, 7, 3, 2,48,22,2,1,3,5,1};
        int[] arr3 = new int[]{1, 5, 6, 3, 31, 25, 8, 9, 7, 3, 2,48,22,2,1,3,5,1};
        LeftQuickSort quickLeft = new LeftQuickSort();
        RightQuickSort quickRight = new RightQuickSort();
        MiddleQuickSort quickMiddle = new MiddleQuickSort();
        long a = System.nanoTime();
        quickLeft.sort(arr1);
        long b = System.nanoTime();
        long c = System.nanoTime();
        quickRight.sort(arr2);
        long d = System.nanoTime();
        long g = System.nanoTime();
        quickMiddle.sort(arr3);
        long h = System.nanoTime();

        for(int e : arr1) {
            System.out.println(e);
        }
        for(int f : arr2) {
            System.out.println(f);
        }
        for (int t : arr3) {
            System.out.println(t);
        }

        System.out.println((long)(b-a));
        System.out.println((long)(d-c));
        System.out.println((long)(h-g));

    }
}
