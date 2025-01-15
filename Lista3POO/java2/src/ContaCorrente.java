class ContaCorrente extends ContaBancaria {
    private int quantidadeTransacoes;
    private double limiteChequeEspecial;

    public ContaCorrente(String senha, int numero, double limiteChequeEspecial) {
        super(senha, numero);
        this.quantidadeTransacoes = 0;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (getSaldo() - valor >= -limiteChequeEspecial) {
            setSaldo(getSaldo() - valor);
            quantidadeTransacoes++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Limite do Cheque Especial = " + limiteChequeEspecial + "\nTransações = " + quantidadeTransacoes;
    }
}