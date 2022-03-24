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
public class BLOC2_Extra2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c;

        System.out.println("Escriu un valor per A: ");
        a = in.nextInt();
        System.out.println("Escriu un valor per B: ");
        b = in.nextInt();
        System.out.println("Escriu un valor per C: ");
        c = in.nextInt();
        if (a > b) {
            if (a > c) {
                System.out.println("A(" + a + ") es el major");
            } else {
                System.out.println("C(" + c + ") es el major");
            }
        } else if (b > c) {
            System.out.println("B(" + b + ") es el major");
        } else {
            System.out.println("C(" + c + ") es el major");
        }
    }

}
