import javax.swing.JOptionPane;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int numeroAleatorio = aleat(); //chama o metodo que cria o numero aleatorio
        int tentativas = 0; //inicializa o contador de tentativas em 0
        int chute; //cria a variavel de chute 
        
        do {
            //exibe a mensagem de inicio do jogo e recebe o primeiro chute
            chute = Integer.parseInt(JOptionPane.showInputDialog("Tente adivinhar o número entre 1 e 100:"));
            tentativas++; //adiciona 1 ao contador de tentativas
            
            if (chute > numeroAleatorio) { //verifica se o chute é maior menor ou igual ao numero secreto
                JOptionPane.showMessageDialog(null, "O número é menor que " + chute + ". Tente novamente.");
            } else if (chute < numeroAleatorio) {
                JOptionPane.showMessageDialog(null, "O número é maior que " + chute + ". Tente novamente.");
            } else { //caso acertado o chute exibe o numero de tentativas 
                JOptionPane.showMessageDialog(null, "Parabéns! Você acertou o número " + numeroAleatorio +  " em " + tentativas + " tentativas.");
            }
            
        } while (chute != numeroAleatorio); //verifica se o chute foi acertado e repete o loop se não
    }

    public static int aleat() { //usa a biblioteca java.util.random
        Random random = new Random();
        return random.nextInt(100) + 1; //gera numero entre 1 e 100
    }
}
