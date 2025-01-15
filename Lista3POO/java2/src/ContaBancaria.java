abstract class ContaBancaria {
    private String senha;
    private int numero;
    private double saldo;

    public ContaBancaria(String senha, int numero) {
        this.senha = senha;
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getSenha() {
        return senha;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
  
    public void depositar(double valor) {
        saldo += valor;
    }
  
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean sacar(double valor);

    @Override
    public String toString() {
        return "Conta número = " + numero + "\nSaldo = " + saldo + "\n";
    }
}