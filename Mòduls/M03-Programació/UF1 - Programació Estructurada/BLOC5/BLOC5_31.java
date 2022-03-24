/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC5;

/**
 *
 * @author Ángel
 */
public class BLOC5_31 {
    public static void main(String[] args) {
        int venedors = 0, productes = 0;
        int[][] vendes = new int[venedors][productes];
        // Introduir dades i mostrar
        for (int i = 0; i < venedors; i++){
            for (int j = 0; j < productes; j++) {
                vendes[i][j] = (int) (Math.random() * 50);
                System.out.println(vendes[i][j]);
            }
            System.out.println("");
        }
        
        int sum = 0, maxVenedor = 0, maxVendes = 0;
        for (int i= 0; i < venedors; i++) {
            for (int j = 0; j < productes; j++){
                sum = sum + vendes[i][j];
            }
            System.out.println("Venedor " + i + " : " + sum);
            if ( i == 0) {
                maxVenedor = i;
                maxVendes = sum;
            }
            else {
                if (sum > maxVendes) {
                 maxVenedor = i;
                 maxVendes = sum;                   
                }
            }
        }
    }
}
