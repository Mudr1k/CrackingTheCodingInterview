package com.mudr1k.part1;

/**
 * Напишите метод, заменяющий все пробелы в строке символами '%20'. Можете считать, что длина строки позволяет сохранить
 * дополнительные символы, а фактическая длина строки известна заранее. (Примечание: при реализации на Java для
 * выполнения операции "на месте" используйте символьный массив.)
 * Пример:
 * Ввод:    "Mr John Smith", 13
 * Вывод:   "Mr%20John%20Smith"
 */

public class Task1_3 {

    public static void main(String[] args) {
        String example = "Mr John Smith";

        System.out.println(replaceSpaces(example.toCharArray(), example.length()));
        System.out.println(example.replaceAll(" ", "%20"));
    }

    public static char[] replaceSpaces(char[] input, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') {
                ++spaceCount;
            }
        }

        int newLength = length + spaceCount * 2;
        char[] result = new char[newLength];

        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                result[newLength - 1] = '0';
                result[newLength - 2] = '2';
                result[newLength - 3] = '%';
                newLength -= 3;
            } else {
                result[newLength - 1] = input[i];
                newLength -= 1;
            }
        }
        return result;
    }
}
