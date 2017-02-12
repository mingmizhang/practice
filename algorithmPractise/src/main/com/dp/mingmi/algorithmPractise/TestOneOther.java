package main.com.dp.mingmi.algorithmPractise;

/**
 * Created by zhangmingmi on 16/12/1.
 */
public class TestOneOther {

    public static void main(String[] args) {
        //int a = Integer.valueOf(args[0]);
        //int b = Integer.valueOf(args[1]);
        int a = 2;
        int b = 8;
        //int c = -2;
        StringBuffer aB = new StringBuffer(Integer.toBinaryString(a));
        StringBuffer bB = new StringBuffer(Integer.toBinaryString(b));
        //StringBuffer cB= new StringBuffer(Integer.toBinaryString(c));
        StringBuffer aBinary = aB.reverse();
        StringBuffer bBinary = bB.reverse();
        if (aB.length() < bB.length()) {
            for (int i = Math.min(aB.length(), bB.length()) + 1; i <= Math.max(aB.length(), bB.length()); i++) {
                aBinary.append('0');
            }
        } else if (aB.length() > bB.length()) {
            for (int i = Math.min(aB.length(), bB.length()) + 1; i <= Math.max(aB.length(), bB.length()); i++) {
                bBinary.append('0');
            }
        }
        //StringBuffer computeValue = new StringBuffer();
        char[] computeValue = new char[32];
        String value;
        int flag[] = new int[33];
        StringBuffer str = new StringBuffer();
        int number = Math.max(aBinary.length(), bBinary.length());

        for (int i = 0; i < number; i++) {
            if (String.valueOf(Integer.valueOf(aBinary.substring(i, i + 1)) & Integer.valueOf(bBinary.substring(i, i + 1))).equals("1")) {
                if (flag[i] == 1) {
                    computeValue[i] = '1';
                    flag[i + 1] = 1;

                } else {
                    computeValue[i] = '0';
                    flag[i + 1] = 1;
                }

            } else {
                value = String.valueOf(Integer.valueOf(aBinary.substring(i, i + 1)) | Integer.valueOf(bBinary.substring(i, i + 1)));
                if (flag[i] == 1) {
                    if (value.equals("1")) {
                        computeValue[i] = '0';
                        flag[i + 1] = 1;

                    } else {
                        computeValue[i] = value.toCharArray()[0];
                        flag[i + 1] = 0;
                    }

                } else {
                    computeValue[i] = value.toCharArray()[0];
                    flag[i + 1] = 0;
                }
            }
        }
        if (flag[number] == 1) {
            str.append('1');
        }
        for (int i = number - 1; i >= 0; i--) {
            str.append(computeValue[i]);
        }
        int result = Integer.valueOf(str.toString(), 2);
        System.out.println(result);
        System.out.println(str);

    }
}
