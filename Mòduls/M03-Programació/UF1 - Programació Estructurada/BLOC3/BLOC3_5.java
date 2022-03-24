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
public class BLOC3_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, mult;

        for (num = 2; num <= 10; num++) {
            for (mult = 0; mult <= 10; mult++) {
                System.out.println("(Taula del " + num + "): " + num + " * " + mult + "= " + num * mult);
            }
        }
    }
}
