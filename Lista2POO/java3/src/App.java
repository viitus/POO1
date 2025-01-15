import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Funcionario> funcionarios = new ArrayList<>(); //cria array de funcionarios
        
        //Funcionario f1 = new Funcionario("Felipe", "11122233302", new Cargo("Analista", 5000.0));
        //Funcionario f2 = new Funcionario("Isabela", "99988877703", new Cargo("Gerente", 8000.0));
        //funcionarios.add(f1);
        //funcionarios.add(f2);
        //adiciona dois funcionarios exemplos na lista de funcionarios
        
        String[] opcoes = {"Cadastrar um funcionário", "Listar todos os funcionários", "Buscar funcionário por nome", "Sair"};
        //adiciona os valores as opções do painel
        int opcao;

        do {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                    //cria o painel de opções 

            switch (opcao) {
                case 0: 
                    String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                    String CPF = JOptionPane.showInputDialog("Digite o CPF do funcionário:");
                    String titulo = JOptionPane.showInputDialog("Digite o cargo:");
                    double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do cargo:"));
                    //recebe as informaçoes do funcionario
                
                    Cargo cargo = new Cargo(titulo, salario); //adiciona as informações ao cargo
                    Funcionario funcionario = new Funcionario(nome, CPF, cargo); //adiciona as informações ao funcionario

                    funcionarios.add(funcionario); //cria um espaço no array
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado."); //mensagem de sucesso
                    break;

                case 1: 
                    if (funcionarios.isEmpty()) { //mensagem de erro se nao existir funcionarios 
                        JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado.");
                    } else { //cria string de lista de funcionarios 
                        StringBuilder listaFuncionarios = new StringBuilder("Funcionários cadastrados:\n");
                        for (Funcionario f : funcionarios) { 
                            listaFuncionarios.append(f.toString()).append("\n"); //adiciona a quebra de linha ao final de cada item do array
                        }
                        JOptionPane.showMessageDialog(null, listaFuncionarios.toString());//exibe informações para cada funcionario do array
                    }
                    break;

                case 2: //cria a caixa de busca de funcionario
                    String nomeBusca = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                    boolean encontrado = false; 
                    for (Funcionario f : funcionarios) { //procura o nome do funcionario digitado
                        if (f.getNome().equalsIgnoreCase(nomeBusca)) { //verifica todos funcionarios do array ignorando diferença de maiusculo/minusculo
                            JOptionPane.showMessageDialog(null, "Funcionário encontrado:\n" + f.toString());
                            encontrado = true; //se encontrado para
                            break;
                        }
                    }
                    if (!encontrado) { //mensagem de erro caso nao encontrado
                        JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
                    }
                    break;

                case 3: //mensagem de encerramento
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
            }
        } while (opcao != 3); //verifica se escolheu a opção de encerramento
    }
}
