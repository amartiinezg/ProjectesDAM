
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Practica1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean primer;
        int numero = 1;

        int[] vector = new int[in.nextInt()];
        for (int i = 0; i < vector.length; i++) {
            primer = false;
            while (!primer) {
                numero++;
                if (esNombrePrimer(numero)) {
                    primer = true;
                    vector[i] = numero;
                }
            }
        }
        mostrarVector(vector);
    }

    static boolean esNombrePrimer(int nombre) {
        if (nombre == 0 || nombre == 1 || nombre == 4) {
            return false;
        }
        for (int x = 2; x < nombre / 2; x++) {
            if (nombre % x == 0) {
                return false;
            }
        }
        return true;
    }

    static void mostrarVector(int[] primers) {
        int cont = 0;
        for (int i = 0; i < primers.length; i++) {
            if (i == primers.length - 1) {
                System.out.print(primers[i] + ".");
            } else {
                System.out.print(primers[i] + ", ");
            }
            cont++;
            if (cont == 10) {
                cont = 0;
                System.out.println("");
            }
        }
    }
}
