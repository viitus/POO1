public class Carro extends Veiculo implements Financiavel {

    public Carro(String modelo, String marca, double preco) {
        super(modelo, marca, preco);
    }

    @Override
    public void vender() {
        System.out.println("Carro " + getModelo() + " vendido!");
    }

    @Override
    public String exibirDetalhes() {
        return "Carro \nModelo: " + getModelo() + ", \nMarca: " + getMarca() + ", \nPreço: R$ " + getPreco();
    }

    @Override
    public double calcularParcela(int meses) {
        double taxaJuros = 0.10; // Taxa de juros de 10%
        double precoComJuros = getPreco() * (1 + taxaJuros);
        return precoComJuros / meses;
    }

    @Override
    public String exibirCondicoesFinanciamento() {
        return "Financiamento de Carro:\nTaxa de juros: 10%\nParcelamento disponível em até 60 meses.";
    }
}
