package step2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
        // TODO: App(main)클래스는 간단명료할수록 좋다고하던데.. 어떻게 줄여나가지..?
public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        /* 반복문 시작 */
        // TODO: 너무 while에 while 이라 오류가능성 높음. 해결해보자 + 메뉴를 만들어보는 것도 좋을 법 하다.
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

            // Setter 접근
            cal.setHistory(result);
            System.out.println("연산 기록: " + cal.getHistory());

            // TODO: 더 계산하려고 할 때 어떤 조건을 달아서 다시 계산할 지 고민.
            System.out.println("더 계산하시겠습니가? (exit 입력 시 종료)" + "\n(첫 연산 결과 삭제하려면 Delete를 입력하세요.)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                 break;
            } else if (answer.equalsIgnoreCase("Delete")) {
                cal.removeResult();
                System.out.println("첫 연산 결과가 삭제되었습니다.");
                // Getter 접근
                List<Integer> resultHistory = cal.getHistory();
                System.out.println("삭제 후 연산 결과: " + resultHistory);
                break;
            }
        }
    }
}



