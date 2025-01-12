import java.util.Arrays;

public class main {
    public static void main(String[] args){
        int[] arr = {8, 2, 6, 4, 9, 1,7,54,3,2,54,76,5,3,5,22,2,1,4,6};
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    /**
     * in bubble sort, adjacent elements are compared and swapped according to the order specified
     * if it is ascending order, adjacent elements are compared and the element with the greater value is moved to the right
     * called bubble sort because elements move to the end of the array in the intended order, like water bubbles rise to the surface
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int size = arr.length;

        // loop through entire array
        for (int i = 0; i < size - 1; i++) {
            // loop until end of unsorted elements
            for (int j = 0; j < size - i - 1; j++) {
                // swap left and right elements if left is greater
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * We can optimize the bubble sort by breaking when there is no sorting to do, ie when the array is already sorted
     * @param arr
     */
    public static void bubbleSortOptimised(int[] arr){
        int size = arr.length;

        // loop through entire array
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false; // track swapping

            // loop until end of unsorted elements
            for (int j = 0; j < size - i - 1; j++) {
                // swap left and right elements if left is greater
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }

            // if there was no swap, then the array is already sorted
            if(!swapped) break;
        }
    }

    /**
     * in selection sort, on each iteration the element with the least value is *selected*, and placed at the current start of the iteration
     * this is done continuously on each iteration until all elements are in the specified order
     * @param arr
     */
    public static void selectionSort(int[] arr){
        // loop through entire array
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i; // set the current index as the minimum

            // loop through the unsorted elements
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }

            // place the minimum element at the current index
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * in insertion sort, we interate through the array and each element is compared all the previous elements,
     * then *inserted* at its rightful position according to the order specified
     * @param arr
     */
    public static void insertionSort(int[] arr){
        // loop through array starting from second element
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // set element at i as key

            // loop backwards through sorted elements to find
            // where to insert the key element
            int j = i-1;

            while (j >= 0 && key < arr[j]) {
                // move element greater than key to the right
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    static void merge (int arr[], int start, int mid, int end){
        // create backups of two subarrays
        int[] left = new int[(mid - start) + 1];
        int[] right = new int[end - mid];

        // copy values into left array
        for(int i = 0; i < left.length; i++){
            left[i] = arr[i+start];
        }

        // copy values into right array
        for(int i = 0; i < right.length; i++){
            right[i] = arr[i+mid+1];
        }

        // set the values from start to end in sorted order, as long
        // as there are still elements in both the left and right subarrays
        int j = start, lIndex = 0, rIndex = 0; // we will maintain for the left and right subarrays, and the main array

        while(lIndex < left.length && rIndex < right.length){
            if(left[lIndex] <= right[rIndex]){
                arr[j] = left[lIndex];
                lIndex++;
            }else {
                arr[j] = right[rIndex];
                rIndex++;
            }

            j++;
        }

        // add leftover values from left subarray if any// create backups of two subarrays
        while (lIndex < left.length) {
            arr[j] = left[lIndex];
            lIndex++;
            j++;
        }

        // add leftover values from right subarray if any// create backups of two subarrays
        while (rIndex < right.length) {
            arr[j] = right[rIndex];
            rIndex++;
            j++;
        }
    }

    /**
     * In merge sort, the provided array is recursively divided into two halves, and each half is sorted.
     * Each sorted half is then combined to give a sorted list.
     * @param arr the unsorted array
     * @param start the position to start sorting from
     * @param end the end position of the sorting
     */
    static void mergeSort(int arr[], int start, int end){
        // base condition; will execute only if start is less than end,
        // i.e. there's more than element in the array/subarray
        if(start < end){
            // find the midpoint of the array
            int mid = (start + end) / 2;

            // divide further since we have not reached the base case
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            // merge the two sorted sections
            merge(arr, start, mid, end);
        }
    }
}
