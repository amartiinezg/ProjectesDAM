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
public class BLOC2_14 {
    public static void main(String[] args) {
        int segons, minuts, hores, dies, rsegons, rminuts, rhores, rdies;
        Scanner in = new Scanner(System.in);
        System.out.println("Segons: ");
        segons = in.nextInt();
        rsegons = segons % 60;
        minuts = segons / 60;
        rminuts = minuts % 60;
        hores = minuts / 60;
        rhores = hores % 60;
        dies = hores / 24;
        rdies = dies % 60;

       /** if (segons > 60) {
            minuts = segons / 60;
            rsegons = segons % 60;
        } else if (minuts > 60) {
            rminuts = minuts % 60;
            hores = minuts / 60;
        }**/
        System.out.print("Son " + hores + " Hores " + rminuts + " Minuts " + rsegons + " Segons");
    }
}
