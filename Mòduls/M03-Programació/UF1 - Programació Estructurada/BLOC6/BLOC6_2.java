/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC6;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC6_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inNum = new Scanner(System.in);
        classLlibre llibre[] = new classLlibre[3];

        //Intro info
        for (int i = 0; i < llibre.length; i++) {
            System.out.println("ISBN: ");
            int isbn = inNum.nextInt();
            System.out.println("Titol: ");
            String titol = in.nextLine();
            System.out.println("Autor: ");
            String autor = in.nextLine();
            System.out.println("Editorial: ");
            String editorial = in.nextLine();
            System.out.println("Número de llibres: ");
            int numllibres = inNum.nextInt();
            System.out.println("Preu: ");
            float preu = inNum.nextFloat();

            llibre[i] = new classLlibre(isbn, titol, autor, editorial, numllibres, preu);
        }
        imprimeix(llibre);
        preuInventari(llibre);
    }

    public static void imprimeix(classLlibre llibres[]) {
        System.out.println("Impressió de l'array");
        for (int i = 0; i < llibres.length; i++) {
            llibres[i].imprimeix();
        }
    }

    public static void preuInventari(classLlibre llibres[]) {
        float valorInventari = 0;
        for (int i = 0; i < llibres.length; i++) {
            valorInventari += llibres[i].getPreu() * llibres[i].getNumllibres();
        }
        System.out.println("El valor total del inventari es: " + valorInventari + " €");
    }
}
