/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Exercicis;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex01_Calculadora {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Primer número: ");
        float n1 = in.nextFloat();
        System.out.println("Segon número: ");
        float n2 = in.nextFloat();
        System.out.println("SUMA | " + (n1 + n2));
        System.out.println("RESTA | " + (n1 - n2));
        System.out.println("MULTIPLICACIÓ | " + (n1*n2));
        System.out.println("DIVISIÓ | " + (n1/n2));
    }
}
