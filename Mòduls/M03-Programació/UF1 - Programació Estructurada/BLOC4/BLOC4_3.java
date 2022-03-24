/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC4;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC4_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu un número: ");
        int numero = in.nextInt();
        int numeroMin = 0, numeroMedia = 0;
        for (int i = 1; i < 21; i++) {
            if (i == 1) {
                numeroMin = numero;
            }

            numero = numero * 2;
            System.out.println("Posición " + i + " es " + numero);
            if (i == 20) {
                numeroMedia = numero / i;
            }
        }
        System.out.println("El valor màxim es " + numero);
        System.out.println("El valor mínim es " + numeroMin);
        System.out.println("La media aritmètica es " + numeroMedia);
    }
}
