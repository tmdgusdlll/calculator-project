import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Java 계산기 ===");

            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("연산자를 입력하세요 (+ , -, *, /): ");
            String operator = scanner.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();

            double result = 0;

            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                result = num1 / num2;
            }

            System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);

            System.out.print("계속 계산하시겠습니까? (y/n): ");
            String answer = scanner.nextLine();

            if (answer.equals("n")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}
// 어려워,,
