

package BLOC6;

public class pr7_departaments {
    
    private String nom;
    private int hores;
    private double sou;

    public pr7_departaments() {
    }

    public pr7_departaments(String nom, int hores, double sou) {
        this.nom = nom;
        this.hores = hores;
        this.sou = sou;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    @Override
    public String toString() {
        return "pr7_departaments{" + "nom=" + nom + ", hores=" + hores + ", sou=" + sou + '}';
    }
    
    
    
}