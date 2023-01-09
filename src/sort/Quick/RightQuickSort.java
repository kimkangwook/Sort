package sort.Quick;

public class RightQuickSort implements QuickSort{
    // leftQuickSort와 파티셔닝 부등호와 pivot와 hi가 교환하는 것 빼고 방법 동일

    @Override
    public void sort(int[] a) {
        pivot_sort(a, 0, a.length - 1);
    }

    @Override
    public void pivot_sort(int[] a, int lo, int hi) {

        if (lo>=hi) {
            return;
        }

        int pivot = partition(a, lo, hi);
        pivot_sort(a, lo,pivot-1);
        pivot_sort(a, pivot+1,hi);
    }

    @Override
    public int partition(int[] a, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = a[right];

        while (lo<hi) {

            while(a[lo]<pivot && lo<hi) {
                lo++;
            }

            while(a[hi]>=pivot && lo<hi) {
                hi--;
            }

            swap(a, lo, hi);

        }

        swap(a,right,hi);
        return hi;
    }

    @Override
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
