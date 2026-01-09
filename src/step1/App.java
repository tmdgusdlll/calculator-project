package step1;
import java.util.Scanner;

// 클래스 없이 기본적인 연산 계산기 만들기
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;
        int result = 0;

        while (true) {
            // 양의 정수(0포함) 입력 받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = sc.nextInt();

            // 사칙연산 기호(+, -, *, /)를 입력받기
            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            char operator = sc.next().charAt(0); // 처음에 nextLine()으로 받으려했으나, 연산자 같은 문자역은 하나만 읽어내는 next()가 안전하다해서 바꿈
            // charAt() ->문자열에서 한 문자만 가져오는 것. (사칙연산 기호는 문자열임)
            // 스캐너를 통해 입력받을 값은 사칙연간 기호 하나 이므로 인덱스 0을 통해 출력가능

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
                    continue;
            }
            System.out.println("결과: " + result);

            // 더 계산하시겠습니까? 라는 문구에 대답을 듣고 다시 반복되거나 끝내야하는데 첫번째 숫자 입력하라는 문구가 자꾸 같이 출력됨.
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            sc.nextLine(); // TODO: 찾아보니 엔터 씹힘,,? 문제라고 하는데 다시 찾아봐야 할 거 같다.
            String answer = sc.nextLine();

            if (answer.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}
