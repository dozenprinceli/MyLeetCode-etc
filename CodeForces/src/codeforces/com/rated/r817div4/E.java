package codeforces.com.rated.r817div4;

import java.util.*;

/**
 * TODO TLE
 * @author Dozen Lee<br/>
 * 2022/8/30 22:21
 */
public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            int q = scan.nextInt();
            List<int[]> rects = new ArrayList<>(n);
            int minH = Integer.MAX_VALUE, minW = Integer.MAX_VALUE;
            int maxH = 0, maxW = 0;
            for (int j = 0; j < n; j++) {
                int hi = scan.nextInt();
                int wi = scan.nextInt();
                maxH = Math.max(maxH, hi);
                maxW = Math.max(maxW, wi);
                minH = Math.min(minH, hi);
                minW = Math.min(minW, wi);
                rects.add(new int[]{hi, wi});
            }
            rects.sort(Comparator.comparingInt(o -> o[0]));
            long total = 0;
            for (int j = 0; j < q; j++) {
                long ans = 0;
                int hs = scan.nextInt();
                int ws = scan.nextInt();
                int hb = scan.nextInt();
                int wb = scan.nextInt();
                if (hs >= maxH || hb <= minH || ws >= maxW || wb <= minW) {
                    System.out.println(0);
                } else if (hs < minH && hb > maxH && ws < minW && wb > maxW) {
                    if (total != 0) {
                        System.out.println(total);
                    } else {
                        for (int[] rect : rects) {
                            total += (long) rect[0] * rect[1];
                        }
                        System.out.println(total);
                    }
                } else {
                    for (int[] rect : rects) {
                        int hi = rect[0];
                        int wi = rect[1];
                        if (hs < hi && hi < hb && ws < wi && wi < wb) {
                            ans += (long) hi * wi;
                        } else if (hi >= hb) {
                            break;
                        }
                    }
                    System.out.println(ans);
                }
            }
        }
    }
    
    private static void insert(List<int[]> rects, int[] rect) {
        int len = rects.size();
        int hi = rect[0];
        if (rects.isEmpty() || rects.get(len - 1)[0] <= hi) {
            rects.add(rect);
            return;
        }
        if (rects.get(0)[0] >= hi) {
            rects.add(0, rect);
            return;
        }
        int left = 0, right = len - 1;
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            if (rects.get(mid)[0] < hi) {
                left = mid;
            } else {
                right = mid;
            }
        }
        rects.add(right, rect);
    }
}
