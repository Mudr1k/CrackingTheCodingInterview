package com.mudr1k.part1;

/**
 * Напишите функцию, которая проверяет, является ли заданная строка перестановкой палиндрома. (Палиндром - слово или
 * фраза, одинаково читающиеся в прямом и обратном направлении; перестановка - строка , содержащая те же символы в
 * другом порядке.) Палиндром не ограничивается словами из словаря.
 * Пример:
 * Ввод: Tact Coa
 * Вывод: True (перестановки: "taco cat", "atco cta", и т.д.)
 */
public class Task1_4 {

    public static void main(String[] args) {
        String phrase = "Tact Coa";

        System.out.println(isPermutationOfPalindrome(phrase));
        System.out.println(isPermutationOfPalindromeBitVector(phrase));
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static boolean isPermutationOfPalindromeBitVector(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector ==0 || checkExactlyOneBitSet(bitVector);
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0 ) {
            return bitVector;
        }
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                ++table[x];
            }
        }
        return table;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
//        int A = Character.getNumericValue('A');
//        int Z = Character.getNumericValue('Z');

        int value = Character.getNumericValue(c);

        if (a <= value && value <= z) {
            return value - a;
//        } else if (A <= value && value <= Z) {
//            return value - A;
        }
        return -1;
    }
}
