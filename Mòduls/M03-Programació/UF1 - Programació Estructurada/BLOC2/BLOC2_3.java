/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC2;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC2_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numero;

        System.out.println("Escriu un valor: ");
        numero = in.nextInt();

        if (numero == 0) {
            System.out.println("Els número es 0");
        } else if (numero > 0) {
            System.out.println("El número " + numero + " es positiu");
        } else {
            System.out.println("El número " + numero + " es negatiu");
        }
    }
}
