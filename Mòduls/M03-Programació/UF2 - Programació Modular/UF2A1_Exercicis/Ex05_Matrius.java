/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Exercicis;

import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex05_Matrius {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int seleccio;
        do {
            System.out.println("--- MENU MATRIU ---");
            System.out.println("1 - Generar Matriu (Automàtica)");
            System.out.println("2 - Generar Matriu (Manual)");
            System.out.println("3 - Sortir");
            System.out.println("Selecciona: ");
            seleccio = demanaEnter(in);
            if (seleccio == 1) {
                int[][] matriu = generaMatriu();
            } else if (seleccio == 2) {
                int[][] matriu = demanaMatriu();
            } else if (seleccio != 3) {
                System.out.println("Opció no vàlida torna a intentar-ho...");
            }
        } while (comprova(seleccio) != 3);
        System.out.println("Has sortit amb éxit.");
    }

    public static int[][] demanaMatriu() {
        int files, columnes;
        Scanner in2 = new Scanner(System.in);
        System.out.println("CREACIÓ | Número de files: ");
        files = demanaEnter(in2);
        System.out.println("CREACIÓ | Número de columnes: ");
        columnes = demanaEnter(in2);
        int[][] matriu = new int[files][columnes];
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.println("Posició MATRIU [" + i + "]" + "["
                        + j + "]");
                matriu[i][j] = demanaEnter(in2);
            }
        }
        mostraMatriu(matriu);
        return matriu;
    }

    public static int[][] generaMatriu() {
        int files, columnes, NumMin, NumMax;
        Scanner in2 = new Scanner(System.in);
        System.out.println("CREACIÓ | Número de files: ");
        files = demanaEnter(in2);
        System.out.println("CREACIÓ | Número de columnes: ");
        columnes = demanaEnter(in2);
        System.out.println("CREACIÓ | Mínim de la matriu: ");
        NumMin = demanaEnter(in2);
        System.out.println("CREACIÓ | Màxim de la matriu: ");
        NumMax = demanaEnter(in2);
        int[][] matriu = new int[files][columnes];
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                matriu[i][j] = (int) Math.floor(Math.random() * (NumMax - NumMin + 1) + NumMin);
            }
        }
        mostraMatriu(matriu);
        return matriu;
    }

    public static int comprova(int seleccio) {
        switch (seleccio) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                System.out.println("Opció no vàlida torna a intentar-ho...");
                break;
        }
        return seleccio;
    }

    public static void mostraMatriu(int[][] matriu) {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print("|");
                System.out.print(matriu[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }

    }

    public static int demanaEnter(Scanner in) {
        boolean correcte = false;
        int num = 0;

        do {
            if (!in.hasNextInt()) {
                System.out.println("Número invàlid...");
            } else {
                num = in.nextInt();
                correcte = true;
            }
            in.nextLine();
        } while (correcte != true);
        return num;
    }
}
