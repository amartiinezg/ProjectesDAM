/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC5;

import java.util.Arrays;

/**
 *
 * @author Ángel
 */
public class ArrayBidimensional {

    public static void main(String[] args) {
        int[][] prova2d = new int[3][3];
        int num = 1;

        for (int i = 0; i < prova2d.length; i++) {
            for (int j = 0; j < prova2d[i].length; j++) {
                prova2d[i][j] = num;
                num = num * 2;
                System.out.print(prova2d[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }

        System.out.println("");
        /*Array con la mitad de 1 y de 0*/
        int[][] prova3d = new int[3][3];
        num = 1;
        for (int i = 0; i < prova3d.length; i++) {
            for (int j = 0; j < prova3d[i].length; j++) {
                if (i == j) {
                    prova3d[i][j] = num;
                }
                System.out.print(prova3d[i][j]);

                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Array con la mitad de 1 y de 0 pero invertido
        int[][] prova4d = new int[3][3];
        num = 1;
        for (int i = 0; i < prova4d.length; i++) {
            for (int j = 0; j < prova4d[i].length; j++) {
                if (i + j == prova4d.length - 1) {
                    prova4d[i][j] = num;
                }
                System.out.print(prova4d[i][j]);

                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Array multiplicando con base 2
        int[][] prova5d = new int[4][5];
        num = 1;
        for (int i = 0; i < prova5d.length; i++) {
            for (int j = 0; j < prova5d[i].length; j++) {
                prova5d[i][j] = num;
                num = num * 2;
                System.out.print(prova5d[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Array sumando en la fila y multiplicando en 2 la columna
        int[][] prova6d = new int[4][5];
        int sum = 0, sumT = 0;
        for (int i = 0; i < prova6d.length; i++) {
            num = i;
            for (int j = 0; j < prova6d[i].length; j++) {
                prova6d[i][j] = num;
                num = num * 2;
                sum += prova6d[i][j];
                sumT += prova6d[i][j];
                System.out.print(prova6d[i][j]);
                System.out.print(" ");
            }
            System.out.print(" SUMA = " + sum);
            sum = 0;
            System.out.println("");
        }
        System.out.println("La suma total és " + sumT);
        
    }
}
        