import javax.swing.JOptionPane;

public class Video extends Midia {
    //atributos
    private String diretor; 
    private int duracao;

    //construtora
    public Video(String titulo, int ano, String diretor, int duracao) {
        super(titulo, ano);
        this.diretor = diretor;
        this.duracao = duracao;
    }

    //getters e setters
    public String getDiretor() {
        return diretor;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    //metodos para video
    @Override
    public void reproduzir() {
        JOptionPane.showMessageDialog(null, "Reproduzindo vídeo: " + getTitulo() + " dirigido por " + diretor);
    }

    @Override
    public String exibirDetalhes() {
        return "Tipo: Vídeo\n" +
               "Título: " + getTitulo() + "\n" +
               "Ano: " + getAno() + "\n" +
               "Diretor: " + diretor + "\n" +
               "Duração: " + duracao + " minutos";
    }
    
    //metodo de cadastro 
    public static Video cadastrar() {
        String titulo = JOptionPane.showInputDialog("Digite o título do vídeo:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do vídeo:"));
        String diretor = JOptionPane.showInputDialog("Digite o diretor do vídeo:");
        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Digite a duração do vídeo (em minutos):"));
        return new Video(titulo, ano, diretor, duracao);
    }
}