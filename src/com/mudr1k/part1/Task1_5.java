package com.mudr1k.part1;

/**
 * Существует три вида модифицирующих операций со строками: вставка символа, удаление символа и замена символа.
 * Напишите функцию, которая проверяет, находятся ли две строки на расстоянии одной модификации (или нуля
 * модификаций).
 * Пример:
 * pale,    ple     -> true
 * pales,   pale    -> true
 * pale,    bale    -> true
 * pale,    bake    -> false
 */

public class Task1_5 {

    public static void main(String[] args) {

        String first = "pale";
//        String second = "ple";
        String second = "bake";
//        String second = "pales";

        System.out.println(oneEditAway(first, second));
        System.out.println(oneEditAwaySecondVersion(first, second));

    }

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditInsert(String first, String second) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                ++index2;
            } else {
                ++index1;
                ++index2;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    public static boolean oneEditAwaySecondVersion(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (s1.length() == s2.length()) {
                    ++index1;
                }
            } else {
                ++index1;
            }
            ++index2;
        }
        return true;
    }
}
