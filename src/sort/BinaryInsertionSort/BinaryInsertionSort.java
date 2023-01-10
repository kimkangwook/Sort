package sort.BinaryInsertionSort;

public class BinaryInsertionSort {

    public static void binaryInsertionSort(int[] a) {
        binaryInsertionSortOriginal(a, a.length);
    }

    private static void binaryInsertionSortOriginal(int[] a, int size) {
        int target;
        for (int i=1;i<size;i++) {
            // 타겟 넘버
            target = a[i];
            // 이분탐색을 통해 target이 들어가야할 위치를 얻음
            int location = binarySearch(a, target, 0, i);

            int j=i-1;

            while(j>=location) {
                a[j + 1] = a[j];
                j--;
            }
            a[location]= target;

        }
    }

    private static void binaryInsertionSort(int[] a, int size) {
        int target;
        for (int i=1;i<size;i++) {
            // 타겟 넘버
            target = a[i];
            if (target<a[i-1]) {
                // 이분탐색을 통해 target이 들어가야할 위치를 얻음
                int location = binarySearch(a, target, 0, i-1);

                int j=i-1;

                while(j>=location) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[location]= target;

            }
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



}
