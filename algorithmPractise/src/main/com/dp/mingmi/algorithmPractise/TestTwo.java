package main.com.dp.mingmi.algorithmPractise;

import java.math.BigInteger;

/**
 * Created by zhangmingmi on 16/12/2.
 */
public class TestTwo {
    public static void main(String []args){
        System.out.println(computeNumOfZero(105));

    }
    public static long computeNumOfZero(long n){
        //long sum =1;
        BigInteger sum = new BigInteger("1");
        BigInteger mod = new BigInteger("0");
        long number=0;
        for(int i =1;i<=n;i++){
            //sum=sum*i;
            BigInteger tmp = new BigInteger(String.valueOf(i));
            sum=sum.multiply(tmp);
        }
        while(!sum.equals(BigInteger.ZERO)){
            //mod=sum%10;
            BigInteger tmp =new BigInteger("10");
            mod=sum.mod(tmp);
            if(mod.equals(BigInteger.ZERO)){
                number++;
                sum=sum.divide(tmp);
            }else{
                break;
            }
        }
        return number;

    }
}
