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
public class BLOC2_Extra4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numero1 = 0, numero2 = 0, suma = 0, resta = 0, producte = 0, divisio = 0;
        
        suma = numero1 + numero2;
        System.out.println("Escriu el primer número: ");
        numero1 = in.nextInt();
        System.out.println("Escriu el segon número: ");
        numero2 = in.nextInt();
        System.out.println("Escriu l'operació: ");
        String operacio = in.next();
       
        if (operacio == "suma"){
        System.out.println("La suma dels números es: " + suma);        
        }
        else if (operacio == "resta"){
        System.out.println("La resta dels números es: " + resta);             
        }
    }
}
