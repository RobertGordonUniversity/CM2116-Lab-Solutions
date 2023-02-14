package lab4;

public class App {
    public static void main(String[] args) {
        
    }

    /* Fibonacci tasks */

    static int fibonacci(int n) {
        if (n <= 2) {
            return n - 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int iterativeFib(int n) {
        if (n <= 2) {
            return n - 1;
        }

        int result = 0, oneBack = 1, twoBack = 0;

        for (int i = 1; i < n - 1; i++) {
            result = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = result;
        }
        return result;
    }

    /* QuickSort and MergeSort tasks */

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        array[high] = array[i];
        array[i] = pivot;
        return i;
    }

    static void mergeSort(int[] array, int n) {
        if (n >= 2) {
            int mid = (int) Math.floor(n / 2);
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            for (int i = mid; i < n; i++) {
                right[i - mid] = array[i];
            }

            mergeSort(left, mid);
            mergeSort(right, n - mid);
            merge(array, left, right);
        }
    }

    static void merge(int[] array1, int[] array2, int[] array3) {
        int i = 0, j = 0, k = 0;

        while (j < array2.length && k < array3.length) {
            if (array2[j] <= array3[k]) {
                array1[i] = array2[j];
                j++;
            } else {
                array1[i] = array3[k];
                k++;
            }
            i++;
        }

        while (j < array2.length) {
            array1[i] = array2[j];
            i++;
            j++;
        }

        while (k < array3.length) {
            array1[i] = array3[k];
            i++;
            k++;
        }
    }

    /*
     * Don't edit these methods - they exist as wrappers for quickSort and mergeSort
     * to avoid needing to pass in
     * high and low values on first call
     */
    static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    static void mergeSort(int[] array) {
        mergeSort(array, array.length);
    }


    /* Recursive Power Algorithm task */
    
    static int power(int b, int n){
        if(n == 0){
            return 1;
        }

        int result = 0;

        if(n % 2 == 0){
            result = power(b, n/2);
            result = result * result;
        }else{
            result = power(b, (n-1)/2);
            result = b * result * result;
        }

        return result;
    }
}
