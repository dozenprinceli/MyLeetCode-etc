package weekly.c310;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dozen Lee<br/>
 * 2022/9/11 10:29
 */
public class B {
    public int partitionString(String s) {
        int ans = 1;
        Map<Character, Boolean> charAppears = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charAppears.containsKey(c)) {
                ans++;
                charAppears.clear();
            }
            charAppears.put(c, true);
        }
        return ans;
    }
}
