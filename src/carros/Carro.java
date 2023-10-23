package carros;

public class Carro {
    
    // ---- Atributos de instância ----
    private int codigo;
    private String modelo;
    private boolean locado;
    private int numDias;

    // ---- Atributos de classe ----
    private static int numLocados = 0;
    private static double diaria = 200.00;

    // ---- Construtor ----
    public Carro(int codigo, String modelo){
        
        this.codigo = codigo;
        this.setModelo(modelo);
        this.locado = false;
    
    }

    // ---- Código ----
    public int getCodigo() {
        return codigo;
    }

    // ---- Modelo ----
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    // ---- Locado ----
    public boolean isLocado() {
        return locado;
    }

    // ---- numDias ----
    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int getNumDias() {
        return numDias;
    }

    // ---- diaria ----
    public static double getDiaria() {
        return diaria;
    }

    // ---- numLocados ----
    public static int getNumLocados() {
        return numLocados;
    }

    @Override
    public String toString() {
        return "Carro [codigo=" + codigo + ", modelo=" + modelo + ", locado=" + locado + ", numDias=" + numDias + "]";
    }

    public boolean locar(int numDias){
        
        if (!this.isLocado()){

            this.locado = true;
            this.setNumDias(numDias);
            numLocados ++;
            return true;
        }

        return false;
        
    }

    public double devolver(){

        if (this.isLocado()){

            this.locado = false;
            numLocados --;
            return this.getNumDias()*diaria;
        }
        
        return 0;

    }

}
