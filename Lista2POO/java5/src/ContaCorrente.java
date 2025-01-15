class ContaCorrente extends ContaBancaria {
    //atributos
    private int transacoes;
    private double limiteChequeEspecial;

    //contrutora
    public ContaCorrente(String senha, int numero, double saldo, double limiteChequeEspecial) {
        super(senha, numero, saldo);
        this.transacoes = 0; //contagem de transasoes começa em 0
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    //gets
    public int getTransacoes() {
        return transacoes;
    }
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    //sets
    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    public void setTransacoes(int transacoes) {
        this.transacoes = transacoes;
    }

    //metodo saca para conta corrente
    @Override
    public void saca(double valor) {
        if (getSaldo() - valor + limiteChequeEspecial >= 0) { //verifica se tem saldo suficiente 
            setSaldo(getSaldo() - valor); //atualiza o saldo
            transacoes++; //+1 transação
        } else { //mensagem de erro
            throw new IllegalArgumentException("Saldo insuficiente, incluindo o limite do cheque especial.");
        }
    }
}

