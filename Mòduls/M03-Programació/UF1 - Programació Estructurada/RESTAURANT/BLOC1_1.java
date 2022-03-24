/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RESTAURANT;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC1_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int intents = 3;
        while (intents == 0){
            System.out.println("Usuari: ");
            String acc = in.nextLine();
            System.out.println("Contrasenya: ");
            String pass = in.nextLine();
            if (acc.equals("angel") && pass.equals("1920")) {
                System.out.println("Ok, Has entrat");
            } else {
                System.out.println("Aquest usuari no existeix. Queden " + intents + " intents.");
                intents--;
            }
        }

    }
}
