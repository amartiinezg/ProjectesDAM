package BLOC5;

import java.util.Scanner;

public class classCotxe {

    private String marca;
    private String model;
    private int potencia;
    private boolean electric;
    
    public classCotxe(){
        this.marca = "";
        this.model = "";
        this.potencia = 0;
        this.electric = false;
    }
    
    public classCotxe(String mar, String mod, int pot, boolean elec){
        this.marca = mar;
        this.model = mod;
        this.potencia = pot;
        this.electric = elec;
    }    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        
        Scanner in = new Scanner(System.in);
        
        while ( potencia < 0 ){
            System.out.println("Error. La potència ha de ser positiva");
            potencia = in.nextInt();
        }
        
        
        this.potencia = potencia;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }
    
    
    public void imprimeix() {
        System.out.println("Marca: " + this.marca );
        System.out.println("Model: " + this.model );
        System.out.println("Potència: " + this.potencia );
        if ( this.electric == true  ) {
            System.out.println("El vehicle és elèctric");
        } else {
            System.out.println("El vehicle no és elèctric");
        }
    }
    
    public int augmentaPotencia(int increment) {
        this.potencia = this.potencia + increment;
        return this.potencia;
    }
    
}
