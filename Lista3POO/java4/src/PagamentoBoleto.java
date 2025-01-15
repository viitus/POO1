class PagamentoBoleto extends Pagamento {
    private String codigoBoleto;

    public PagamentoBoleto(double valor, String codigoBoleto) {
        super(valor * 0.9); // Aplicando 10% de desconto
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public String processar() {
        return String.format("Pagamento via Boleto processado com sucesso! Código: %s, Valor com desconto: R$%.2f", codigoBoleto, valor);
    }
}