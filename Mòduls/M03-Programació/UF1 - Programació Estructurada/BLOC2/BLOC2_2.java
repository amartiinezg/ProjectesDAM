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
public class BLOC2_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numero, numero2;

        System.out.println("Escriu un valor al primer: ");
        numero = in.nextInt();
        System.out.println("Escriu un valor al segon: ");
        numero2 = in.nextInt();

        if (numero == numero2) {
            System.out.println("Els números son iguals");
        } else if (numero > numero2) {
            System.out.println("El número " + numero + " es més gran que " + numero2);
        } else {
            System.out.println("El número " + numero2 + " es més gran que " + numero);
        }
    }
}
