import javax.swing.JOptionPane;

public class Musica extends Midia {
    //novos atributos
    private String artista;
    private String album;

    //construtora
    public Musica(String titulo, int ano, String artista, String album) {
        super(titulo, ano);
        this.artista = artista;
        this.album = album;
    }

    //getters
    public String getArtista() {
        return artista;
    }
    public String getAlbum() {
        return album;
    }
    //setters
    public void setAlbum(String album) {
       this.album = album;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    //metodos para musicas
    @Override
    public void reproduzir() {
        JOptionPane.showMessageDialog(null, "Tocando música: " + getTitulo() + " de " + artista);
    }

    @Override 
    public String exibirDetalhes() { //cria string de detalhes  
        return "Tipo: Música\n" +
               "Título: " + getTitulo() + "\n" +
               "Ano: " + getAno() + "\n" +
               "Artista: " + artista + "\n" +
               "Álbum: " + album;
    }

    //metodo de cadastro 
    public static Musica cadastrar() {
        String titulo = JOptionPane.showInputDialog("Digite o título da música:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano da música:"));
        String artista = JOptionPane.showInputDialog("Digite o artista da música:");
        String album = JOptionPane.showInputDialog("Digite o álbum da música:");
        return new Musica(titulo, ano, artista, album);
    }
}
