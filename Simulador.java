import java.util.ArrayList;

/**
 * Classe que representa um protótipo inicial de um
 * simulador de trânsito.
 * 
 * @author Julio César Alves
 * @version 2023.11.09
 */
public class Simulador
{
    private ArrayList<Carro> carros;
    private ArrayList<Caminhao> caminhoes;

    /**
     * Construtor para objetos da classe Simulador
     */
    public Simulador()
    {
        carros = new ArrayList<>();
        caminhoes = new ArrayList<>();
    }

    /**
     * Cadastra um carro no simulador
     */
    public void adicionarCarro(String modelo, String marca, String placa, boolean ehFlex) {
        Carro carro = new Carro(modelo, marca, placa, ehFlex);
        carros.add(carro);
    }

    /**
     * Cadastra um caminhao no simulador
     */
    public void adicionarCaminhao(String modelo, String marca, String placa, int capacidadeDeCarga) {
        Caminhao caminhao = new Caminhao(modelo, marca, placa, capacidadeDeCarga);
        caminhoes.add(caminhao);
    }
    
    /**
     * Mudar a velocidade atual de um carro
     */
    public void mudarVelocidadeCarro(String modelo, int novaVelocidade) {
        Carro carro = buscarCarro(modelo);
        if (carro != null) {
            carro.definirVelocidadeAtual(novaVelocidade);
            System.out.println("Velocidade do carro " + modelo + " alterada!");
        }
        else {
            System.out.println("Carro " + modelo + " não encontrado!");
        }
    }
    
    /**
     * Retorna um objeto carro da coleção de carros com o 
     * modelo passado. Se não encontrar, retorna null.
     */
    private Carro buscarCarro(String modelo) {
        for (Carro carro : carros) {
            if (carro.obterModelo().equals(modelo)) {
                return carro;
            }
        }
        return null;
    }
    
    /**
     * Mudar a velocidade atual de um caminhao
     */
    public void mudarVelocidadeCaminhao(String modelo, int novaVelocidade) {
        Caminhao caminhao = buscarCaminhao(modelo);
        if (caminhao != null) {
            caminhao.definirVelocidadeAtual(novaVelocidade);
            System.out.println("Velocidade do caminhao " + modelo + " alterada!");
        }
        else {
            System.out.println("Caminhao " + modelo + " não encontrado!");
        }
    }
    
    /**
     * Retorna um objeto caminhao da coleção de caminhoes com o 
     * modelo passado. Se não encontrar, retorna null.
     */
    private Caminhao buscarCaminhao(String modelo) {
        for (Caminhao caminhao : caminhoes) {
            if (caminhao.obterModelo().equals(modelo)) {
                return caminhao;
            }
        }
        return null;
    }
    
    /**
     * Exibe no terminal os dados de todos os veículos do simulador
     */
    public void exibirDadosVeiculos() {
        System.out.println("Dados dos veiculos:");
        
        for (Carro carro : carros) {
            System.out.println(carro.obterDescricao());
        }
        
        for (Caminhao caminhao : caminhoes) {
            System.out.println(caminhao.obterDescricao());
        }
    }
}
