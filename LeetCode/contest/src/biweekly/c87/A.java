package biweekly.c87;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/9/17 22:29
 */
public class A {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aam = Integer.parseInt(arriveAlice.substring(0, 2));
        int aad = Integer.parseInt(arriveAlice.substring(3, 5));
        int alm = Integer.parseInt(leaveAlice.substring(0, 2));
        int ald = Integer.parseInt(leaveAlice.substring(3, 5));
        int bam = Integer.parseInt(arriveBob.substring(0, 2));
        int bad = Integer.parseInt(arriveBob.substring(3, 5));
        int blm = Integer.parseInt(leaveBob.substring(0, 2));
        int bld = Integer.parseInt(leaveBob.substring(3, 5));

        Date aa = new Date(aam, aad);
        Date al = new Date(alm, ald);
        Date ba = new Date(bam, bad);
        Date bl = new Date(blm, bld);
        if (aa.before(ba) || aa.equals(ba)) {
            if (al.equals(ba)) {
                return 1;
            } else if (al.before(ba)) {
                return 0;
            } else {
                return bl.before(al) ? ba.getDiff(bl) + 1 : ba.getDiff(al) + 1;
            }
        } else {
            if (bl.equals(aa)) {
                return 1;
            } else if (bl.before(aa)) {
                return 0;
            } else {
                return al.before(bl) ? aa.getDiff(al) + 1 : aa.getDiff(bl) + 1;
            }
        }
    }

    private class Date {
        int month;
        int day;

        public Date(int m, int d) {
            this.month = m;
            this.day = d;
        }

        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean equals(Date other) {
            return month == other.month && day == other.day;
        }

        boolean before(Date other) {
            return month < other.month || (month == other.month && day < other.day);
        }

        boolean after(Date other) {
            return month > other.month || (month == other.month && day > other.day);
        }

        int getDiff(Date end) {
            if (end.month == month) {
                return end.day - day;
            }

            int ans = days[month - 1] - day + end.day;
            for (int i = month; i < end.month - 1; i++) {
                ans += days[i];
            }
            return ans;
        }
    }

    @Test
    public void test() {
        String s1 = "09-01";
        String s2 = "10-19";
        String s3 = "06-19";
        String s4 = "10-20";
        System.out.println(countDaysTogether(s1, s2, s3, s4));
    }
}
