package com.mudr1k.part1;

/**
 * Имеется изображение, представленное матрицей NxN; каждый пиксел представлен 4 байтами. Напишите метод для поворота
 * изображения на 90 градусов. Удастся ли вам выполнить эту операцию "на месте"?
 */
public class Task1_7 {

    public static void main(String[] args) {

        int[][] matrix = {
                {00, 01, 02, 03, 04},
                {10, 11, 12, 13, 14},
                {20, 21, 22, 23, 24},
                {30, 31, 32, 33, 34},
                {40, 41, 42, 43, 44}
        };

        print(matrix);
        System.out.println();

        print(rotate(matrix));
    }

    public static int[][] rotate(int[][] matrix) {

        int k = matrix.length - 1;

        for (int i = 0; i < matrix.length / 2; ++i) {
            for (int j = i; j < k - i; ++j) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[k - j][i];
                matrix[k - j][i] = matrix[k - i][k - j];
                matrix[k - i][k - j] = matrix[j][k - i];
                matrix[j][k - i] = temp;

            }
        }
        return matrix;
    }

    private static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
