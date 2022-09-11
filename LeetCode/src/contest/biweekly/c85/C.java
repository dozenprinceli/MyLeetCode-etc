package contest.biweekly.c85;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 22:29
 */
public class C {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] moves = new int[s.length()];
        char[] arr = s.toCharArray();
        for (int[] move : shifts) {
            int left = move[0];
            int right = move[1];
            int step = (move[2] == 1) ? 1 : -1;
            for (int i = left; i <= right; i++) {
                moves[i] += step;
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] != 0) {
                char cur = arr[i];
                arr[i] = ((char) (((int) cur - 97 + 260000000 + moves[i]) % 26 + 97));
            }
        }
        return String.valueOf(arr);
    }
}
