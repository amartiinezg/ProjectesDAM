/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2_Examen;

import java.util.Scanner;

public class JocDeTaula {

    public static final int FILES = 8;
    public static final int COLUMNES = 8;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] tauler = creaTauler();
        int posFila = 0, posColumna = 0, intents = 1, fitxes = 4;
        boolean finalitzat = false;

        do {
            System.out.println("Intent " + intents);
            System.out.println("Fila: ");
            posFila = in.nextInt()-1;
            System.out.println("Columna: ");
            posColumna = in.nextInt()-1;
            if (existeixFitxa(tauler, posFila, posColumna)) {
                System.out.println("Perfecte! La posició es vàlida");
                tauler[posFila][posColumna] = 2;
                fitxes--;
            } else {
                intents++;
            }

            if (intents == 10 || fitxes == 0) {
                finalitzat = true;
            }
        } while (!finalitzat);
        System.out.println("");
        if (fitxes == 0) {
            System.out.println("Enhorabona! Has guanyat!");
        } else {
            System.out.println("Oooh! Has perdut! :( ");
        }

        mostraTauler(tauler);
    }

    public static int[][] creaTauler() {
        int fitxaBlanca = 20;
        int[][] tauler = new int[FILES][COLUMNES];
        do {
            for (int i = 0; i < FILES; i++) {
                for (int j = 0; j < COLUMNES; j++) {
                    if ((int) (Math.random() * 3) == 1 && fitxaBlanca != 0) {
                        tauler[i][j] = 1;
                        fitxaBlanca--;
                    }
                }
            }
        } while (fitxaBlanca != 0);
        return tauler;
    }

    public static boolean existeixFitxa(int[][] tauler, int fila, int columna) {
        if (tauler[fila][columna] == 0 && tocaVora(fila, columna)) {
            return true;
        } else if (tauler[fila][columna] != 0) {
            System.out.println("No és vàlida. Ja hi ha una fitxa!");
        } else {
            System.out.println("No és vàlida. Toca la vora!");
        }
        return false;
    }

    public static boolean tocaVora(int fila, int columna) {
        if ((fila != 0 && fila != 7) && (columna != 0 && columna != 7)) {
            return true;
        }
        return false;
    }

    public static void mostraTauler(int[][] tauler) {
        for (int i = 0; i < FILES; i++) {
            for (int j = 0; j < COLUMNES; j++) {
                if (tauler[i][j] == 1) {
                    System.out.print("\t"+"B");
                } else if (tauler[i][j] == 2) {
                    System.out.print("\t"+"N");
                } else {
                    System.out.print("\t"+tauler[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
