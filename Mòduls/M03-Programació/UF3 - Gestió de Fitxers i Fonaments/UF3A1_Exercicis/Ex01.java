/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A1_Exercicis;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex01 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String[] fitxers;
       
       File f = new File(in.nextLine());
       
       fitxers = f.list();
       
       for(String fitxer : fitxers){
           System.out.println(fitxer);
       }
    }
}
