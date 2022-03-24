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
public class BLOC4_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sumaPar=0, producteImpar=1;
        for (int i = 1; i <= 20; i++) {
            if(i%2 == 0){
            sumaPar = sumaPar + i;
            }
            else{
            producteImpar = producteImpar * i;
            }
        }
        System.out.println("La suma del parells es: " + sumaPar);
        System.out.println("El producte dels imparells es: " + producteImpar);
    }
}
