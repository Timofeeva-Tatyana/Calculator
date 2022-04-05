package Calcul;

import java.util.Arrays;
import java.util.Scanner;

public class ArabRomCalc {
    static int num1;
    static int num2;
    static char op;
    static int result;
    static boolean flag1 = false;
    static boolean flag2 = false;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Введите арифметическую операцию [+-*/] двух чисел через пробел: +  Enter");
        String str1 = scanner.nextLine();
        String[] arr = str1.split(" ");
        if (arr.length < 3) {
            throw new Exception("Строка не является математической операцией");
        }
        if (arr.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String[] rom = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX"};
        String index1 = String.valueOf(Arrays.binarySearch(rom, arr[0]));
        String index2 = String.valueOf(Arrays.binarySearch(rom, arr[2]));
        num1 = Integer.parseInt(index1);
        num2 = Integer.parseInt(index2);
        if (num1 > 0) {
            flag1 = true;
        } else if (num1 < 0) {
            num1 = Integer.parseInt(arr[0]);
        }
        if (num2 > 0) {
            flag2 = true;
        } else if (num2 < 0) {
            num2 = Integer.parseInt(arr[2]);
        }
        if (flag1 ^ flag2) {
            throw new Exception("Используются одновременно разные системы счисления!");
        }
        if ((num1 < 0 || num1 > 10) || (num2 < 0 || num2 > 10)) {
            throw new Exception("Числа на вход должны быть от 1 до 10 вклюительно, не более!");
        }

        op = arr[1].charAt(0);
        result = ArifmOp.calc(num1, num2, op);
        if (flag1 & flag2) {
            if (result < 1) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            String resultRoman = NumToRoman.convToRom(result);
            System.out.println(resultRoman);
        } else {
            System.out.println(result);
        }

    }
}

class ArifmOp {
    static int calc(int num1, int num2, char op) throws Exception {
        int result;
        switch (op) {
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
                throw new Exception("Арифметическая операция не соответствует требованиям задачи!");
        }
        return result;
    }

}

class NumToRoman {
    static String convToRom(int numArabian) {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}
