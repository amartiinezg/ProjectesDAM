/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC1;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Ángel
 */
public class BLOC1_7_RaizQuadrada {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double num, resultat;

        System.out.println("Intro primer número: ");
        num = in.nextDouble();

        resultat = Math.sqrt(num);
        System.out.println("La raiz quadrada de " + num + " és " + resultat);
    }

}
