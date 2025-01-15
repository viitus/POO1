import javax.swing.JOptionPane;

public class Podcast extends Midia {
    private String anfitriao; //atributos
    private int episodio;

    //construtora
    public Podcast(String titulo, int ano, String anfitriao, int episodio) {
        super(titulo, ano);
        this.anfitriao = anfitriao;
        this.episodio = episodio;
    }

    //getters e setters
    public String getAnfitriao() {
        return anfitriao;
    }
    public int getEpisodio() {
        return episodio;
    }
    public void setAnfitriao(String anfitriao) {
        this.anfitriao = anfitriao;
    }
    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    //metodos para podcast
    @Override
    public void reproduzir() {
        JOptionPane.showMessageDialog(null, "Tocando podcast: Episódio " + episodio + " de " + getTitulo() + " com " + anfitriao);
    }

    @Override
    public String exibirDetalhes() {
        return "Tipo: Podcast\n" +
               "Título: " + getTitulo() + "\n" +
               "Ano: " + getAno() + "\n" +
               "Anfitrião: " + anfitriao + "\n" +
               "Episódio: " + episodio;
    }
    
    //metodo de cadastro 
    public static Podcast cadastrar() {
        String titulo = JOptionPane.showInputDialog("Digite o título do podcast:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do podcast:"));
        String anfitriao = JOptionPane.showInputDialog("Digite o anfitrião do podcast:");
        int episodio = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do episódio:"));
        return new Podcast(titulo, ano, anfitriao, episodio);
    }
}
