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
public class Ex09 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String path = "C:\\Users\\Ángel\\Documents\\1 DAM\\M03 Programació\\UF3\\CarpetaFitxers\\";

        File f = new File(path + "f");
        File a = new File(f + "\\hi.txt");

        System.out.println(f);
        if (!f.exists()) {
            f.mkdir();
            a.createNewFile();
        } else {
            a.delete();
            f.delete();
            System.out.println("S'ha esborrat el directori ja existent");
        }
    }
}
