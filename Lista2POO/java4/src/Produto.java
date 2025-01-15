public abstract class Produto { 
    protected String nome; //atributos de nome e codigo
    protected int codigo;

    //construtora
    public Produto(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    //metodos get
    public String getNome(){
        return nome;
    }
    public int getcodigo(){
        return codigo;
    }

    //metodos set
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }   
}
