/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXAMEN_UF1;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class Examen_P1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        int homes = 0, dones = 0, mitjanaEdat = 0,
                percentatjeHomes = 0, percentatjeDones = 0;
        boolean comença = true;
        while (comença == true){
            System.out.println("Nom: ");
            String nom = keyboard.nextLine();
            if (nom.equals("Final")){
            comença = false;
            }  
            if (comença == true) {
            System.out.println("Sexe (Home/Dona): ");
            String sexe = keyboard2.nextLine();
            System.out.println("Edat: ");
            int edat = in.nextInt();
            switch (sexe) {
                case "Home":
                    ++homes;
                    mitjanaEdat += edat;
                    break;
                case "Dona":
                    mitjanaEdat += edat;
                    ++dones;
                    break;
                default:
                    System.out.println("El sexe es incorrecte.");
                    break;

            }
            System.out.println(nom + edat);
        }
        }
        
        percentatjeDones = dones * 100 / dones + homes;
        percentatjeHomes = homes * 100 / homes + dones;
        System.out.println("La mitjana d'edat es de " + (mitjanaEdat / (homes + dones)));
        System.out.println("El percentatje de dones que hi ha es de " + percentatjeDones);
        System.out.println("El percentatje de homes que hi ha es de " + percentatjeHomes);
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package EXAMEN_UF1;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
/*
public class Examen_P1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        int homes = 0, dones = 0, mitjanaEdat = 0,
                percentatjeHomes = 0, percentatjeDones = 0;
        boolean comença = true;
        do {
            System.out.println("Sexe (Home/Dona): ");
            String sexe = keyboard2.nextLine();
            System.out.println("Edat: ");
            int edat = in.nextInt();
            switch (sexe) {
                case "Home":
                    ++homes;
                    mitjanaEdat += edat;
                    break;
                case "Dona":
                    mitjanaEdat += edat;
                    ++dones;
                    break;
                default:
                    System.out.println("El sexe es incorrecte.");
                    break;

            }
            System.out.println("Nom: ");
            String nom = keyboard.nextLine();
            if (nom.equals("Final")){
            comença = false;
            }
            System.out.println(nom + edat);
        } while (comença == true);
        
        percentatjeDones = (dones * 100) / homes + dones;
        percentatjeHomes = (homes * 100) / homes + dones;
        System.out.println("La mitjana d'edat es de " + (mitjanaEdat / (homes + dones)));
        System.out.println("El percentatje de dones que hi ha es de " + percentatjeDones);
        System.out.println("El percentatje de homes que hi ha es de " + percentatjeHomes);
    }
}
*/