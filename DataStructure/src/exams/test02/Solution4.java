package exams.test02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 17:02
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int res = 0;
        Arrays.sort(arr);
        int right = arr.length - 1;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > 0) {
                break;
            }
            for (int j = i + 1; j < right; j++) {
                if (arr[i] + arr[j] > 0) {
                    break;
                }
                int i1 = arr[i] - 3 * arr[j];
                while (i1 + arr[right] > 0) {
                    right--;
                }
                if (i1 + arr[right] == 0) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
