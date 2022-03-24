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
public class BLOC3_9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int suspesos = 0, aprovats = 0, suf = 0, be = 0, notable = 0, excellent = 0;
        float nota;
        
        for (int i = 0; i < 10; i++) {
        System.out.println("Nota");
        nota = in.nextInt();
            if (nota >= 0 && nota <= 10){
                if (nota < 5) {
                suspesos++;
                } else {
                  aprovats++;
                }
                if (nota < 6){
                  suf++;
                }
                else if (nota < 7){
                  be++;
                }
                else if (nota < 9){
                  notable++;
                }
            }
    }

    }
}
