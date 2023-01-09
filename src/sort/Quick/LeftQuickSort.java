package sort.Quick;

public class LeftQuickSort implements QuickSort{

    @Override
    public void sort(int[] a) {
        pivot_sort(a, 0, a.length - 1);
    }

    /**
     * @param a  정렬할 배열
     * @param lo 현재 부분배열의 왼쪽
     * @param hi 현재 부분배열의 오른쪽
     */
    @Override
    public void pivot_sort(int[] a, int lo, int hi) {
        // lo가 hi보다 크거나 같다면 정렬할 원소가 1개 이하이므로 정렬하지 않고 return함
        if(lo>=hi) {
            return;
        }

        // 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로 만들어 준 뒤,
        // 최종적으로 pivot의 위치를 얻음
        // 해당 pivot을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어 분할 정복을 해줌


        int pivot = partition(a, lo, hi);
        pivot_sort(a, lo, pivot-1);
        pivot_sort(a, pivot+1, hi);
    }

    /**
     * @param a        정렬할 배열
     * @param left     현재 배열의 가장 왼쪽 부분
     * @param right    현재 배열의 가장 오른쪽 부분
     * @return         최종적으로 위치한 피벗의 위치(lo)를 반환
     */
    @Override
    public int partition(int[] a, int left, int right) {

        int lo = left;
        int hi = right;
        int pivot = a[left]; // 부분리스트의 왼쪽 요소를 피벗으로 설정

        // lo가 hi보다 작을 때 까지만 반복함
        while(lo<hi) {


            while(a[hi]>pivot && lo<hi) {
                hi--;
            }

            while(a[lo]<=pivot && lo<hi) {
                lo++;
            }

            swap(a, lo, hi);
        }

        swap(a, left, lo);

        return lo;

    }

    @Override
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
