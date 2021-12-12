import java.util.Arrays;
import java.util.Scanner;

public class RomanArabicCalculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2; // два операнда
    static char operation; // оператор
    static int result; // результат операции

    /**
     * Римско - арабский калькулятор
     */
    public static void main (String[] args) throws Exception {
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


        // Вычленение и форматирование чисел:
        String empty_array_filled = String.valueOf(empty_array); // пользователь ввел значения
        String[] splitted_array = empty_array_filled.split("[+-/*]"); // метод возвращает массив строк (операнды)


        // Если true, значит операндов больше, чем два
        if (splitted_array.length > 2){
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор.");
            System.exit(1);
        }
        // Если true, значит не получилось использовать метод split.
        if (splitted_array.length == 1){
            System.out.println("Четыре операции допустимы: +, -, /, * .");
            System.exit(2);
        }

            String number_first = splitted_array[0]; // первое число
            String number_second = splitted_array[1]; // второе число

            String correct_number_first = number_first.trim(); // первое число (форматированное без пробелов)
            String correct_number_second = number_second.trim(); // второе число (форматированное без пробелов)


        // Проверка на допустимость значений:
        String[] numbersAvailable = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        if (!Arrays.stream(numbersAvailable).toList().contains((correct_number_first))) {
            System.out.println("Первый операнд вне допустимых значений [1;10]");
            System.exit(3);
        }
        if (!Arrays.stream(numbersAvailable).toList().contains((correct_number_second))) {
            System.out.println("Второй операнд вне допустимых значений [1;10]");
            System.exit(4);
        }


        // Возвращение арабских чисел
        number1 = Roman.romanToNumber(correct_number_first);
        number2 = Roman.romanToNumber(correct_number_second);


        // Если введенное число арабское, вернется арабская минус единица. Если римское, вернется арабское число больше 0.
        // Выражение false, только если оба числа положительны или оба отрицательны.
        if ((number1 > 0 & number2 < 0) || (number1 < 0 & number2 > 0)){
        throw new Exception("Работа калькулятора возможна только с операндами одной системы");}


        // Если оба отрицательны результат будет ноль. Программа пойдет в блок ниже.
        // Если false, значит,цифры римские (оба положительные). Программа пойдет в блок else.
        if (number1 < 0 & number2 < 0) {
            result = 0;
        } else {
            result = Arithmetic.calculate(number1, number2, operation);

            System.out.println("Результат для римских цифр:");
            String resultRoman = Roman.convertNumToRoman(result);
            System.out.println(correct_number_first + " " + operation + " " + correct_number_second + " = " + resultRoman);
            System.exit(5);
        }

        // Работа с арабскими числами
        number1 = Integer.parseInt(correct_number_first);
        number2 = Integer.parseInt(correct_number_second);

        result = Arithmetic.calculate(number1, number2, operation);

        System.out.println("Результат для арабских цифр:");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);

    }
}
