package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    public void start() {
        System.out.println("=== 계산기 메뉴 ===");
        System.out.println("1. 계산하기");
        System.out.println("2. 계산 기록 보기");
        System.out.println("3. 가장 처음 기록 삭제하기");
        System.out.println("0. 종료하기");
        System.out.println("=================");

        // TODO: 나중에 do - while로 바꿔볼까..?
        while (true) {
            System.out.print("계산기 메뉴를 선택하시오: ");
            int answer = 0;
            try {
                answer = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            switch (answer) {
                case 1:
                    calculate();
                    break;
                case 2:
                    getHistory();
                    break;
                case 3:
                    removeResult();
                    break;
                case 0: {
                    System.out.println("종료하시겠습니가? (exit 입력 시 종료): ");
                    String response = sc.nextLine();
                    if (response.equalsIgnoreCase("exit")) {
                        System.out.println("계산기를 종료합니다.");
                    }
                    return;
                }
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void calculate() {
        double num1 = 0;
        double num2 = 0;
        double result = 0;
        char operator = 0;

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }

        while (true) {
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            operator = sc.nextLine().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                break;
            } else {
                System.out.println("올바른 사칙연산 기호가 아닙니다.");
            }
        }

        while (true) {
            try {
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = Double.parseDouble(sc.nextLine());
                if (operator == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
        result = calculator.calculate(num1, num2, operator);
        calculator.setHistory(result);
        System.out.println("결과: " + result);

        while (true) {
            System.out.println("더 계산하시겠습니까? (y/n): ");
            String reStart = sc.nextLine();
            if (reStart.equals("y")) {
                break;
            } else if (reStart.equals("n")) {
                return;
            } else {
                System.out.println("y 또는 n만 입력해주세요.");
            }
        }
    }

    public void getHistory() {
        if (calculator.getHistory().isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
            return;
        } else {
            System.out.println("--계산 기록--");
            System.out.println(calculator.getHistory());
        }
    }

    public void removeResult() {
        // 계산 기록이 없는데 삭제 요청할 시 예외처리
        if (calculator.getHistory().isEmpty()) {
            System.out.println("계산 기록이 없습니다.");
            return;
        } else {
            calculator.removeResult();
            System.out.println("삭제되었습니다.");
            System.out.println("--계산 기록--");
            System.out.println(calculator.getHistory());
        }
    }
}
