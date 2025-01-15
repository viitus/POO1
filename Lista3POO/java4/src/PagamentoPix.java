public class PagamentoPix extends Pagamento {

    public PagamentoPix(double valor) {
        super(valor);
    }

    @Override
    public String processar() {
        return String.format("Pagamento via Pix: R$ %.2f processado com sucesso!", valor);
    }
}
