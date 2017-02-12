package main.com.dp.mingmi.algorithmPractise;

/**
 * Created by zhangmingmi on 16/12/2.
 */
public class TestOneEasy {
    public static void main(String []args){
        System.out.println(add_without_operator(2,3));
        System.out.println(add_without_operator(2,-3));
        System.out.println(add_without_operator(2,-2));

    }
    public static int add_without_operator(int a,int b){
        int sum = a ^ b;
        int carry = a & b;
        while(carry!=0){
            carry = carry << 1;
            int tmp = sum ^ carry;
            carry = sum & carry;
            sum = tmp;
        }
      return sum;
    }
}
