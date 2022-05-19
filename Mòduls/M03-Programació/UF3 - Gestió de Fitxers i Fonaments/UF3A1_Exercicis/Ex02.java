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
public class Ex02 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       
       File f = new File(in.nextLine());
       
       if(f.exists()){
           System.out.println("El fitxer existeix.");
       }
       else{
           System.out.println("El fitxer no existeix.");
       }
    }   
}
