public class Moto extends Veiculo implements Financiavel {

    public Moto(String modelo, String marca, double preco) {
        super(modelo, marca, preco);
    }

    @Override
    public void vender() {
        System.out.println("Moto " + getModelo() + " vendida!");
    }

    @Override
    public String exibirDetalhes() {
        return "Moto \nModelo: " + getModelo() + ", \nMarca: " + getMarca() + ", \nPreço: R$ " + getPreco();
    }

    @Override
    public double calcularParcela(int meses) {
        double taxaJuros = 0.05; // Taxa de juros de 5%
        double precoComJuros = getPreco() * (1 + taxaJuros);
        return precoComJuros / meses;
    }

    @Override
    public String exibirCondicoesFinanciamento() {
        return "Financiamento de Moto:\nTaxa de juros: 5%\nParcelamento disponível em até 48 meses.";
    }
}
