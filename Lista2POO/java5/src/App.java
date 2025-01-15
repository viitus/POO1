import javax.swing.*;
import java.util.ArrayList;


public class App {
    private static ArrayList<ContaBancaria> contas = new ArrayList<>(); // cria vetor de contas

    public static void main(String[] args) {

        // loop principal
        while (true) {
            String[] opcoes = {                 // vetor de opções da tela inical
                    "Criar Conta Corrente",     // 0
                    "Criar Conta Poupança",     // 1
                    "Sacar",                    // 2
                    "Depositar",                // 3
                    "Verificar Saldo",          // 4
                    "Sair"};                    // 5

            // escolha uma das opcoes
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Caixa Eletrônico",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);// opção padrão

            switch (escolha) {    //recebe a escolha e vai para cada caso
                case 0: 
                    criarContaCorrente(); //uma funcao para cada caso
                    break;
                case 1: 
                    criarContaPoupanca();
                    break;
                case 2: 
                    realizarSaque();
                    break;
                case 3: 
                    realizarDeposito();
                    break;
                case 4: 
                    verificarSaldo();
                    break;
                case 5:       // sai do programa
                    JOptionPane.showMessageDialog(null, "Saindo do caixa...");
                    return;
            }
        }
    }

    // metodo de criação de conta corrente 
    private static void criarContaCorrente() {
        //recebe a string de senha 
        String senha = JOptionPane.showInputDialog("Digite uma senha para a conta corrente:");
        if (senha == null || senha.isEmpty()) { //verifica se esta vazia 
            JOptionPane.showMessageDialog(null, "A senha não pode ser vazia.");
            return;
        }
        int numero = contas.size() + 1; //incrementa o numero da conta
        //cria nova conta e adiciona os dados nescessarios 
        ContaCorrente conta = new ContaCorrente(senha, numero, 0.0, 500.0); //valor do cheque especial arbitrario
        contas.add(conta); //adiciona conta a lista de contas
        //mensagem de conta criada e exibe o numero da conta 
        JOptionPane.showMessageDialog(null, "Conta Corrente criada.\nNúmero: " + numero);
    }

    //metodo de criação de conta poupança
    private static void criarContaPoupanca() {
        String senha = JOptionPane.showInputDialog("Digite uma senha para a conta:");
        if (senha == null || senha.isEmpty()) { //verifica se esta vazia igual a conta poupança
            JOptionPane.showMessageDialog(null, "A senha não pode ser vazia!");
            return;
        }
        int numero = contas.size() + 1;
        ContaPoupanca conta = new ContaPoupanca(senha, numero, 0.0, 0.02); //valor da taxa de rendimento arbitrario
        contas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta Poupança criada.\nNúmero: " + numero);
    }

    //metodo de busca de contas
    private static ContaBancaria buscarConta(int numero, String senha) {
        for (ContaBancaria conta : contas) { //verifica no vetor de contas se senha e numero conferem
            if (conta.getNumero() == numero && conta.getSenha().equals(senha)) { 
                return conta; //retorna a conta em questão
            }
        }
        return null;
    }

    //metodo de busca de numero de conta
    private static ContaBancaria buscaNumConta(int numero) {
        for (ContaBancaria conta: contas){
            if (conta.getNumero() == numero){ //busca pelo numero da conta sem verificar senha 
                return conta;
            }
        }
        return null;
    }

    //metodo de saque 
    private static void realizarSaque() {
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
            String senha = JOptionPane.showInputDialog("Digite a senha:");
            ContaBancaria conta = buscarConta(numero, senha); //busca a conta correnpondente aos valores digitados
            if (conta != null) {
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a sacar:"));
                conta.saca(valor); //realiza o saque
                JOptionPane.showMessageDialog(null, "Saque realizado.\nSaldo atual: R$ " + conta.getSaldo());
            } else { //mensagem caso nao exista conta criada
                JOptionPane.showMessageDialog(null, "Conta inválida");
            }
        } catch (Exception e) { //mensagem de erro caso tente sacar valor invalido
            JOptionPane.showMessageDialog(null, "Erro ao realizar o saque: " + e.getMessage());
        }
    }

    //metodo de deposito 
    private static void realizarDeposito() {
        //recebe o numero da conta
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        //busca a conta correspondente a ao numero da conta 
        //nao usa o metodo buscaConta, pois nao é nescessario senha para deposito nesse caso
        ContaBancaria conta = buscaNumConta(numero);    
        
        if (conta != null) { //veridfica se a conta existe 
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar:"));
            conta.setSaldo(conta.getSaldo() + valor); //adiciona valor ao saldo 
            JOptionPane.showMessageDialog(null, "Depósito realizado.\nSaldo atual: R$ " + conta.getSaldo());
        } else { //mensagem se conta nao existir 
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
        }
    }

    private static void verificarSaldo() {
        //recebe numero e senha e busca 
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        String senha = JOptionPane.showInputDialog("Digite a senha:");
        ContaBancaria conta = buscarConta(numero, senha); //busca por conta correspondente
        if (conta != null) { //mensagem com as informações da conta 
            JOptionPane.showMessageDialog(null,"Número: " + conta.getNumero() + "\nSaldo: R$ " + conta.getSaldo());
        } else { //mensagem de erro
            JOptionPane.showMessageDialog(null, "Conta ou senha inválida!");
        }
    }
}
