package lab3;

public class App {
    public static void main(String[] args) throws Exception {

    }

    static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (int) Math.floor((low + high) / 2);
            if (array[mid] == target) {
                return mid;
            }

            if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Finds the target in array and returns its position, or returns the position of the
     * closest element
     * @param array
     * @param target
     * @return
     */
    static int findClosestPosition(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (int) Math.floor((low + high) / 2);
            if (array[mid] == target) {
                return mid;
            }

            if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mid;
    }

    /**
     * Adds the given element in the correct position of the given sorted array
     * @param array
     * @param element
     * @return
     */
    static int[] addToArray(int[] array, int element){
        int[] newArray = new int[array.length + 1];
        int position = findClosestPosition(array, element);

        if(element > array[position]){
            position = position + 1;
        }

        newArray[position] = element;

        for(int i=0;i<position;i++){
            newArray[i] = array[i];
        }

        for(int i=(position + 1); i<newArray.length; i++){
            newArray[i] = array[i - 1];
        }

        return newArray;
    }

}
