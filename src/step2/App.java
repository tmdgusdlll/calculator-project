package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        while (true) {
            int num1;
            int num2;
            char operator;
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.nextLine().charAt(0);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                }
                System.out.println("올바른 기호가 아닙니다.");
            }

            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = Integer.parseInt(sc.nextLine());
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }

            int result = cal.calculate(num1, num2, operator);
            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니가? (exit 입력시 종료)");
            String answer = sc.nextLine();
            if (answer.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            // Setter 접근
            cal.setHistory(result);

            // Getter 접근
            List<Integer> resultHistory = cal.getHistory();
            System.out.println("이전 연산 결과: " + resultHistory);
        }
    }
}



