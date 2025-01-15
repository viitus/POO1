public class Caminhao extends Veiculo implements Financiavel {

    public Caminhao(String modelo, String marca, double preco) {
        super(modelo, marca, preco);
    }

    @Override
    public void vender() {
        System.out.println("Caminhão " + getModelo() + " vendido!");
    }

    @Override
    public String exibirDetalhes() {
        return "Caminhão \nModelo: " + getModelo() + ", \nMarca: " + getMarca() + ", \nPreço: R$ " + getPreco();
    }

    @Override
    public double calcularParcela(int meses) {
        double taxaJuros = 0.15; // Taxa de juros de 15%
        double precoComJuros = getPreco() * (1 + taxaJuros);
        return precoComJuros / meses;
    }

    @Override
    public String exibirCondicoesFinanciamento() {
        return "Financiamento de Caminhão:\nTaxa de juros: 15%\nParcelamento disponível em até 72 meses.";
    }
}
