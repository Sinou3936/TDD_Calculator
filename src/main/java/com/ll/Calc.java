package com.ll;

public class Calc {
    public static int run(String expression) {
        while (expression.contains("(")){
            int start = expression.lastIndexOf("(");
            int end = expression.indexOf(")", start);
            String inner = expression.substring(start + 1, end);
            int innerResult = run(inner);

            expression = expression.substring(0, start) + innerResult + expression.substring(end + 1);

        }

        String[] arr = expression.split(" ");
        int result = 0;
        int lastValue = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i+=2) {
            String operator = arr[i];
            int operand = Integer.parseInt(arr[i+1]);

            if (operator.equals("+")) {
                result += lastValue;
                lastValue = operand;
            } else if (operator.equals("-")) {
                result += lastValue;
                lastValue = -operand;
            } else if (operator.equals("*")) {
                lastValue *= operand;
            } else if (operator.equals("/")) {
                lastValue /= operand;
            }
        }
        result += lastValue;
        return result;
    }

}
