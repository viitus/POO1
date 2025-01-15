import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<ContaBancaria> contas = new ArrayList<>();

        while (true) {
            String[] opcoes = {
                    "Criar Conta Corrente", 
                    "Criar Conta Poupança", 
                    "Sacar", 
                    "Depositar", 
                    "Verificar Saldo", 
                    "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Escolha uma opção:", 
                    "Sistema Bancário",
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0:
                    criarContaCorrente(contas);
                    break;
                case 1:
                    criarContaPoupanca(contas);
                    break;
                case 2:
                    sacar(contas);
                    break;
                case 3:
                    depositar(contas);
                    break;
                case 4:
                    verificarSaldo(contas);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;
            }
        }
    }

    private static void criarContaCorrente(ArrayList<ContaBancaria> contas) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta:"));
        String senha = JOptionPane.showInputDialog("Informe a senha da conta:");
        double limite = Double.parseDouble(JOptionPane.showInputDialog("Informe o limite do cheque especial:"));
        contas.add(new ContaCorrente(senha, numero, limite));
        JOptionPane.showMessageDialog(null, "Conta Corrente criada com sucesso!");
    }

    private static void criarContaPoupanca(ArrayList<ContaBancaria> contas) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta:"));
        String senha = JOptionPane.showInputDialog("Informe a senha da conta:");
        contas.add(new ContaPoupanca(senha, numero));
        JOptionPane.showMessageDialog(null, "Conta Poupança criada com sucesso!");
    }

    private static void sacar(ArrayList<ContaBancaria> contas) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta:"));
        String senha = JOptionPane.showInputDialog("Informe a senha da conta:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado:"));

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero && conta.getSenha().equals(senha)) {
                if (conta.sacar(valor)) {
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Saque não permitido. Verifique o saldo ou limite.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Conta não encontrada ou senha incorreta.");
    }

    private static void depositar(ArrayList<ContaBancaria> contas) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta:"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser depositado:"));

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                conta.depositar(valor);
                JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Conta não encontrada.");
    }

    private static void verificarSaldo(ArrayList<ContaBancaria> contas) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta:"));
        String senha = JOptionPane.showInputDialog("Informe a senha da conta:");

        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero && conta.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, conta.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Conta não encontrada ou senha incorreta.");
    }
}
