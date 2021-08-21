package com.mudr1k.part1;

/**
 * Реализуйте алгоритм, определяющий все ли символы в строке встречаются только один раз.
 * А если при этом запрещено использование дополнительных структур данных?
 */

public class Task1_1 {

    public static void main(String[] args) {
        String aString1 = "asdfghjj";

        System.out.println(isUniqueChars(aString1));
    }

    public static boolean isUniqueChars(String aString) {
        if (aString.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < aString.length(); i++) {
            int value = aString.charAt(i);
            if (char_set[value]) {
                return false;
            }
            char_set[value] = true;
        }
        return true;
    }
}
