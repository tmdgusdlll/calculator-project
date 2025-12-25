import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 게산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 이력 보기");
            System.out.println("3. 이력 지우기");
            System.out.println("0. 종료");

            int menu;

            try {
                System.out.print("선택: ");
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요.");
                scanner.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
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
                                System.out.print("숫자만 입력하세요.");
                                scanner.nextLine();
                            }
                        }

                        while (true) {
                            System.out.print("연산자를 입력하세요 (+ , -, *, /, %, ^, sqrt): ");
                            operator = scanner.nextLine();

                            // 잘못된 연산자 입력처리
                            if (operator.equals("+") || operator.equals("-")
                                    || operator.equals("*") || operator.equals("/")
                                    || operator.equals("%") || operator.equals("^")
                                    || operator.equals("sqrt")) {
                                break;
                            }
                            System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                        }
                        if (!operator.equals("sqrt")) {
                            while (true) {
                                // n0으로 나누기 예외처리
                                try {
                                    System.out.print("두 번째 숫자를 입력하세요: ");
                                    num2 = scanner.nextDouble();
                                    scanner.nextLine();

                                    if (operator.equals("/") && num2 == 0) {
                                        System.out.println("0으로 나눌 수 없습니다.");
                                        continue;
                                    }
                                    break;
                                } catch (Exception e) {
                                    System.out.println("숫자만 입력하세요.");
                                    scanner.nextLine();
                                }
                            }
                        }
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
                            case "%":
                                result = num1 % num2;
                                break;
                            case "^":
                                result = Math.pow(num1, num2);
                                break;
                            case "sqrt":
                                if (num1 < 0) {
                                    System.out.println("음수의 제곱근은 계산할 수 없습니다.");
                                    continue;
                                }
                                result = Math.sqrt(num1);
                                break;
                        }

                        // 출력 & 이력
                        if (operator.equals("sqrt")) {
                            System.out.println("결과: sqrt(" + num1 + ") = " + result);
                        }
                        System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);
                        // 계산 이력 저장
                        String record = num1 + " " + operator + " " + num2 + " = " + result;
                        history.add(record);
                        // 이력 3개만 유지
                        if (history.size() > 3) {
                            history.remove(0);
                        }

                        System.out.print("계속 계산하시겠습니까? (y/n): ");
                        String answer = scanner.nextLine();

                        if (answer.equals("n")) {
                            System.out.println("계산기를 종료합니다.");
                            break;
                        }
                    }
                    break;
                case 2:
                    if (history.isEmpty()) {
                        System.out.println("계산 이력이 없습니다.");
                    } else {
                        System.out.println("--- 최근 계산 이력 ---");
                        for (String h : history) {
                            System.out.println(h);
                        }
                    }
                    break;
                case 3:
                    history.clear();
                    System.out.println("계산 이력이 삭제되었습니다.");
                    break;
                case 0:
                    scanner.close();
                    System.out.println("계산기를 종료합니다.");
                    return;

                default:
                    System.out.print("잘못된 메뉴입니다. 다시 선택하세요.");
            }
        }
    }
}



// 어려워,,
