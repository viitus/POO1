public class Animal {
    private int id;
    private String nome;
    private String especie;

    public Animal(int id, String nome, String especie) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }

    // getters e setters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEspécie: " + especie;
    }
}
