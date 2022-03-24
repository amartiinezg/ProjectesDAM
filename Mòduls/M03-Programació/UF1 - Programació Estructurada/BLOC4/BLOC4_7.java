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
public class BLOC4_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int multiple2 = 0, multiple5 = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                multiple2 = multiple2 + 1;
            }
            if (i % 5 == 0) {
                multiple5 = multiple5 + 1;
            }
        }
        System.out.println("Hi han " + multiple2 + " múltiples de 2");
        System.out.println("Hi han " + multiple5 + " múltiples de 5");
    }
}
