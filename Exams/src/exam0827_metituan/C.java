package exam0827_metituan;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 15:49
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        String s = scan.next();
        int[] lens = new int[m];
        for (int i = 0; i < m; i++) {
            lens[i] = scan.nextInt();
        }
        List<String> cuts = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            cuts.add(scan.next());
        }
        cuts.sort(Comparator.comparingInt(String::length));
        System.out.println(getMatches(cuts, s));
    }

    private static int getMatches(List<String> cuts, String s) {
        if (cuts.size() == 1) {
            if (cuts.get(0).equals(s)) {
                return 1;
            } else {
                return 0;
            }
        }

        int cnt = 0;
        int curLen = 0;
        for (int i = 0; i < cuts.size(); i++) {
            String cut = cuts.get(i);
            if (s.startsWith(cut) && cut.length() != curLen) {
                String newS = s.substring(cut.length());
                List<String> newCuts = new ArrayList<>();
                for (int j = 0; j < cuts.size(); j++) {
                    if (j != i) {
                        newCuts.add(cuts.get(j));
                    }
                }
                curLen = cut.length();
                cnt += getMatches(newCuts, newS);
            }
        }
        return cnt;
    }
}
