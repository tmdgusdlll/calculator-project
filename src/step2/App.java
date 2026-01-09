package step2;

public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        int result = cal.calculate(1,3, '+');
        System.out.println("결과: " + result);
    }
}
