import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: "); // printf em C // exibe no terminal a mensagem  
        String nome = scanner.nextLine();        // scanf em C // recebe a string na variavel nome

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();         // recebe um numero inteiro na variavel idade

        System.out.println(nome + ", sua idade é: " + idade);  //exibe no terminal a mensagem completa 

        scanner.close();
    }
}
