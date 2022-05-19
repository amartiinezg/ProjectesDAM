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
public class Ex03 {
        public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       
       File f = new File(in.nextLine());
       
       if(f.canRead()){
           System.out.println("Te permís de lectura.");
       }
       else{
           System.out.println("No te permis de lectura.");
       }
       if (f.canWrite()){
            System.out.println("Te permís de escriptura.");
        }      
       else{
           System.out.println("No te permis de escriptura");
       }
    }
}
