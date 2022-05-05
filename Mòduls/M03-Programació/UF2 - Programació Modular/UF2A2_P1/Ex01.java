/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A2_P1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] paisos = new String[in.nextInt()];
        in.nextLine();
        paisos = generaVector(paisos, in);
        ordenaBombolla(paisos);
    
    }
    public static String[] generaVector(String[] paisos, Scanner in) {
        for(int i = 0; i < paisos.length; i++){
        paisos[i] = in.nextLine();
        }
        return paisos;
    }

    public static void ordenaBombolla(String[] paisos) {
        String temp;
        System.out.println("Països ordenats:");
        for (int j = 0; j < paisos.length; j++) {
            for (int i = j + 1; i < paisos.length; i++) {
                // comparing adjacent strings
                if (paisos[i].compareTo(paisos[j]) < 0) {
                    temp = paisos[j];
                    paisos[j] = paisos[i];
                    paisos[i] = temp;
                }
            }
            System.out.println(paisos[j]);
        }
    }
}
