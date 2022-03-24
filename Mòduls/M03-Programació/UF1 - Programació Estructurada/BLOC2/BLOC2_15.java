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
public class BLOC2_15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float nota;

        System.out.println("Escriu la nota: ");
        nota = in.nextFloat();

        if (nota < 4.99) {
            System.out.print("Es un suspens");

        } else if ((nota >= 5) && (nota < 5.99)) {
            System.out.print("Es un aprovat");
        } else if ((nota >= 6) && (nota < 6.99)) {
            System.out.print("Es un aprovat");
        } else if ((nota >= 7) && (nota < 7.99)) {
            System.out.print("Es un notable");
        } else if ((nota >= 9) && (nota < 10)) {
            System.out.print("Es un excelent");
        } else {
            System.out.print("Matrícula d'honor");
        }
    }
}
