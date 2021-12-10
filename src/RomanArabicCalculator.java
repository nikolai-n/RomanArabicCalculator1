import java.util.Scanner;

public class RomanArabicCalculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2; // два операнда
    static char operation; // оператор
    static int result; // результат операции

    /**
     * Римско - арабский калькулятор
     */
    public static void main (String[] args) {
        System.out.println("Введите выражение в римском или арабском формате + Enter ");

//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();

//      Создаём пустой символьный массив длиной 15 символов:  empty_array,
//      15 символов если выражение длинное, например: VIII + VIII
        char[] empty_array = new char[15];

//      Заполняем empty_array символами строки, которую ввел пользователь и определяем знак операции
        for (int i = 0; i < userInput.length(); i++) {
            empty_array[i] = userInput.charAt(i);
            if (empty_array[i] == '+') {
                operation = '+';
            }
            if (empty_array[i] == '-') {
                operation = '-';
            }
            if (empty_array[i] == '*') {
                operation = '*';
            }
            if (empty_array[i] == '/') {
                operation = '/';
            }
        }


        String empty_array_filled = String.valueOf(empty_array); //пользователь ввел значения
        String[] splitted_array = empty_array_filled.split("[+-/*]"); // метод возвращает массив строк (операнды)
        String number_first = splitted_array[0]; // первое число
        String number_second = splitted_array[1]; // второе число
        String correct_number_first = number_first.trim(); // первое число (форматированное без пробелов)
        String correct_number_second = number_second.trim(); // второе число (форматированное без пробелов)

        number1 = Roman.romanToNumber(correct_number_first);
        number2 = Roman.romanToNumber(correct_number_second);

        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = Arithmetic.calculate(number1, number2, operation);
            System.out.println("Результат для римских цифр:");
            String resultRoman = Roman.convertNumToRoman(result);
            System.out.println(correct_number_first + " " + operation + " " + correct_number_second + " = " + resultRoman);
            System.exit(1);
        }


        number1 = Integer.parseInt(correct_number_first);
        number2 = Integer.parseInt(correct_number_second);

        if (number1 >10 | number2>10) {
            System.out.println("Только числа от 1 до 10 включительно");
        } else {
            result = Arithmetic.calculate(number1, number2, operation);
            System.out.println("Результат для арабских цифр:");
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);

        }}
}