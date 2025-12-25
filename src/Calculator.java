import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String operator;
            double num1;
            double num2 = 0;
            double result = 0;
            System.out.println("=== Java 계산기 ===");

            // 두 숫자와 연산자 입력받기
            while (true) {
                // num1에 숫자가 아닌 값 예외처리
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("숫자만 입력하세요.");
                    scanner.nextLine();
                }
            }

            while (true) {
                    System.out.print("연산자를 입력하세요 (+ , -, *, /): ");
                    operator = scanner.nextLine();

                    // 잘못된 연산자 입력처리
                    if (operator.equals("+") || operator.equals("-")
                            || operator.equals("*") || operator.equals("/")) {
                        break;
                    }
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                }


                while (true) {
                    // n0으로 나누기 예외처리
                    try {
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        num2 = scanner.nextDouble();
                        scanner.nextLine();

                        if (num2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("숫자만 입력하세요.");
                        scanner.nextLine();
                    }
                }

//
//            if (operator.equals("+")) {
//                result = num1 + num2;
//            } else if (operator.equals("-")) {
//                result = num1 - num2;
//            } else if (operator.equals("*")) {
//                result = num1 * num2;
//            } else if (operator.equals("/")) {
//                result = num1 / num2;
//            }

                // 사칙연산 구현
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }

                System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);

                // 계속/종료 선택 기능
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
