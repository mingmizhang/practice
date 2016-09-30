package com.dp.mingmi.calculatortest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhangmingmi on 16/9/13.
 */
public class CalculateBrackets {
    public Map<String, Integer> instack = new HashMap<String, Integer>();
    public Map<String, Integer> outstack = new HashMap<String, Integer>();

    public CalculateBrackets() {
        this.instack.put("#", 0);
        this.instack.put("(", 1);
        this.instack.put(")", 6);
        this.instack.put("+", 3);
        this.instack.put("*", 5);
        this.instack.put("/", 5);
        this.instack.put("-", 3);
        this.outstack.put("#", 0);
        this.outstack.put("+", 2);
        this.outstack.put("-", 2);
        this.outstack.put("*", 4);
        this.outstack.put("/", 4);
        this.outstack.put("(", 6);
        this.outstack.put(")", 1);
    }

    public boolean judgerightexpression(String expression) {
        boolean flag_expression = true;
        String str;
        int left = 0;
        int right = 0;
        for (int i = 0; i < expression.length(); i++) {
            str = expression.substring(i, i + 1);
            if (expression.substring(0, 1).equals("*") || expression.substring(0, 1).equals("/") || expression.substring(0, 1).equals(")")) {
                System.out.println("The first string is not allowed, please inpput the right expression!!!");
                flag_expression = false;
                return flag_expression;
            }
            if (str.equals("(")) {
                left++;
                if ((i != 0) && (!(expression.substring(i - 1, i).equals("(") || expression.substring(i - 1, i).equals("+") || expression.substring(i - 1, i).equals("-") || expression.substring(i - 1, i).equals("*") || expression.substring(i - 1, i).equals("/")))) {
                    System.out.println("The expression contains wrong string,please input the right expression!!!");
                    System.exit(0);
                }
            } else if (str.equals(")")) {
                right++;
                if (((expression.substring(i - 1, i).equals("+") || expression.substring(i - 1, i).equals("-") || expression.substring(i - 1, i).equals("*") || expression.substring(i - 1, i).equals("/")))) {
                    System.out.println("The expression contains wrong string,please input the right expression!!!");
                    System.exit(0);
                }
            } else if ((str.equals(".") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.matches("^[0-9]{1}$")) != true) {
                System.out.println("The expression contains wrong string,please input the right expression!!!");
                return false;
            }
            if (left < right) {
                System.out.println("The right brackets in the expression was input wrongly , please input the right expression!!!");
                return false;
            }
        }
        if (left != right) {
            System.out.println("The brackets in the expression is not balance, please input the right expression!!!");
            return false;
        }
        return true;

    }

    public Queue<String> expressiontoqueue(String expression) {
        int flag_index = 0;
        String str;
        Queue<String> calculate_queue = new LinkedList<String>();
        for (int i = 0; i < expression.length(); i++) {
            str = expression.substring(i, i + 1);
            if ((str.equals("+")) || (str.equals("-")) || (str.equals("*")) || (str.equals("/")) || (str.equals("(")) || (str.equals(")"))) {
                if (flag_index < i) {
                    calculate_queue.add(expression.substring(flag_index, i));
                    calculate_queue.add(str);
                } else if (flag_index == i) {
                    if ((i == 0) && (expression.substring(0, 1).equals("+") || expression.substring(0, 1).equals("-"))) {
                        calculate_queue.add("0");
                        calculate_queue.add(str);
                    } else if ((str.equals("+") || str.equals("-")) && expression.substring(i - 1, i).equals("(")) {
                        calculate_queue.add("0");
                        calculate_queue.add(str);

                    } else {
                        calculate_queue.add(str);
                    }

                }
                flag_index = i + 1;
            } else if (i == expression.length() - 1) {
                calculate_queue.add(expression.substring(flag_index, i + 1));
            }
        }

        return calculate_queue;
    }


    public Queue<String> postfixexpression(Queue<String> queue) {
        Queue postqueue = new LinkedList<String>();
        Stack tmpstack = new Stack<String>();
        String str;
        tmpstack.push("#");
        while ((queue.peek()) != null) {
            str = queue.poll();
            if ((str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(") || str.equals(")")) != true) {
                postqueue.add(str);
            } else {
                if (outstack.get(str) > instack.get(tmpstack.peek())) {
                    tmpstack.push(str);
                } else if (outstack.get(str) <= instack.get(tmpstack.peek())) {
                    while (outstack.get(str) < instack.get(tmpstack.peek())) {
                        postqueue.add(tmpstack.pop());
                    }
                    if (outstack.get(str) == instack.get(tmpstack.peek())) {
                        tmpstack.pop();
                    } else if (outstack.get(str) > instack.get(tmpstack.peek())) {
                        tmpstack.push(str);
                    }

                }
            }
        }
        while (!tmpstack.peek().equals("#")) {
            postqueue.add(tmpstack.pop());
        }
        return postqueue;
    }

    public double computePostExpression(Queue<String> queue) {
        double result = 0;
        Stack<String> stack = new Stack<String>();
        String str;
        double tmp1 = 0;
        double tmp2 = 0;
        BigDecimal temp1;
        BigDecimal temp2;
        BigDecimal result_return;
        while (!queue.isEmpty()) {
            str = queue.poll();
            if ((str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(") || str.equals(")")) != true) {
                stack.push(str);
            } else if (str.equals("+")) {
//                tmp1 = Double.valueOf(stack.pop());
//                tmp2 = Double.valueOf(stack.pop());
//                result = tmp2 + tmp1;
//                stack.push(String.valueOf(result));
                temp1 = new BigDecimal(stack.pop());
                temp2 = new BigDecimal(stack.pop());
                result_return = temp1.add(temp2);
                stack.push(String.valueOf(result_return));
            } else if (str.equals("-")) {
//                tmp1 = Double.valueOf(stack.pop());
//                tmp2 = Double.valueOf(stack.pop());
//                result = tmp2 - tmp1;
//                stack.push(String.valueOf(result));
                temp1 = new BigDecimal(stack.pop());
                temp2 = new BigDecimal(stack.pop());
                result_return = temp2.subtract(temp1);
                stack.push(String.valueOf(result_return));
            } else if (str.equals("*")) {
//                tmp1 = Double.valueOf(stack.pop());
//                tmp2 = Double.valueOf(stack.pop());
//                result = tmp2 * tmp1;
//                stack.push(String.valueOf(result));
                temp1 = new BigDecimal(stack.pop());
                temp2 = new BigDecimal(stack.pop());
                result_return = temp1.multiply(temp2);
                stack.push(String.valueOf(result_return));
            } else if (str.equals("/")) {
//                tmp1 = Double.valueOf(stack.pop());
//                tmp2 = Double.valueOf(stack.pop());
//                BigDecimal bigTmp1 = new BigDecimal(tmp1);
                temp1 = new BigDecimal(stack.pop());
                temp2 = new BigDecimal(stack.pop());
                if (temp1.compareTo(new BigDecimal(0.0)) == 0) {
                    System.out.println("The divisor is zero, please input the right divisor!!!");
                    System.exit(0);
                }
//                result = tmp2 / tmp1;
//                stack.push(String.valueOf(result));
                result_return = temp2.divide(temp1);
                stack.push(String.valueOf(result_return));

            }
        }
        while (!stack.isEmpty()) {
            result = Double.valueOf(stack.pop());
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        while (true) {
            ReadFromScreen readScreen = new ReadFromScreen();
            String expression = readScreen.readlinefromscreen();
            CalculateBrackets calculateBrackets = new CalculateBrackets();
            Queue<String> expressionqueue = new LinkedList<String>();
            //judge input is reasonable
            boolean flag_express = calculateBrackets.judgerightexpression(expression);
            if (flag_express == false)
                System.exit(0);
            //expressionqueue = calculateBrackets.expressiontoqueue("1-((7.2-5.2)*(8-3)-1)/2+14");
            //expressionqueue = calculateBrackets.expressiontoqueue("2*3*4/2/2");
            //expressionqueue = calculateBrackets.expressiontoqueue("4-2-1+9");
            //expressionqueue = calculateBrackets.expressiontoqueue("3+2*5*(9-8)+9-6-5");
            expressionqueue = calculateBrackets.expressiontoqueue(expression);
            //expressionqueue = calculateBrackets.expressiontoqueue("2+3.1*(4.7-5.7)-6/3");
            //expressionqueue = calculateBrackets.expressiontoqueue("(-1)");
            //expressionqueue = calculateBrackets.expressiontoqueue("-1*(-1)");
            Queue<String> postexpression = calculateBrackets.postfixexpression(expressionqueue);
            double result = calculateBrackets.computePostExpression(postexpression);
            System.out.println("The result of expresssion you input is: " + result);

        }
    }
}
