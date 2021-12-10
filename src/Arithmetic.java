public class Arithmetic {

    /**
     * calculate() - этот метод осуществляет арифметические операции
     * @param number1 первое число
     * @param number2 второе число
     * @param operation операция
     * @return возвращает результат выражения
     */
    public static int calculate (int number1, int number2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                try {
                    result = number1 / number2;
                } catch (ArithmeticException e) {
                    System.out.println("Exception : " + e);
                    break;
                }
        }
        return result;
    }
}