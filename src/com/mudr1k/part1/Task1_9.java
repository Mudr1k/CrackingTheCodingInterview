package com.mudr1k.part1;

/**
 * Допустим, что существует метод isSubstring, проверяющий, является ли одно слово подстрокой другого. Для двух строк
 * s1 и s2 напишите код, который проверяет, получена ли строка s2 циклическим сдвигом s1, используя только один вызов
 * метода isSubstring (пример: слово waterbottle получено циклическим сдвигом erbottlewat).
 */
public class Task1_9 {

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }

    public static boolean isRotation(String s1, String s2) {
        int length = s1.length();
        if (length == s2.length() && length > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
