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
public class Problema_DPT {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int distancia = 10000, velocitatm, velocitatm2, segons;
        double velocitat;
        System.out.println("Escriu el límit de velocitat en Km/h: ");
        velocitatm = in.nextInt();
        System.out.println("Escriu els segons que ha trigat el vehicle: ");
        segons = in.nextInt();
        velocitat = (double) ((distancia / segons) * 3.6);
        velocitatm2 = (int) (velocitatm + (velocitatm * 0.20));

        if (velocitat < velocitatm) {
            System.out.println("El vehicle anaba a " + velocitat + " Km/h y circulaba correctament");
        } else if ((velocitat > velocitatm) && velocitat < velocitatm2) {
            System.out.println("El vehicle anaba a " + velocitat + " Km/h y per tant MULTA");
        } else {
            System.out.println("El vehicle anaba a " + velocitat + " Km/h y han tret 3 PUNTS");
        }

    }
}
