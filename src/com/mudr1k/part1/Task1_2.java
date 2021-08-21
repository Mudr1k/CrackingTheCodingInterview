package com.mudr1k.part1;

/**
 * Для двух строк напишате метод, определяющий, является ли одна строка перестановкой другой.
 */

public class Task1_2 {

    public static void main(String[] args) {
        String aString1 = "1234";
        String aString2 = "1324";

        System.out.println(isPermutation(aString1, aString2));
    }

    public static boolean isPermutation(String aString1, String aString2) {
        if (aString1.length() != aString2.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] aString1_array = aString1.toCharArray();
        for (char c : aString1_array) {
            ++letters[c];
        }

        for (int i = 0; i < aString2.length(); i++) {
            int c = aString2.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
