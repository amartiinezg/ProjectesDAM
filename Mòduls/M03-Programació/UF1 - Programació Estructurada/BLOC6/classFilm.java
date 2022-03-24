/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC6;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class classFilm {

    private String titol;
    private String director;
    private String tipus;

    public classFilm() {
        this.titol = "";
        this.director = "";
        this.tipus = "";
    }
    public classFilm(String tit, String dir, String tip){
        this.titol = tit;
        this.director = dir;
        this.tipus = tip;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    public void imprimeix() {
        System.out.println("Titol: " + this.titol );
        System.out.println("Director: " + this.director );
        System.out.println("Tipus: " + this.tipus );
    }
        
}
