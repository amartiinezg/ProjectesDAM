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
public class BLOC3_19 {
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int contador = 0;
        System.out.println("Escriu una frase: ");
        String frase = in.nextLine();

        for (int i = frase.length() - 1; i >= 0; i--) {
            if (frase.charAt(i) == 'a'){
                contador++;
            }
            else if (frase.charAt(i) == 'e'){
                contador++;
            }
            else if (frase.charAt(i) == 'i'){
                contador++;
            }
            else if (frase.charAt(i) == 'o'){
                contador++;
            }
            else if (frase.charAt(i) == 'u'){
                contador++;
            }
        }
        System.out.println("La frase conte les vocals " + contador + " vegades.");
    }  
}
