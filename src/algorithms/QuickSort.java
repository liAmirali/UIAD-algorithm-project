package algorithms;

public class QuickSort {

    /**
     * The main function that implements QuickSort
     *
     * @param arr  Array to be sorted
     * @param low  Starting index
     * @param high Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotPoint = partition(arr, low, high);
            quickSort(arr, low, pivotPoint - 1);
            quickSort(arr, pivotPoint + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, low, j); // Swapping the pivot
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
