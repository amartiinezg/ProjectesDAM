/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC3;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC3_Factorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, factorial = 1;
        System.out.println("Escriu el numero: ");
        num = in.nextInt();        
        
        for (int i = num; i > 0; i--) {   
            factorial = factorial * i;
        }
        System.out.println("El factorial és " + factorial);
        System.out.println("La darrere xifra és " + (factorial % 10));
    }
}
