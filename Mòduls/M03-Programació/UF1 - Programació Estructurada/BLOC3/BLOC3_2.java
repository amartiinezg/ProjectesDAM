/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC3;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC3_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double preuh, hores, hextras, preuextra, sou;

        for (int i = 1; i <= 4; i++) {
            System.out.println("Quantes hores ha fet el treballador " + i + "?");
            hores = in.nextDouble();
            System.out.println("A quina quantitat es paga l'hora?");
            preuh = in.nextDouble();
            if (hores > 40) {
                hextras = hores - 40;
                preuextra = preuh * 1.5;
                sou = (preuh * hores) + (hextras * preuextra);
                System.out.println("Al treballador " + i + " li pertoca " + sou + "€");
            } else {
                sou = preuh * hores;
                System.out.println("Al treballador " + i + " li pertoca " + sou + "€");
            }
        }
    }
}
