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
public class Ex10 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String path = "C:\\Users\\Ángel\\Documents\\1 DAM\\M03 Programació\\UF3\\CarpetaFitxers\\";

        File f = new File(path + in.nextLine());

        if (f.exists()) {
            System.out.println("Nou nom: ");
            File name = new File(path + in.nextLine());
            f.renameTo(name);
        }
    }
}