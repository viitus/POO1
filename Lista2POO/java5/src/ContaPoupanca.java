class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento; //argumento

    public ContaPoupanca(String senha, int numero, double saldo, double taxaRendimento) {
        super(senha, numero, saldo);//contrutora
        this.taxaRendimento = taxaRendimento;
    }

    //get
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    //set
    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    //metodo de saque da conta poupança 
    public void saca(double valor) {
        if (getSaldo() - valor >= 0) { //verifica se existe salto suficiente para sacar 
            setSaldo(getSaldo() - valor); //atualiza o saldo
        } else { //mensagem de erro
            throw new IllegalArgumentException("Saldo insuficiente. Não é permitido saldo negativo.");
        }
    }
}