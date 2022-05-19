/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A1_Exercicis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex11 {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Ángel\\Documents\\1 DAM\\M03 Programació\\UF3\\CarpetaFitxers\\";
        File carpeta = new File(path);
        File[] arrayElements = carpeta.listFiles();
        System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:");
        //Per recórrer un array, s'usa un bucle
        for (File f : arrayElements) {
            if (f.isDirectory()) {
                System.out.print("[DIR] ");
            } else {
                System.out.print("[FIT] ");
            }
            System.out.println(f.getName());
        }
    }
}
