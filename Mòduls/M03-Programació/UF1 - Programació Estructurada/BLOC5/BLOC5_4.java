/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC5;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC5_4 {
    public static void main(String[] args) {
        int[] notes = new int[20];
        
        intro(notes);
        mitjana(notes);

    }
    
    public static void intro(int[] qualificacions) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < qualificacions.length; i++) {
            qualificacions[i] = in.nextInt();
        }
    }
    public static void mitjana(int[] qualificacions) {
        int suma = 0;
        for (int i = 0; i < qualificacions.length; i++) {
            suma += qualificacions[i];
        }
        System.out.println("La mitjana de notes es " + (float) suma/qualificacions.length);
    }
}
