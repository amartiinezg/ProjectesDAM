/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC6;

/**
 *
 * @author Ángel
 */
public class classAlumnes5 {

    private String nom;
    private float mat1;
    private String mat1N;
    private float mat2;
    private String mat2N;
    private float mat3;
    private String mat3N;

    public classAlumnes5() {
        this.nom = "";
        this.mat1 = 0;
        this.mat1N = "";
        this.mat2 = 0;
        this.mat2N = "";
        this.mat3 = 0;
        this.mat3N = "";
    }

    public classAlumnes5(String nom, float mat1, String mat1N, float mat2, String mat2N, float mat3, String mat3N) {
        this.nom = nom;
        this.mat1 = mat1;
        this.mat1N = mat1N;
        this.mat2 = mat2;
        this.mat2N = mat2N;
        this.mat3 = mat3;
        this.mat3N = mat3N;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMat1() {
        return mat1;
    }

    public void setMat1(float mat1) {
        this.mat1 = mat1;
    }

    public String getMat1N() {
        return mat1N;
    }

    public void setMat1N(String mat1N) {
        this.mat1N = mat1N;
    }

    public float getMat2() {
        return mat2;
    }

    public void setMat2(float mat2) {
        this.mat2 = mat2;
    }

    public String getMat2N() {
        return mat2N;
    }

    public void setMat2N(String mat2N) {
        this.mat2N = mat2N;
    }

    public float getMat3() {
        return mat3;
    }

    public void setMat3(float mat3) {
        this.mat3 = mat3;
    }

    public String getMat3N() {
        return mat3N;
    }

    public void setMat3N(String mat3N) {
        this.mat3N = mat3N;
    }

    public void imprimeix() {
        System.out.println("-------");
        System.out.println(this.nom);
        System.out.println("-------");
        System.out.println(this.mat1N + ": " + this.mat1);
        System.out.println(this.mat2N + ": " + this.mat2);
        System.out.println(this.mat3N + ": " + this.mat3);
        System.out.println("");
    }
}
