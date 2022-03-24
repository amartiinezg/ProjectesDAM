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
public class BLOC4_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            if (i % 2 != 0) {
                System.out.println("TAULA DEL " + i + ": ");
                for (int m = 1; m < 11; m++){
                System.out.println(i + " x " + m + " = " + (i*m));
                }
            }
            
        }
    }
}   
