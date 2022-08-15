package bitwise;

/**
 * @author Dozen Lee<br/>
 * 2022/8/15 23:28
 */
public class Bitwise01 {
    public static void main(String[] args) {
//        int i = 0b101101;
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(Integer.toBinaryString(-i));
//        System.out.println(Integer.toBinaryString(i >> 1));
//        System.out.println(new Bitwise01().isPrime(6));
        System.out.println(new Bitwise01().countPrimeSetBits(6, 10));
    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int num = left; num <= right; num++) {
            int digits = 0;
            int cur = num;
            while (cur != 0) {
                digits += cur & 1;
                cur >>= 1;
            }
            if (isPrime(digits)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        boolean prime = true;
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
