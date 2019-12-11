public class QuickSort {

    public static void main(String[] args) {
        new QuickSort();
    }

    public QuickSort() {
        int[] unsorted = {7, 3, 2, 6, 1, 5, 4};
        int[] sorted = new int[7];
        System.arraycopy(unsorted, 0, sorted, 0, sorted.length);

        quickSort(sorted, 0, sorted.length - 1);
        for(int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void quickSort(int[] arr, int start, int end) {
        if(start >= end) return; // base condition
        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex, end);
    }

    int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for(int i = start; i <= end - 1; i++) {
            if(arr[i] < pivot) {
                // swap A[i] and A[pIndex]
                int tmp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = tmp;
                pIndex++;
            }
        }
        // swap A[pIndex] and A[end] (A[end] is the pivot)
        int tmp = arr[pIndex];
        arr[pIndex] = arr[end];
        arr[end] = tmp;
        return pIndex;
    }


}
