package biweekly.c87;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/9/17 22:29
 */
public class B {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p1 = 0, p2 = 0;
        int ans = 0;
        while (p1 < players.length && p2 < trainers.length) {
            if (players[p1] <= trainers[p2]) {
                ans++;
                p1++;
            }
            p2++;
        }
        return ans;
    }
}
