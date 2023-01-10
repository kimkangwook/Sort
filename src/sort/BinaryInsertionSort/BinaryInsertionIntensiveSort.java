package sort.BinaryInsertionSort;

public class BinaryInsertionIntensiveSort {


    public static void binaryInsertionSort(int[] a) {
        if(a.length < 2) {
            return;
        }
        int incLength = getAscending(a, 0, a.length);
        binaryInsertionSort(a, 0,a.length, incLength);
    }

    private static void binaryInsertionSort(int[] a, int lo, int hi, int start) {

        if (lo==start) {
            start++;
        }

        for(;start<hi;start++) {
            int target = a[start];
            int loc = binarySearch(a, target, lo, start);
            int j = start-1;

            while (j>=loc) {
                a[j + 1] = a[j];
                j--;
            }

            a[loc]=target;
        }
    }



    static int binarySearch(int[] a, int key, int lo, int hi) {
        int mid;
        while (lo<hi) {
            mid=(lo+hi)/2;          // 중간 위치

            if(key<a[mid]) {        // key < a[mid]라면 탐색 상한선을 중간 위치로 변경
                hi=mid;
            } else {
                lo=mid+1;           // key <= a[mid]라면 탐색 하한선을 중간 다음 위치로 변경
            }
        }
        return lo;
    }

    static int getAscending(int[] a, int lo, int hi) {

        int limit = lo+1;
        if (limit==hi) {
            return 1;
        }

        if(a[lo]<=a[limit]) {
            while(limit<hi && a[limit-1]<=a[limit]) {
                limit++;
            }
        } else {
            while(limit<hi&&a[limit-1]>a[limit]) {
                limit++;
            }
            reversing(a, lo, limit);
        }

        return limit-lo;
    }

    private static void reversing(int[] a, int lo, int hi) {
        hi--;
        while(lo<hi) {
            int temp = a[lo];
            a[lo] = a[hi];
            a[hi]=temp;
            lo++;
            hi--;
        }
    }
}
