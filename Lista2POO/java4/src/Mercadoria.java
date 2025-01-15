public class Mercadoria extends Produto {
    private double peso; //declara atributo 

    //funcao contrutora
    public Mercadoria(String nome, int codigo, double peso){
        super(nome, codigo); //herda os atributos da classe pai 
        this.peso = peso;
    }

    //metodo get
    public double getPeso(){
        return peso;
    }

    //metodo set
    public void setPeso(double peso) {
        this.peso = peso;
    }

    //metodo para exibir informações
    public String mostrarDetalhes() {
        return "Mercadoria: " + nome + " | Código: " + codigo + " | Peso: " + peso + " kg";
    }
}
