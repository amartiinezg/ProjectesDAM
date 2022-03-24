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
public class BLOC3_15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Escriu el teu nom: ");
        String nom = in.nextLine();

        System.out.println("Hola " + nom);
        System.out.println("La longitud del teu nom es " + nom.length()
                + " i la posició 3 es " + nom.charAt(3));

        System.out.println("Escriu el nom d'una altre persona: ");
        String nom2 = in.nextLine();

        if (nom.equals(nom2) == true) {
            System.out.println("El nom es igual");
        } else {
            System.out.println("El nom es diferent");
        }
        System.out.println(nom.toUpperCase() + " en majúscules");
        System.out.println(nom2.toLowerCase() + " en minúscules");
    }
}
