package com.mudr1k.part1;

/**
 * Реализуйте метод для выполнения простейшего сжатия строк с использованием счетчика повторяющихся символов.
 * Например строка aabcccccaaa превращается в a2b1c5a3. Если "сжатая" строка не становится короче исходной, то метод
 * возвращает исходную строку. Предполагается, что строка состоит только из букв верхнего и нижнего регистра (a-z)
 */

public class Task1_6 {

    public static void main(String[] args) {
        String value = "aabcccccaaa";

        System.out.println(compress(value));
        System.out.println(compressSecondVersion(value));
    }

    public static String compress(String value) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < value.length(); ++i) {
            ++countConsecutive;
            if (i + 1 >= value.length() || value.charAt(i) != value.charAt(i + 1)) {
                compressed.append(value.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < value.length() ? compressed.toString() : value;
    }

    public static String compressSecondVersion(String value) {
        int finalLength = countCompression(value);
        if (finalLength >= value.length()) {
            return value;
        }

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < value.length(); ++i) {
            ++countConsecutive;
            if (i + 1 >= value.length() || value.charAt(i) != value.charAt(i + 1)) {
                compressed.append(value.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private static int countCompression(String value) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < value.length(); ++i) {
            ++countConsecutive;
            if (i + 1 >= value.length() || value.charAt(i) != value.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}
