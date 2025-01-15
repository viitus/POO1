import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // listas para armazenar Animais e localizaçoes 
        ArrayList<Animal> animais = new ArrayList<>();
        ArrayList<Localizacao> localizacoes = new ArrayList<>();
        
        while (true) {
            // opcoes do menu
            String[] opcoes = {
                    "Inserir animal",
                    "Excluir animal",
                    "Inserir localização de animal",
                    "Procurar localização de animal",
                    "Sair"};
            // tela de menu de opcoes
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Sistema de Observação de Animais",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0: 
                    inserirAnimal(animais);
                    break;
                case 1: 
                    excluirAnimal(animais, localizacoes);
                    break;
                case 2: 
                    inserirLocalizacao(animais, localizacoes);
                    break;
                case 3: 
                    procurarAnimal(animais, localizacoes);
                    break;
                case 4: // Sair do programa
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;    
            }
        }
    }

    // método para inserir um animal na lista
    public static void inserirAnimal(ArrayList<Animal> animais) {
        // solicita o ID
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do animal:"));
        // verifica se existe um animal com o mesmo ID
        for (Animal animal : animais) {
            if (animal.getId() == id) {
                JOptionPane.showMessageDialog(null, "Erro: Já existe um animal com o ID " + id + ".");
                return; // sai do metodo sem cadastrar
            }
        }
        // solicita os outros dados do animal
        String nome = JOptionPane.showInputDialog("Informe o nome do animal:");
        String especie = JOptionPane.showInputDialog("Informe a espécie do animal:");
        // adiciona o animal a lista
        animais.add(new Animal(id, nome, especie));
        JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
    }

    // metodo para excluir um animal e suas localizações
    public static void excluirAnimal(ArrayList<Animal> animais, ArrayList<Localizacao> localizacoes) {
        // solicita o ID
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do animal a ser excluído:"));
        boolean encontrado = false; 
        // percorre a lista de animais para localizar o ID
        for (Animal animal : animais) {
            if (animal.getId() == id) {
                animais.remove(animal); // remove o animal da lista
                encontrado = true;
                break;
            }
        }
        // se o animal foi encontrado, remove suas localizações
        if (encontrado) {
            localizacoes.removeIf(localizacao -> localizacao.getIdAnimal() == id); // remove todas as localizações com aquele ID
            JOptionPane.showMessageDialog(null, "Animal e suas localizações removidos com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Animal com ID " + id + " não encontrado.");
        }
    }

    // metodo para inserir uma localização para um animal
    public static void inserirLocalizacao(ArrayList<Animal> animais, ArrayList<Localizacao> localizacoes) {
        // solicita o ID
        int idAnimal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do animal:"));
        Animal animalEncontrado = null;
        // verifica se o animal existe
        for (Animal animal : animais) {
            if (animal.getId() == idAnimal) {
                animalEncontrado = animal;
                break;
            }
        }
        // Se o animal nao for encontrado, exibe mensagem de erro
        if (animalEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Animal com ID " + idAnimal + " não encontrado.");
            return;
        }
        // recebe a latitude e longitude da localização
        double latitude = Double.parseDouble(JOptionPane.showInputDialog("Informe a latitude:"));
        double longitude = Double.parseDouble(JOptionPane.showInputDialog("Informe a longitude:"));
        // cria a localização e o adiciona a lista
        Localizacao localizacao = new Localizacao(idAnimal, latitude, longitude);
        localizacoes.add(localizacao);
        JOptionPane.showMessageDialog(null, "Localização cadastrada com sucesso.");
    }

    // metodo para buscar um animal
    public static void procurarAnimal(ArrayList<Animal> animais, ArrayList<Localizacao> localizacoes) {
        // solicita o ID
        int idAnimal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do animal para consulta:"));
        Animal animalEncontrado = null;
        // busca o animal na lista
        for (Animal animal : animais) {
            if (animal.getId() == idAnimal) {
                animalEncontrado = animal;
                break;
            }
        }
        // se o animal nao for encontrado, exibe mensagem de erro
        if (animalEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Animal com ID " + idAnimal + " não encontrado.");
            return;
        }
        // monta String com os dados do animal
        StringBuilder resultado = new StringBuilder("Dados do Animal com ID: ");
        resultado.append(idAnimal).append(".\n");
        resultado.append(animalEncontrado.toString()).append("\n");
        resultado.append("Localizações do Animal:\n");
        boolean localizacaoEncontrada = false;
        // busca localizações do animal
        for (Localizacao localizacao : localizacoes) {
            if (localizacao.getIdAnimal() == idAnimal) {
                resultado.append(localizacao.toString()).append("\n");
                localizacaoEncontrada = true;
            }
        }
        // mensagem se nenhuma localização for encontrada
        if (!localizacaoEncontrada) {
            resultado.append("Nenhuma localização encontrada para o animal com ID ").append(idAnimal).append(".");
        }
        // exibe a string resultado
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}