public abstract class ContaBancaria {
    private String senha; //argumentos
    private int numero;
    private double saldo;

    public ContaBancaria(String senha, int numero, double saldo) {
        this.senha = senha; //construtora
        this.numero = numero;
        this.saldo = saldo;
    }

    //gets
    public String getSenha() { 
        return senha; 
    }
    public double getSaldo() { 
        return saldo; 
    }
    public int getNumero() { 
        return numero; 
    }
    
    //sets
    public void setNumero(int numero) { 
        this.numero = numero; 
    }
    public void setSaldo(double saldo) { 
        this.saldo = saldo; 
    }
    public void setSenha(String senha) { 
        this.senha = senha; 
    }

    //metodo abstrato saca
    public abstract void saca(double valor);
}