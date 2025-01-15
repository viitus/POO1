public abstract class Midia {
    //atributos 
    private String titulo; 
    private int ano;       

    //construtora
    public Midia(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    //getters
    public String getTitulo() {
        return titulo;
    }
    public int getAno() {
        return ano;
    }

    //setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    //metodos abstratos
    public abstract void reproduzir();
    public abstract String exibirDetalhes();
}
