package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            return new int[0];
        int last = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = last;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            return 0;
        if (inputArray.length == 1)
            return inputArray[0];
        int min = Integer.MAX_VALUE;
        int almost_min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int almost_max = Integer.MIN_VALUE;
        for (int value : inputArray) {
            if (value > max) {
                almost_max = max;
                max = value;
            } else if (value > almost_max)
                almost_max = value;
            if (value < min) {
                almost_min = min;
                min = value;
            } else if (value < almost_min)
                almost_min = value;
        }
        return Integer.max(max * almost_max, min * almost_min);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char chr = input.charAt(i);
            if (chr == 'a' || chr =='A' || chr == 'b' || chr == 'B') {
                count++;
            }
        }
        return 100 * count / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1))
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        int count = 1;
        result.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                result.append(Integer.toString(count));
                result.append(input.charAt(i));
                count = 1;
            } else
                count++;
        }
        result.append(Integer.toString(count));
        return result.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one.length() == 0)
            return false;
        char[] array_one = new char[one.length()];
        char[] array_two = new char[two.length()];
        for (int i = 0; i < one.length(); i++) {
            array_one[i] = one.charAt(i);
            array_two[i] = two.charAt(i);
        }
        Arrays.sort(array_one);
        Arrays.sort(array_two);
        for (int i = 0; i < one.length(); i++)
            if (array_one[i] != array_two[i])
                return false;
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if ((s.charAt(i) == s.charAt(j)))
                    return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.length == 0 || m.length != m[0].length)
            return new int[0][0];
        int[][] result = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                result[i][j] = m[j][i];
            }
        }
        return result;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0)
            return "";
        if (separator == null)
            separator = ' ';
        StringBuilder result = new StringBuilder(inputStrings[0]);
        for (int i = 1; i < inputStrings.length; i++) {
            result.append(separator);
            result.append(inputStrings[i]);
        }
        return result.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null)
            return 0;
        int result = 0;
        for (String inputString : inputStrings) {
            if (inputString.length() < prefix.length())
                continue;
            boolean flag = true;
            for (int j = 0; flag && j < prefix.length(); j++) {
                if (inputString.charAt(j) != prefix.charAt(j))
                    flag = false;
            }
            if (flag)
                result++;
        }
        return result;
    }
}
