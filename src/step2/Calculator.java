package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 캡슐화 private 키워드 사용하여 접근제어(App 클래스의 main메서드로부터)
    // 연산 결과 저장하는 컬레션 타입(ArratList) 생성
    private List<Integer> history = new ArrayList<>();

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
        // 연산 결과값 저장
//        history.add(result);   -> 저장하는 역할을 세터에게 넘겼음 *한 메서드당 하나의 기능을 맡는 것이 좋다.
        return result;
    }

    // Getter 메서드
    public List<Integer> getHistory() {
        return this.history;
    }

    // Setter 메서드
    public void setHistory(int newHistoryNumber) {
        // 수정할 값을 따로 반환해서 어디 저장하지 않고 바로 history에 추가하는 것이 효율적.
        this.history.add(newHistoryNumber);
    }

    // 삭제하는 메서드
    // 가장 먼저 저장된 데이터 -> 배열의 원소..? 에서 0번인덱스 삭제하면 되나?
    public void removeResult() {
        history.remove(0);
    }
}



