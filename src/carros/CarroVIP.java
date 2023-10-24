package carros;

public class CarroVIP extends Carro {
    
    public CarroVIP(int codigo, String modelo) {
        super(codigo, modelo);
    }
    
    public static double diaria = 350.00;

    @Override 
    public double devolver(){

        double valorDevolucao = super.devolver();
        
        if (valorDevolucao != 0.0) {
            return super.getNumDias()*diaria;
        }
        return 0;
    }
}