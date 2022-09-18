package biweekly.c85;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 22:28
 */
public class A {
    public int minimumRecolors(String blocks, int k) {
        int min = 0;
        int last = 0;
        char[] arr = blocks.toCharArray();
        for (int i = 0; i < arr.length - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    if (arr[j] == 'W') {
                        min++;
                    }
                }
                last = min;
            } else {
                if (arr[i - 1] == 'W') {
                    last--;
                }
                if (arr[i + k - 1] == 'W') {
                    last++;
                }
                min = Math.min(min, last);
            }
        }
        return min;
    }
}
