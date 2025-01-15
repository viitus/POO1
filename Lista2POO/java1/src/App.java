import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar = 's'; //variavel que controla se o programa ira repetir

        while (continuar == 's') { //verifica se o loop vai acontecer
            System.out.print("Informe o valor de a: ");
            double a = scanner.nextDouble();//recebe o valor de a
            while (a == 0) { //verifica se a é 0 e pede outro valor para continuar, para evitar divisão por 0
                System.out.print("O valor de 'a' deve ser diferente de 0. Informe novamente: ");
                a = scanner.nextDouble();//recebe outro a
            }

            System.out.print("Informe o valor de b: ");
            double b = scanner.nextDouble();//recebe b

            System.out.print("Informe o valor de c: ");
            double c = scanner.nextDouble();//recebe c

            Equacao equacao = new Equacao(a, b, c);//coloca todos os valores no metodo de equação
            System.out.println(equacao.toString());//imprime na tela a equação inteira

            try { //mostra os resultados do metodo de equação 
                System.out.println("\nResultados:");
                System.out.println("Delta: " + equacao.delta());
                System.out.printf("x1: %.2f\n", equacao.retornaX1());
                System.out.printf("x2: %.2f", equacao.retornaX2());
            } catch (ArithmeticException e) { //exibe a mensagem de erro caso ocorra
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.print("\nDeseja calcular outra equação? (s/n): "); //mensagem de loop
            continuar = scanner.next().toLowerCase().charAt(0); //recebe e trata o char 
            
        }
        System.out.println("Encerrando..."); //mensagem de encerramento
        scanner.close();
    }
}
