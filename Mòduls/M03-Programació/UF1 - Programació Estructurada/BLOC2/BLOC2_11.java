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
public class BLOC2_11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int quantitat,descompte;

        System.out.println("Escriu una quantitat: ");
        quantitat = in.nextInt();
        descompte = 0;

        if (quantitat < 1000) {
            descompte = (int) (quantitat * 0.05);
            System.out.print("S'ha fet un descompte del " + descompte + "%");

        } else {
            System.out.print("S'ha fet un descompte del " + descompte + "%");
            descompte = (int) (quantitat * 0.10);
        }
        System.out.println(" la quantitat final es de " + quantitat);
    }
}
