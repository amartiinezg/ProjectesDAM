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
public class BLOC5_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] lletres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'};
        System.out.println("Escriu la paraula: ");
        String paraula = in.nextLine();
        for (int n = 0; n < paraula.length(); n++) {
            for (int i = 0; i < lletres.length; i++) {
                if (paraula.charAt(i) == lletres[i]) {
                    System.out.println("Conte la lletra " + paraula.charAt(i) + "correcte.");
                }
            }
        }
        /*intro();
        comprova(lletres);*/

    }

    /*public static void intro() {
        Scanner in = new Scanner(System.in);
        String paraula = in.nextLine();
        comprova(paraula);
    }*/
 /*public static void comprova(char[] lletres, String paraula) {
        for (int i = 0; i < lletres.length; i++) {
            if(paraula.charAt(i) == lletres[i])
                
        }
    }*/
}
