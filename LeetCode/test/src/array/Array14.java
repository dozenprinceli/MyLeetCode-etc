package array;

/**
 * @author Dozen Lee
 * @date 2024/10/6
 */
public class Array14 {
    public static long minimumTime(int[] time, int totalTrips) {
        int[] clone = time.clone();
        long totalTime = 0L;
        for (int i = 0; i < totalTrips; i++) {
            int minT = 0;
            for (int t = 0; t < clone.length; t++) {
                if (clone[t] < clone[minT]) {
                    minT = t;
                }
            }
            int curTime = clone[minT];
            totalTime += curTime;
            for (int t = 0; t < clone.length; t++) {
                if (t == minT) {
                    clone[t] = time[t];
                } else {
                    clone[t] -= curTime;
                }
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(new int[]{5, 10, 10}, 9));
    }
}
