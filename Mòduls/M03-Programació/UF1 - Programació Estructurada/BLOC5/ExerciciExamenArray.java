/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC5;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Ángel
 */
public class ExerciciExamenArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner fetboolean = new Scanner(System.in);
        System.out.println("Introdueix el total de alumnes: ");
        int row = in.nextInt();
        int[][] examen = new int[row][3];
        for (int i = 0; i < examen.length; i++) {
            System.out.println("L'alumne " + examen[0][i] + " ha fet l'examen? (S/N)");
            String fet = fetboolean.nextLine();
            if (fet.equals("S")) {
                for (int j = 0; j < examen[i].length; j++) {
                    switch (j) {
                        case 0:
                            System.out.println("Nota del 1r exercici: ");
                            examen[i][j] = in.nextInt();
                            break;
                        case 1:
                            System.out.println("Nota del 2n exercici: ");
                            examen[i][j] = in.nextInt();
                            break;
                        default:
                            System.out.println("Nota del 3r exercici: ");
                            examen[i][j] = in.nextInt();
                            break;
                    }
                }
            } else {
                Arrays.fill(examen[i], 0);
                System.out.println("No presentat");
            }
        }
    }
}
