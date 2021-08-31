package com.mudr1k.part1;

/**
 * Напишите алгоритм, зеализующий следующее условие: если элемент матрицы MxN равен 0, то весь столбец и вся строка
 * обнуляются.
 */
public class Task1_8 {

    public static void main(String[] args) {

        int[][] matrix = {
                {00, 01, 02, 03, 04},
                {10, 11, 12, 13, 14},
                {20, 21, 22, 23, 24},
                {30, 31, 32, 33, 34},
                {40, 41, 42, 43, 44}
        };

//        print(matrix);
//        setZeros(matrix);
//        System.out.println();
//        print(matrix);

        print(matrix);
        setZeros2(matrix);
        System.out.println();
        print(matrix);

    }

    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; ++i) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < column.length; ++j) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    public static void setZeros2(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;

        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (columnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; ++j) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][column] = 0;
        }
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
