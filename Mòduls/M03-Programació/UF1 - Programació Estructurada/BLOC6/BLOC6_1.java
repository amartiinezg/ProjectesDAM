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
public class BLOC6_1 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        classFilm pelicula[] = new classFilm[3];
        
        //Intro info
        for (int i = 0; i < pelicula.length; i++){
            System.out.println("Titol: ");
            String titol = in.nextLine();
            System.out.println("Director:");
            String director = in.nextLine();
            System.out.println("Tipus:");
            String tipus = in.nextLine();
            
            pelicula[i] = new classFilm(titol, director, tipus);
            }
        imprimeix(pelicula);
    }
    public static void imprimeix(classFilm filmografia[]){
        System.out.println("Impressió de l'array");
        for (int i = 0; i < filmografia.length; i++) {
        filmografia[i].imprimeix();
        }
    }
    
}
