package sort;

public class MergeSort {

    private static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void merge_sort1(int[] a) {
        sorted = new int[a.length];
        merge_sortTopDown(a, 0, a.length - 1);
        sorted = null;
    }
    public static void merge_sort2(int[] a) {
        sorted = new int[a.length];
        merge_sortBottomUp(a, 0, a.length - 1);
        sorted = null;
    }


    //Top-Down 형식
    private static void merge_sortTopDown(int[] a, int left, int right) {
        //left==right 즉, 부분리스트가 1개의 원소만 갖는 경우
        //더이상 쪼갤 수 없으므로 return함
        if(left==right) return;

        int mid = (left + right) / 2;           // 절반 위치

        merge_sortTopDown(a, left, mid);               // 절반 중 왼쪽 부분 리스트(left~mid)
        merge_sortTopDown(a, mid + 1, right);      // 절반 중 오른쪽 부분 리스트(mid+1~right)

        merge(a, left, mid, right);             // 병합작업
    }

    private static void merge_sortBottomUp(int[] a, int left, int right) {

        // 1부터 서브리스트를 나누는 기준을 두 배씩 늘림
        for (int size=1;size<=right;size+=size) {

            // 두 부분리스트를 순서대로 병합해줌
            // 예로들어 현재 부분리스트의 크기가 1(size=1)일 때
            // 왼쪽 부분리스트(low~mid)와 오른쪽 부분리스트(mid+1~high)를 생각하면
            // 왼쪽 부분리스트는 low = mid = 0 이고,
            // 오른쪽 부분리스트는 mid+1부터 low+(2*size)-1=1이 됨

            // 이 때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이 병합되도록 해야함
            for(int l=0;l<=right-size;l+=(2*size)) {
                int low = l;
                int mid = l+size-1;
                int high = Math.min(l + (2 * size) - 1, right);
                merge(a, low, mid, high);       // 병합작업
            }
        }
    }


    // 부분리스트는 a배열의 left ~ right 까지임

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;       // 왼쪽 부분리스트 시작점
        int r = mid+1;      // 오른쪽 부분리스트 시작점
        int idx = left;     // 채워넣을 배열의 인덱스

        while(l<=mid && r<=right) {

            // 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
            // 왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킴
            if(a[l]<=a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        // 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l>mid)
        // 오른쪽 부분리스트 원소가 아직 남아있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워줌
        if(l>mid) {
            while(r<=right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        // 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r>right)
        // 왼쪽 부분리스트 원소가 아직 남아있을 경우
        // 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워줌
        else {
            while(l<=mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨줌
        for(int i=left;i<=right;i++) {
            a[i] = sorted[i];
        }
    }
}
