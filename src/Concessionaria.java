import java.util.ArrayList;

import carros.Carro;
import carros.CarroVIP;
import io.InOut;

public class Concessionaria {
    
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            
            // Menu de opções
            opcao = InOut.leInt("1 - Cadastrar \n2 - Alugar \n3- Devolver \n4-Sair");
           
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    alugar();
                    break;
                case 3:
                    devolver();
                    break;
                case 4:
                    InOut.msgDeInformacao("Concessionaria","Saindo...");
                    break;
                default:
                    InOut.msgDeAviso("Concessionaria","Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    
    public static void cadastrar() {
        
        // Código do carro que será cadastrado
        int codigoCarro = InOut.leInt("Digite o código do carro: ");
        
        // Carro já cadastrado
        if (pesquisa(codigoCarro) != -1){
            InOut.msgDeAviso("Cadastrar", "Carro com o código " + codigoCarro + " já cadastrado.");
        
        // Cadatra carro
        }else{
            
            // Tipo de carro - comum ou VIP
            int tipoCarro = InOut.leInt("Digite [1] para cadastrar um carro comum ou [2] para cadstrar um carro VIP:");
            
            // Carro comum
            if (tipoCarro == 1){
                
                // Modelo
                String modelo = InOut.leString("Digite o modelo do carro: ");
                
                // Instancia
                Carro carro = new Carro(codigoCarro, modelo);

                // Adiciona o carro a lista de carro da concessionária
                carros.add(carro);
                InOut.msgDeInformacao("Cadastrar","Carro cadastrado com sucesso!");
       
            }

            // Carro Vip
            else if (tipoCarro == 2){
                
                // Modelo
                String modelo = InOut.leString("Digite o modelo do carro: ");
                 
                // Instancia
                Carro carro = new CarroVIP(codigoCarro, modelo);

                // Adiciona o carro a lista de carro da concessionária
                carros.add(carro);
                InOut.msgDeInformacao("Cadastrar","Carro cadastrado com sucesso!");

            }

            // Opção inválida
            else{

                InOut.msgDeAviso("Cadastrar","Opção inválida");

            }

             
        }
        
    }

    public static void alugar() {
        
        // Código do carro que o usuário deseja alugar
        int codigo = InOut.leInt("Digite o código do carro que deseja alugar: ");
        
        // Posicao do carro no array
        int posicaoCarro = pesquisa(codigo);

        // Carro não cadastrado
        if (posicaoCarro == -1){
            
            InOut.msgDeAviso("Alugar", "Carro não cadastrado");
        
        // Carro cadastrado
        }else{
            
            Carro carroCadastrado = carros.get(posicaoCarro);
            
            // Carro já locado
            if (carroCadastrado.isLocado()){
                
                InOut.msgDeAviso("Alugar","O carro já está locado.");
            
            // Carro disponível
            }else{

                // Número de dias que o carro irá ficar locado
                int numDias = InOut.leInt("Digite o número de dias que deseja locar o carro: ");
                
                // Locação
                carroCadastrado.locar(numDias);
                
                // Mensagem
                InOut.msgDeInformacao("Alugar","Carro " + carroCadastrado.getModelo() +" locado com sucesso!");
            }
        }
    }

    public static void devolver() {

        // Código do carro que o usuário deseja alugar
        int codigo = InOut.leInt("Digite o código do carro que deseja devolver: ");

        int posicaoCarro = pesquisa(codigo);

        // Carro não encontrado
        if (posicaoCarro == -1){
            
            InOut.msgDeAviso("Devolver","Carro não encontrado");
        
        // Carro encontrado
        }else{        

            Carro carroEncontrado = carros.get(posicaoCarro);
            
            // Carro locado
            if (carroEncontrado.isLocado()){
                
                // Carro VIP
                if (carroEncontrado instanceof CarroVIP){
                    
                    CarroVIP carro = (CarroVIP) carroEncontrado;
                    
                    double devolucao = carro.devolver();
                    
                    InOut.msgDeInformacao("Devolver", "CarroVip " + carro.getModelo() +" Devolvido: Valor a pagar R$ " + devolucao);
                    
                
                }

                // Carro comum
                else{

                    Carro carro = (Carro) carroEncontrado;
                    double devolucao = carro.devolver();
                    InOut.msgDeInformacao("Devolver", "Carro " + carro.getModelo() +" Devolvido: Valor a pagar R$ " + devolucao);
      
                }
            
            // Carro não locado
            }else{

                InOut.msgDeAviso("Devolver", "O carro não está locado");
           
            }
        }
    }


    public static int pesquisa(int codigo) {

        int i = 0;

        // Percorre o arrayList
        for (Carro carro : carros) {

            // Verifica o código
            if (carro.getCodigo() == codigo) {
                
                // Retorna o indice do elemento caso ele seja encontrado
                return i;
            }
            i++;
        }
        
        // Retorna -1 caso o elemento não seja encontrado
        return -1;
    }
    

}