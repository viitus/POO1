import javax.swing.*;
import java.util.ArrayList;

public class App {

    private static ArrayList<Midia> midias = new ArrayList<>(); // cria vetor de midias

    public static void main(String[] args) {

        //loop principal
        while (true) {
            String[] opcoes = { //vetor de opções
                    "Cadastrar uma mídia",
                    "Listar todas as mídias",
                    "Buscar mídia por título",
                    "Reproduzir uma mídia",
                    "Sair"};
            //escolhe uma das opcoes
            int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Escolha uma opção:",
                    "Painel de midia",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    cadastrarMidia();
                    break;
                case 1:
                    listarMidias();
                    break;
                case 2:
                    buscarMidia();
                    break;
                case 3:
                    reproduzirMidia();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;
            }
        }
    }

    //metodo para cadastrar midia
    private static void cadastrarMidia() {
        String[] opcoes = { "Musica","Video","Podcast"};
        int escolha = JOptionPane.showOptionDialog(
            null, 
            "Qual tipo de mídia deseja cadastrar?",
            "Painel de midia",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null, opcoes, opcoes[0]);
        //escolhe qual tipo de midia ira cadastrar e aciona o metodo correto
        switch (escolha) {
            case 0://usa o metodo para cada classe que foi chamada
                midias.add(Musica.cadastrar());
                JOptionPane.showMessageDialog(null, "Música cadastrada com sucesso!");
                break;
            case 1:
                midias.add(Video.cadastrar());
                JOptionPane.showMessageDialog(null, "Vídeo cadastrado com sucesso!");
                break;
            case 2:
                midias.add(Podcast.cadastrar());
                JOptionPane.showMessageDialog(null, "Podcast cadastrado com sucesso!");
                break;
        }
    }

    //metodo para listar midias cadastradas
    private static void listarMidias() {
        if (midias.isEmpty()) { //mensagem de erro caso nao exista midia cadastrada
            JOptionPane.showMessageDialog(null, "Nenhuma mídia cadastrada.");
            return;
        }
        //cria a string que combina a string de com todos cadastros 
        StringBuilder detalhes = new StringBuilder("Mídias cadastradas:\n");
        for (Midia midia : midias) {
            detalhes.append("---- Detalhes da Mídia ----\n");
            detalhes.append(midia.exibirDetalhes()).append("\n"); //chama o método de detalhes de cada classe
            detalhes.append("----------------------------\n");
        }
        //exibe a string completa com todos detalhes 
        JOptionPane.showMessageDialog(null, detalhes.toString(), "Lista de Mídias", JOptionPane.INFORMATION_MESSAGE);
    }

    //matodo para bsucar midias cadastradas
    private static void buscarMidia() {
        String tituloBusca = JOptionPane.showInputDialog("Digite o título da mídia que deseja buscar:");
        for (Midia midia : midias) { //procura por todas midias do array
            if (midia.getTitulo().equalsIgnoreCase(tituloBusca)) { //ignora diferenca de CAPS
                JOptionPane.showMessageDialog(null, "Mídia encontrada:");
                midia.exibirDetalhes();//exibe detalhes
                return;
            }
        }
        //mesagem de erro caso nao encontre
        JOptionPane.showMessageDialog(null, "Mídia não encontrada.");
    }

    //metodo de reprodução
    private static void reproduzirMidia() {
        String tituloReproduzir = JOptionPane.showInputDialog("Digite o título da mídia que deseja reproduzir:");
        for (Midia midia : midias) { //procura por todas midias 
            if (midia.getTitulo().equalsIgnoreCase(tituloReproduzir)) {
                midia.reproduzir();//reproduz a mensagem do metodo 
                return;
            }
        }
        //mensagem de erro caso nao encontre
        JOptionPane.showMessageDialog(null, "Mídia não encontrada.");
    }
}
