class PagamentoCartao extends Pagamento {
    private double aVista = 0.85; 
    private double juros = 0.02;
    private boolean isAvista;
    private int numParcelas;

    public PagamentoCartao(double valor) {
        super(valor);
    }

    public void definirAvista() {
        this.isAvista = true;
    }

    public void definirParcelado(int numParcelas) {
        if (numParcelas == 0){
            this.isAvista = true;
        }else{
            this.isAvista = false;
            this.numParcelas = numParcelas;
        }
    }

    @Override
    public String processar() {
        if (isAvista) {
            double valorComDesconto = valor * aVista;
            return String.format("Pagamento com Cartão à vista processado com sucesso! Valor com desconto: R$%.2f", valorComDesconto);
        } else {
            double valorComJuros = valor * (1 + juros * numParcelas);
            double valorParcela = valorComJuros / numParcelas;
            return String.format(
                "Pagamento parcelado em %d vezes. Valor total com juros: R$%.2f. Valor de cada parcela: R$%.2f",
                numParcelas, valorComJuros, valorParcela);
        }
    }
}