/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC6;
/**
 *
 * @author Ángel
 */
public class classLlibre {
    private int isbn;
    private String titol;
    private String autor;
    private String editorial;
    private int numllibres;
    private float preu;

    public classLlibre() {
        this.isbn = 0;
        this.titol = "";
        this.autor = "";
        this.editorial = "";
        this.numllibres = 0;
        this.preu = 0;
    }
    public classLlibre(int isbn, String tit, String aut, String edit, int nllibres, float preu){
        this.isbn = isbn;
        this.titol = tit;
        this.autor = aut;
        this.editorial = edit;
        this.numllibres = nllibres;
        this.preu = preu;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumllibres() {
        return numllibres;
    }

    public void setNumllibres(int numllibres) {
        this.numllibres = numllibres;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }


    public void imprimeix() {
        System.out.println("ISBN: " + this.isbn );
        System.out.println("Titol: " + this.titol );
        System.out.println("Autor: " + this.autor );
        System.out.println("Editorial: " + this.editorial);
        System.out.println("Número de llibres (Botiga): " + this.numllibres);
        System.out.println("Preu: " + this.preu + " €");
        System.out.println("");
        System.out.println("--------");
        System.out.println("");
    }
        
}

