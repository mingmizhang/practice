package main.com.dp.mingmi.algorithmPractise;

/**
 * Created by zhangmingmi on 16/12/2.
 */
public class TestTwoOther {
    public static void main(String []args){
        System.out.println(trailingZeros(105));

    }

    public static long trailingZeros(long n) {
        // write your code here
        long sum =1;
        long mod=0;
        long number=0;
        for(long i =1;i<=n;i++){
            sum=sum*i;
        }
        while(sum!=0){
            mod=sum%10;
            if(mod==0){
                number++;
                sum=sum/10;
            }else{
                break;
            }
        }
        return number;
    }


}
