/**
 * MergeSort sorts arrays in ascending order.
 * Time complexity: O(n logn)
 * Space complexity: O(n) because of the temp array
 */
public class MergeSort {

    public static void main(String[] args) {
        new MergeSort();
    }

    public MergeSort() {
        int[] unsorted = {7, 3, 2, 6, 1, 4, 5};
        int[] sorted = new int[7];
        System.arraycopy(unsorted, 0, sorted, 0, sorted.length);

        mergeSort(sorted, 0, sorted.length, new int[sorted.length]);
        for(int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Sorts arr[l..r-1]. Modifies tmp.
     * 
     * @param arr array to sort
     * @param l left bound
     * @param r right bound, r >= l
     * @param tmp temp array to be modified, length >= a.length
     */
    void mergeSort(int[] arr, int l, int r, int[] tmp) {
        if(l == r - 1) return; // base case
        int m = (l + r) / 2;
        mergeSort(arr, l, m, tmp);
        mergeSort(arr, m, r, tmp);
        merge(arr, l, m, r, tmp);
    }

    void merge(int[] arr, int l, int m, int r, int[] tmp) {
        int i = l;
        int j = m;
        int k = l;

        while(i < m && j < r) {
            tmp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
        }
        // source, source position, destination, destination position, length
        System.arraycopy(arr, i, tmp, k, m - i);
        System.arraycopy(tmp, l, arr, l, j - l);
    }

}