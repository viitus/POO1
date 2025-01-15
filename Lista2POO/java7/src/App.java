import javax.swing.*;
import java.util.ArrayList;

public class App {
    //cria array de veiculos
    private static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] opcoes = {
                    "Cadastrar um veículo",
                    "Listar todos os veículos",
                    "Buscar veículo por modelo",
                    "Exibir condições de financiamento de um veículo",
                    "Sair"};
            //string com as opcoes da tela 
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Sistema de Veículos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,opcoes,opcoes[0]);
                //cria a tela de opcoes 
            switch (escolha) {//chama a funcao dependendo da escolha 
                case 0:
                    cadastrarVeiculo();
                    break;
                case 1:
                    listarVeiculos();
                    break;
                case 2:
                    buscarVeiculoPorModelo();
                    break;
                case 3:
                    exibirCondicoesFinanciamento();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;
            }
        }
    }

    private static void cadastrarVeiculo() {
        String[] tipos = {"Carro", "Moto", "Caminhão"};
        //string com as opções da tela
        int tipoEscolha = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de veículo para cadastrar:",
                "Cadastro de Veículo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,tipos,tipos[0]);
        //cria a tela de opcoes
        String modelo = JOptionPane.showInputDialog("Digite o modelo do veículo:");
        String marca = JOptionPane.showInputDialog("Digite a marca do veículo:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do veículo:"));
        //chama o metodo para cada modelo escolhido
        switch (tipoEscolha) {
            case 0:
                veiculos.add(new Carro(modelo, marca, preco));
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
                break;
            case 1:
                veiculos.add(new Moto(modelo, marca, preco));
                JOptionPane.showMessageDialog(null, "Moto cadastrada com sucesso!");
                break;
            case 2:
                veiculos.add(new Caminhao(modelo, marca, preco));
                JOptionPane.showMessageDialog(null, "Caminhão cadastrado com sucesso!");
                break;
        }
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) { //mensagem de erro
            JOptionPane.showMessageDialog(null, "Nenhum veículo cadastrado.");
            return;
        }
        //cria string com todos os detalhes 
        StringBuilder detalhes = new StringBuilder("Veículos cadastrados:\n");
        for (Veiculo veiculo : veiculos) { //passa por todos veiculos do vetor 
            detalhes.append(veiculo.exibirDetalhes()).append("\n");//adiciona a string detalhes
        }
        JOptionPane.showMessageDialog(null, detalhes.toString());//exibe a string completa
    }

    private static void buscarVeiculoPorModelo() {
        String modeloBusca = JOptionPane.showInputDialog("Digite o modelo do veículo que deseja buscar:");
        for (Veiculo veiculo : veiculos) { //busca por todos veiculos do array 
            if (veiculo.getModelo().equalsIgnoreCase(modeloBusca)) { //ao encontrar o modelo chama o metodo que exibe detalhes
                JOptionPane.showMessageDialog(null, "Veículo encontrado:\n" + veiculo.exibirDetalhes());
                return;
            }
        }
        //mensagem de erro 
        JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
    }


    private static void exibirCondicoesFinanciamento() {
        //recebe o modelo que deseja buscar
        String modeloBusca = JOptionPane.showInputDialog("Digite o modelo do veículo para financiamento:");
        Veiculo veiculoEncontrado = null;
    
        for (Veiculo veiculo : veiculos) { //busca no array de veiculos pelo modelo
            if (veiculo.getModelo().equalsIgnoreCase(modeloBusca)) {
                veiculoEncontrado = veiculo; // retorna na variavel o veiculo correto
                break;
            }
        }
        //mensagem se o veicullo nao foi encontrado na busca
        if (veiculoEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }
    
        int meses = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de meses para o financiamento:"));
        //recebe a quantidade de meses que deseja finaciar 
        if (veiculoEncontrado instanceof Financiavel) {
            Financiavel financiavel = (Financiavel) veiculoEncontrado; 
            //verifica o número de meses para financiamento de acordo com o tipo de veículo
            if (veiculoEncontrado instanceof Carro && meses > 60) {
                JOptionPane.showMessageDialog(null, "O financiamento de carros é permitido apenas até 60 meses.");
            } else if (veiculoEncontrado instanceof Moto && meses > 48) {
                JOptionPane.showMessageDialog(null, "O financiamento de motos é permitido apenas até 48 meses.");
            } else if (veiculoEncontrado instanceof Caminhao && meses > 72) {
                JOptionPane.showMessageDialog(null, "O financiamento de caminhões é permitido apenas até 72 meses.");
            } else { //se o numero de meses for valido, calculara a parcela e exibe as condiçoes
                double parcela = financiavel.calcularParcela(meses);
                JOptionPane.showMessageDialog(
                        null,financiavel.exibirCondicoesFinanciamento() +
                        "\nQuantidade de meses: " + meses +"\nValor da parcela: R$ " + String.format("%.2f", parcela)
                );
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este veículo não suporta financiamento.");
        }
        
      
    }
    
}
