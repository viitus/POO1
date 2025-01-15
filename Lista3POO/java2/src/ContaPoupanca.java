class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;

    public ContaPoupanca(String senha, int numero) {
        super(senha, numero);
        this.taxaRendimento = 0.12;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Taxa de Rendimento = " + taxaRendimento;
    }
}