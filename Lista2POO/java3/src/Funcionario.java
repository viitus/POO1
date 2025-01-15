public class Funcionario {
    private String nome; //cria os atributos da classe 
    private String CPF;
    private Cargo funcao;

    //funcao contrutora
    public Funcionario(String nome, String CPF, Cargo funcao){
        this.nome = nome;
        this.CPF = CPF;
        this.funcao = funcao;
    }

    //funcoes get
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Cargo getFuncao() {
        return funcao;
    }

    //funcao de exibição
    public String toString(){
        return "Nome: " + nome + ", CPF: " + CPF + ", " + funcao.toString();
    }
}
