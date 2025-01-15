public class Cargo {
    private String titulo; //cria os atributos 
    private double salario;

    public Cargo(String titulo, double salario){ //funcao contrutora
        this.titulo = titulo;
        this.salario = salario;
    }

    //funcoes get
    public String getTitulo(){
        return titulo;
    }

    public double getSalario(){
        return salario;
    }

    //funcao de exibição
    public String toString(){
        return "Cargo: " + titulo + ", Salario: R$" + salario;
    }
}
