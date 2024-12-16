import java.util.Arrays;

public class main {
    public static void main(String[] args){
        int[] arr = {123, 34, -23, 900, 190, 4};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
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
        for (int i = 0; i < arr.length; i++) {
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
        // loop through entire array
        for (int i = 0; i < arr.length; i++) {
            // loop backwards from i to find
            // where to insert the element at i
            for (int j = i; j > 0; j--) {
                // place element at i after element smaller than it
                // and before element greater than it
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
