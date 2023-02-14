package lab1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

    }

    static int algorithm1(int n) {
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total = total * i;
        }
        return total;
    }

    static Map<Character, Integer> algorithm2(String s) {
        Map<Character, Integer> result = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (result.get(c) == null) {
                result.put(c, 1);
            } else {
                result.put(c, result.get(c) + 1);
            }
        }
        return result;
    }

    static int[] algorithm3(int limit) {
        int[] result = new int[limit];

        if (limit == 0) {
            return result;
        }

        result[0] = 1;

        if (limit == 1) {
            return result;
        }

        result[1] = 1;

        for (int i = 2; i < limit; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    /** Task 1 algorithms below */

    /**
     * Problem 1 - find the largest number in a list
     * 
     * @param l
     * @return
     */
    static int largest(List<Integer> l) {
        int max = l.get(0);

        for (int i : l) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    /**
     * Problem 2 - counting even numbers in a list
     * 
     * @param l
     * @return
     */
    static int even(List<Integer> l) {
        int count = 0;

        for (int i : l) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    /**
     * Problem 3a - find the class average grade
     * 
     * @param l
     * @return
     */
    static double average(List<Integer> l) {
        double result = 0;

        for (int g : l) {
            result = result + g;
        }

        return result / l.size();
    }

    /**
     * Problem 3b - find the class grade distribution
     * 
     * @param l
     * @return
     */
    static int[] distribution(List<Integer> l) {
        int max = largest(l); // use the largest algorithm for this
        int result[] = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            result[i] = 0;
        }

        for (int g : l) {
            result[g]++;
        }

        return result;
    }

    /**
     * @param input
     * @return
     */
    static String pigLatin(String s) {
        String append = "";
        char[] vowels = { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };
        Arrays.sort(vowels); // we need to sort to make sure the binary search works

        for (char c : s.toCharArray()) {
            if (Arrays.binarySearch(vowels, c) >= 0) {
                append = append + "ay";
                break;
            } else {
                s = s.substring(1);
                append = append + c;
            }
        }
        s = s + append;

        return s;
    }
}
