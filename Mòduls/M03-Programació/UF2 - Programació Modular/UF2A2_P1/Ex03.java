/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A2_P1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex03 {

public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>(); 
    int num = in.nextInt();
    in.nextLine();
    list = collectionSort(list, num, in);
    mostraVector(list);
}

    
public static ArrayList<String> collectionSort(ArrayList<String> list,int num, Scanner in) {
        for(int i = 0; i < num+1; i++){
        list.add(in.nextLine());
        }

        Collections.sort(list);

        return list;
    }
public static void mostraVector(ArrayList<String> vector) {
        System.out.println("Països ordenats:");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));

        }
        System.out.println("");

    }
}

