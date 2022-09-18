package biweekly.c85;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 22:29
 */
public class B {
    public int secondsToRemoveOccurrences(String s) {
        char[] arr = s.toCharArray();
        int time = 0;
        boolean has01 = true;
        while (has01) {
            has01 = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == '0' && arr[i + 1] == '1') {
                    arr[i] = '1';
                    arr[i + 1] = '0';
                    has01 = true;
                    i++;
                }
            }
            if (has01) {
                time++;
            }
        }
        return time;
    }
}
