import javax.swing.*;

public class App {
    public static void main(String[] args) {
        while (true) {
            String[] opcoes = { 
                    "Usar Carro", 
                    "Usar Bicicleta", 
                    "Usar Ônibus", 
                    "Sair" };
            int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Escolha uma opção:",
                    "Gerenciador de Transportes",
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0:
                    usarCarro();
                    break;
                case 1:
                    usarBicicleta();
                    break;
                case 2:
                    usarOnibus();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;
            }
        }
    }

    private static void usarCarro() {
        double consumoCombustivel = Double.parseDouble(JOptionPane.showInputDialog("Digite o consumo do carro (km/l):"));
        double precoCombustivel = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do combustível (R$/l):"));
        int lugaresOcupados = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de lugares ocupados no carro:"));
        Carro carro = new Carro(consumoCombustivel, precoCombustivel, lugaresOcupados);
        carro.iniciar();
        int lugaresTotais = carro.getLugaresTotais();
        if (lugaresOcupados > lugaresTotais) {
            JOptionPane.showMessageDialog(null, "Erro: Número de lugares ocupados excede o número total de lugares!");
            return;
        }
        double distanciaCarro = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância percorrida pelo carro (em km):"));
        
        double custoCarro = carro.calcularCusto(distanciaCarro);
        JOptionPane.showMessageDialog(null, carro.toString(distanciaCarro, custoCarro));
        carro.parar();
    }

    private static void usarBicicleta() {
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.iniciar();
        double distanciaBicicleta = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância percorrida pela bicicleta (em km):"));
        int tempoUso = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de uso da bicicleta (em minutos):"));
        bicicleta.registrarTempoDeUso(tempoUso);
        double custoBicicleta = bicicleta.calcularCusto(distanciaBicicleta);
        JOptionPane.showMessageDialog(null, bicicleta.toString(distanciaBicicleta, custoBicicleta));
        bicicleta.parar();
    }

    private static void usarOnibus() {
        double custoPorPassageiro = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço da passagem por passageiro (R$):"));
        double consumoCombustivel = Double.parseDouble(JOptionPane.showInputDialog("Digite o consumo do ônibus (km/l):"));
        double precoCombustivel = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do combustível (R$/l):"));
        int lugaresOcupados = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de lugares ocupados no ônibus:"));
        Onibus onibus = new Onibus(custoPorPassageiro, lugaresOcupados, consumoCombustivel, precoCombustivel);
        int lugaresTotais = onibus.getLugaresTotais();
        if (lugaresOcupados > lugaresTotais) {
            JOptionPane.showMessageDialog(null, "Erro: Número de lugares ocupados excede o número total de lugares!");
            return;
        }
        onibus.iniciar();
        double distanciaOnibus = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância percorrida pelo ônibus (em km):"));
        double custoOnibus = onibus.calcularCusto(distanciaOnibus);
        JOptionPane.showMessageDialog(null, onibus.toString(distanciaOnibus, custoOnibus));
        onibus.parar();
    }
}