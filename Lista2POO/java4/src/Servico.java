public class Servico extends Produto {
    private double valorHora;//declara atributo 

    //funcao contrutora
    public Servico(String nome, int codigo, double valorHora){
        super(nome, codigo); //herda os atributos da classe pai 
        this.valorHora = valorHora;
    }

    //metodo get
    public double getValorHora(){
        return valorHora;
    }

    //metodo set
    public void setValorHora(double valorHora){
        this.valorHora = valorHora;
    }

    //metodo para exibir informações
    public String mostrarDetalhes() {
        return "Serviço: " + nome + " | Código: " + codigo + " | Valor por Hora: R$" + valorHora;
    }
}
