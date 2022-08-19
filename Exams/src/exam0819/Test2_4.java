package exam0819;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Dozen Lee<br/>
 * 2022/8/19 17:36
 */
public class Test2_4 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        int testTimes = rand.nextInt(5);
        for (int t = 0; t < testTimes; t++) {
            for (int i = 0; i < 10; i++) {
                arr[i] = rand.nextInt(100);
            }
            sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    static void sort(int[] a) {
        int n = a.length;
        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (a[j - 1] > a[j]) {
                    int t = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

}
