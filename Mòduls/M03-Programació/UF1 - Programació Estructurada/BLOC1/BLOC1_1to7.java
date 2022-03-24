/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC1;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC1_1to7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1, n2, suma, producte, resto;
        System.out.println("Intro primer número: ");
        n1 = in.nextInt();
        System.out.println("Intro segon número: ");
        n2 = in.nextInt();

        suma = n1 + n2;
        producte = n1 * n2;
        resto = n1 % n2;
        System.out.println("La suma és " + suma);
        System.out.println("La multiplicació és " + producte);
        System.out.println("El resto és " + resto);
    }

}
