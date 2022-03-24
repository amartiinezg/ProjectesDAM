/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC4;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class ARRAY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float suma=0;
        
        float [] inventari = new float [10];
        
        for (int i = 0; i < inventari.length; i++) {
            inventari[i] = in.nextFloat();
            suma = inventari[i] + suma;
        }
        System.out.println("La mitjana de l'array es " + suma/inventari.length);
        }
}
