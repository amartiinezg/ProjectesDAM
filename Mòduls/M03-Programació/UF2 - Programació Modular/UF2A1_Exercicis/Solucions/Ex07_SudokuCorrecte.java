package UF2A1_Exercicis.Solucions;

import java.util.Scanner;

public class Ex07_SudokuCorrecte {

    public static Scanner in = new Scanner(System.in);

    public static int[][] llegirSudoku() {
        int[][] s = new int[9][9];

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                s[i][j] = in.nextInt();
            }
        }
        return s;
    }

    public static boolean esVectorValido(int[] vector) {
        boolean valida = true;
        int[] valores = new int[9];
        for (int i = 0; i < 9 && valida; i++) {
            System.out.println("i = "+i);
            int num = vector[i];
            if (valores[num -1] != 0) { //SI EXISTE
                valida = false;
            } else { // 4 NO existe
                valores[num -1] = 1;
            }
        }
        return valida;
    }

    public static boolean esColumnaValida(int[][] sudoku, int columna) {
        boolean valida = true;
        int[] valores = new int[9];
        for (int i = 0; i < sudoku.length && valida; i++) {
            int num = sudoku[i][columna];
            if (valores[num - 1] != 0) {
                valida = false;
            } else {
                valores[num - 1] = 1;
            }
        }
        return valida;
    }

    public static boolean esRegioValida(int[][] sudoku, int filaInicial, int columnaInicial) {
        boolean valida = true;
        int[] valores = new int[9];
        for (int i = 0; i < 3 && valida; i++) {
            for (int j = 0; j < 3; j++) {
                int num = sudoku[filaInicial + i][columnaInicial + j];
                if (valores[num - 1] != 0) {
                    valida = false;
                } else {
                    valores[num - 1] = 1;
                }
            }
        }
        return valida;
    }

    public static boolean sudokuValid(int[][] sudoku) {
        boolean valid = true;
        for (int i = 0; i < 9 && valid == true; i++) {
            valid = esVectorValido(sudoku[i]);
        }
        if (valid) {
            for (int i = 0; i < 9 && valid == true; i++) {
                valid = esColumnaValida(sudoku, i);
            }
            if (valid) {
                for (int i = 0; i < 9 && valid; i += 3) {
                    for (int j = 0; j < 9 && valid; j += 3) {
                        valid = esRegioValida(sudoku, i, j);
                    }
                }
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        int nCasos = in.nextInt();
        for (int i = 0; i < nCasos; i++) {
            int[][] sudoku = llegirSudoku();
            if (sudokuValid(sudoku)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
