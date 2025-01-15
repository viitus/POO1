import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static List<Pagamento> pagamentos = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        while (true) {
            String[] opcoes = {
                "Pagamento com Pix",
                "Pagamento com Boleto",
                "Pagamento com Cartão",
                "Processar Todos os Pagamentos",
                "Sair"
            };

            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Sistema de Pagamentos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, opcoes, opcoes[0]
            );

            switch (escolha) {
                case 0: processarPix();
                    break;
                case 1: processarBoleto();
                    break;
                case 2: processarCartao();
                    break;
                case 3: mostrarResultados();
                    break;
                case 4: JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    return;
            }
        }
    }

    private static void processarPix() {
        double valorPix = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pagamento via Pix:"));
        pagamentos.add(new PagamentoPix(valorPix));
    }

    private static void processarBoleto() {
        double valorBoleto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pagamento via Boleto:"));
        String codigoBoleto = JOptionPane.showInputDialog("Digite o código do boleto:");
        pagamentos.add(new PagamentoBoleto(valorBoleto, codigoBoleto));
    }

    private static void processarCartao() {
        double valorCartao = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pagamento via Cartão:"));
        PagamentoCartao pagamentoCartao = new PagamentoCartao(valorCartao);

        String[] opcoesCartao = {"À vista", "Parcelado"};
        int escolhaCartao = JOptionPane.showOptionDialog(
            null,
            "Escolha a forma de pagamento:",
            "Pagamento com Cartão",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null, opcoesCartao, opcoesCartao[0]
        );

        if (escolhaCartao == 0) {
            pagamentoCartao.definirAvista();
        } else if (escolhaCartao == 1) {
            int numParcelas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de parcelas:"));
            pagamentoCartao.definirParcelado(numParcelas);
        }

        pagamentos.add(pagamentoCartao);
    }

    private static void mostrarResultados() {
        StringBuilder resultado = new StringBuilder("Resultados dos Pagamentos:\n\n");
        for (Pagamento pagamento : pagamentos) {
            resultado.append(pagamento.processar()).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}