package math;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/9/4 17:12
 */
public class Math05 {
    @Test
    public void testBigPow() {
        BigInteger x = new BigInteger("123456789");
        System.out.println(x.pow(565));
    }

    @Test
    public void testString() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(new String());
    }

    @Test
    public void testMod() {
        int a = 932;
        int b = 200;
    }
}
