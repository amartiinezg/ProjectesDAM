/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC4.Array;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class ARRAY_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sumaPar = 0, sumaImpar = 0;

        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = in.nextInt();
            if (num[i] % 2 == 0) {
                sumaPar += num[i];
            } else {
                sumaImpar += num[i];
            }
        }
        System.out.println("La suma dels parells es " + sumaPar);
        System.out.println("La suma dels impars es " + sumaImpar);
    }
}
