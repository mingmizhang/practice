package main.com.dp.mingmi.algorithmPractise;

/**
 * Created by zhangmingmi on 16/12/1.
 */
public class TestOne {
    //private static final Logger logger = LoggerFactory.getLogger(TestOne.class);

    public static void main(String[] args) {
        //int a = Integer.valueOf(args[0]);
        //int b = Integer.valueOf(args[1]);
        int a = 2;
        int b = 7;
        String aB = Integer.toBinaryString(a);
        String aBinary = new StringBuffer(aB).reverse().toString();
        String bB = Integer.toBinaryString(b);
        String bBinary = new StringBuffer(bB).reverse().toString();
        //StringBuffer computeValue = new StringBuffer();
        char[] computeValue = new char[32];
        String value;
        int flag = 0;
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < Math.min(aBinary.length(), bBinary.length()); i++) {
            if (String.valueOf(Integer.valueOf(aBinary.substring(i, i + 1)) & Integer.valueOf(bBinary.substring(i, i + 1))).equals("1")) {
                if (flag == 1) {
                    computeValue[i] = '1';
                    flag = 1;

                } else {
                    computeValue[i] = '0';
                    flag = 1;
                }

            } else {
//                value = String.valueOf(Integer.valueOf(aBinary.substring(i, i + 1)) | Integer.valueOf(bBinary.substring(i, i + 1)) | flag);
//                computeValue[i] = value.toCharArray()[0];
//                flag = 0;
                value = String.valueOf(Integer.valueOf(aBinary.substring(i, i + 1)) | Integer.valueOf(bBinary.substring(i, i + 1)));
                if (flag == 1) {
                    if (value.equals("1")) {
                        computeValue[i] = '0';
                        flag = 1;

                    } else {
                        computeValue[i] = value.toCharArray()[0];
                        flag = 0;
                    }

                } else {
                    computeValue[i] = value.toCharArray()[0];
                    flag = 0;
                }
            }
        }
        if (aBinary.length() != bBinary.length()) {
            for (int i = Math.min(aBinary.length(), bBinary.length()); i < Math.max(aBinary.length(), bBinary.length()); i++) {
                if (aBinary.length() < bBinary.length()) {
                    if ((Integer.valueOf(bBinary.substring(i, i + 1)) & flag) == 1) {
                        computeValue[i] = '0';
                        flag = 1;
                    } else {
                        if (flag == 1) {
                            computeValue[i] = '1';
                            flag = 0;

                        } else {
                            computeValue[i] = bBinary.substring(i, i + 1).toCharArray()[0];
                            flag = 0;
                        }
                    }
                } else {
                    if ((Integer.valueOf(aBinary.substring(i, i + 1)) & flag) == 1) {
                        computeValue[i] = '0';
                        flag = 1;
                    } else {
                        if (flag == 1) {
                            computeValue[i] = '1';
                            flag = 0;

                        } else {
                            computeValue[i] = aBinary.substring(i, i + 1).toCharArray()[0];
                            flag = 0;
                        }

                    }
                }
            }
        }
        int number = Math.max(aBinary.length(), bBinary.length());
        if (flag == 1) {
            str.append('1');

        }
        for (int i = number - 1; i >= 0; i--) {
            str.append(computeValue[i]);
        }
        //logger.info("The compute info of string is:", computeValue);
        //logger.info("The compute value of int is: ", Integer.valueOf(computeValue.toString()));
        System.out.println(Integer.valueOf(str.toString(), 2));


    }
}
