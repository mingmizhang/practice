package com.dp.mingmi.calculatortest;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangmingmi on 16/9/12.
 */
public class Calculator {
    public Queue<String> expressiontoqueue(String expression) {
        int flag_index = 0;
        String str;
        Queue<String> calculate_queue = new LinkedList<String>();
        for (int i = 0; i < expression.length(); i++) {
            str = expression.substring(i, i + 1);
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                calculate_queue.add(expression.substring(flag_index, i));
                calculate_queue.add(str);
                flag_index = i + 1;
            } else if (i == expression.length() - 1) {
                calculate_queue.add(expression.substring(flag_index, i + 1));
            }
        }
        return calculate_queue;
    }

    public Queue<String> calculatemultiply(Queue<String> queue) {
        Queue<String> addqueue = new LinkedList<String>();
        String before;
        String after;
        String operator;
        double value;
        while (queue.peek() != null) {
            before = queue.poll();
            if (queue.peek() != null) {
                operator = queue.poll();
                if (operator.equals("*")) {
                    after = queue.poll();
                    value = (Double.valueOf(before)) * (Double.valueOf(after));
                    if (queue.peek() != null) {
                        operator = queue.poll();
                        while ((operator != null) && operator.equals("*") || operator.equals("/")) {
                            if (operator.equals("*")) {
                                after = queue.poll();
                                value = value * (Double.valueOf(after));
                            } else if (operator.equals("/")) {
                                after = queue.poll();
                                value = value / (Double.valueOf(after));
                            }
                            if (queue.peek() != null) {
                                operator = queue.poll();
                            } else {
                                break;
                            }
                        }
                        addqueue.add(Double.toString(value));
                        if (queue.peek() != null) {
                            addqueue.add(operator);
                        }
                    } else {
                        addqueue.add(Double.toString(value));
                    }
                } else if (operator.equals("/")) {
                    after = queue.poll();
                    value = (Double.valueOf(before)) / (Double.valueOf(after));
                    if (queue.peek() != null) {
                        operator = queue.poll();
                        while ((operator != null) && operator.equals("*") || operator.equals("/")) {
                            if (operator.equals("*")) {
                                after = queue.poll();
                                value = value * (Double.valueOf(after));
                            } else if (operator.equals("/")) {
                                after = queue.poll();
                                value = value / (Double.valueOf(after));
                            }
                            if (queue.peek() != null) {
                                operator = queue.poll();
                            } else {
                                break;
                            }
                        }
                        addqueue.add(Double.toString(value));
                        if (queue.peek() != null) {
                            addqueue.add(operator);
                        }
                    } else {
                        addqueue.add(Double.toString(value));
                    }
                } else if (operator.equals("+") || operator.equals("-")) {
                    addqueue.add(before);
                    addqueue.add(operator);
                }
            } else {
                addqueue.add(before);
            }
        }
        return addqueue;
    }


    public double calculateadd(Queue<String> queue) {
        double result = 0;
        String before;
        String after;
        String operator;
        double before_value;
        double after_value;
        if (queue.peek() != null) {
            before = queue.poll();
            if (before.contains("."))
                before_value = Double.valueOf(before);
            else
                before_value = Integer.valueOf(before);
            result = before_value;
            while (queue.peek() != null) {
                operator = queue.poll();
                after = queue.poll();
                if (after.contains("."))
                    after_value = Double.valueOf(after);
                else
                    after_value = Integer.valueOf(after);
                if (operator.equals("+")) {
                    result = result + after_value;
                } else if (operator.equals("-")) {
                    result = result - after_value;
                }
            }
        }
        return result;
    }


    public static void main(String[] args)throws IOException{
        ReadFromScreen readscreen = new ReadFromScreen();
        String multiplyexpression = readscreen.readlinefromscreen();
        Calculator cal = new Calculator();
//        Queue<String> addexpressqueue = new LinkedList<String>();
//        String addexpression = "2+3-4+5-6";
//        addexpressqueue = cal.expressiontoqueue(addexpression);
////      test add or substrction
//        double addresult = cal.calculateadd(addexpressqueue);
//        System.out.println("The computation of addition or substraction  "+ addexpression +" =  " + addresult);
//        test multiplication or division
        Queue<String> multiplyexpressqueue = new LinkedList<String>();
        Queue<String> multiplyresultqueue = new LinkedList<String>();
        //String multiplyexpression = "2*3*4/6-2/4*2*3*5*9-8";
        multiplyexpressqueue = cal.expressiontoqueue(multiplyexpression);
        multiplyresultqueue = cal.calculatemultiply(multiplyexpressqueue);
        double multiplyresult = cal.calculateadd(multiplyresultqueue);
        System.out.println("The expression you input is: " + multiplyresult);
        //test value
        //double compare_result=1.0;
        //System.out.println("The expression you input by calculatoris: " + compare_result);
    }
}
