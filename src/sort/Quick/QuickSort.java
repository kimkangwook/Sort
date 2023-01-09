package sort.Quick;

public interface QuickSort {
     void sort(int[] a);

    void pivot_sort(int[] a, int lo, int hi);

    int partition(int[] a, int left, int right);

    void swap(int[] a, int i, int j);
}
