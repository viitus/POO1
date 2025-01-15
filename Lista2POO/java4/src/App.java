import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Mercadoria> mercadorias = new ArrayList<>(); //cria array do tipo mercadoria
        ArrayList<Servico> servicos = new ArrayList<>(); //cria array do tipo servico
        int opcao = 0; //inicia a variavel de opção 

        while (opcao != 5) { //verifica se é a opção se saida
            //menu de opções
            String menu = "1 - Cadastrar Mercadoria\n"
                        + "2 - Cadastrar Serviço\n"
                        + "3 - Buscar Dados de Mercadoria\n"
                        + "4 - Buscar Dados de Serviço\n"
                        + "5 - Sair";
            //cria o painel de opções 
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE));

            switch (opcao) { //seleciona a opção desejada
                case 1:
                    cadastraMercadoria(mercadorias);
                    break;
                case 2:
                    cadastraServico(servicos);
                    break;
                case 3:
                    buscaMercadoria(mercadorias);
                    break;
                case 4:
                    buscaServico(servicos);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Fechando programa...");
                    break; //mensagem de saida
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break; //mensagem de erro caso escolha uma opção invalida
            }
        }
    }

    //metodo para cadastro de mercadoria
    public static void cadastraMercadoria(ArrayList<Mercadoria> mercadorias) { //recebe o array de mercadorias
        String nome = JOptionPane.showInputDialog("Informe o nome da mercadoria:"); //recebe as informações
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da mercadoria:"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da mercadoria(kg):"));
        //adiciona as informações a mercadoria 
        Mercadoria mercadoria = new Mercadoria(nome, codigo, peso);
        mercadorias.add(mercadoria); //adiciona um espaço ao array
        //mensagem de sucesso 
        JOptionPane.showMessageDialog(null, "Mercadoria cadastrada.");
    }

    //metodo para o cadastro do serviço
    public static void cadastraServico(ArrayList<Servico> servicos) { //recebe o array de serviços 
        String nome = JOptionPane.showInputDialog("Informe o nome do serviço:");//recebe as informações
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do serviço:"));
        double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor por hora do serviço(R$):"));
        //adiciona as informações ao serviço
        Servico servico = new Servico(nome, codigo, valorHora);
        servicos.add(servico);
        //mensagem de sucesso
        JOptionPane.showMessageDialog(null, "Serviço cadastrado.");
    }

    //metodo de busca de mercadoria
    public static void buscaMercadoria(ArrayList<Mercadoria> mercadorias) { 
        String nomeBusca = JOptionPane.showInputDialog("Informe o nome da mercadoria a ser buscada:");
        boolean encontrado = false; //cria a variavel booleana
        for (Mercadoria mercadoria : mercadorias) { //passa por todas mercadorias do vetor 
            if (mercadoria.getNome().equalsIgnoreCase(nomeBusca)) { //verica se existe uma mercadoria com o mesmo nome digitado(ignorando maiusculo/minusculo)
                JOptionPane.showMessageDialog(null, mercadoria.mostrarDetalhes()); //exibe mensagem com detalhes da mercadoria
                encontrado = true; //se encontrado sai do for 
                break;
            }
        }
        if (!encontrado) { //se nao encontrado exibe mensagem
            JOptionPane.showMessageDialog(null, "Mercadoria não encontrada.");
        }
    }

    //metodo de busca de serviço(igual o de mercadoria)
    public static void buscaServico(ArrayList<Servico> servicos) { 
        String nomeBusca = JOptionPane.showInputDialog("Informe o nome do serviço a ser buscado:");
        boolean encontrado = false;
        for (Servico servico : servicos) {
            if (servico.getNome().equalsIgnoreCase(nomeBusca)) {
                JOptionPane.showMessageDialog(null, servico.mostrarDetalhes());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Serviço não encontrado.");
        }
    }
}
