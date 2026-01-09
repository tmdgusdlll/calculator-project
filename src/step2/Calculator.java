package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);
    List<String> record = new ArrayList<>();

    int result = 0;

    String operator;

    public int calculate(int num1, int num2, char operator) {

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("올바른 연산자가 아닙니다.");
        }
        record.add(num1 + " " + operator + " " + num2 + "=" + result);
        return result;

    }
}



