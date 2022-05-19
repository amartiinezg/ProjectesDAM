/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A1_Exercicis;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        File f = new File(in.nextLine());

        for (int i = 0; i < f.list().length; i++) {
            if (f.listFiles()[i].length() > 9100) {
                System.out.println(f.listFiles()[i] + " te un pes de "
                        + f.listFiles()[i].length());
            } else {
                System.out.println("El fitxer " + f.listFiles()[i] + " es més petit");
            }
        }
    }
}
