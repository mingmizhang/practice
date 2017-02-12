package main.com.dp.mingmi.algorithmPractise;

/**
 * Created by zhangmingmi on 16/12/2.
 */
public class TestTwoRight {
    public static void main(String[] args) {
        System.out.println(trailingZeros2(105));

    }

        public static long trailingZeros(long n) {
        long numberIncludesFive = 0;
        long tmp;
        if (n < 5)
            return 0;
        else {
            for (long i = 5; i <= n; i = i + 5) {
                tmp = i;
                while (tmp % 5 == 0) {
                    tmp = tmp / 5;
                    numberIncludesFive++;
                }
            }
            return numberIncludesFive;
        }
    }

    public static long trailingZeros2(long n) {
        long numberIncludesFive = 0;
        long tmp=n/5;
        if (n < 5)
            return 0;
        else {
                while (tmp != 0) {
                    numberIncludesFive=numberIncludesFive+tmp;
                    tmp = tmp / 5;
                }
            }
            return numberIncludesFive;
        }
    }

