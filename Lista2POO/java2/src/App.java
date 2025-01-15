import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 1; //inicia com um valor verdadeiro
        int num; //variavel de numero inteiro
        double a, b, c; //variaveis dos coeficientes da equação

        while (opcao != 0) { //verifica se deve parar
            System.out.println("1. Verificar se um número é primo"); //menu de opções
            System.out.println("2. Verificar se um número é perfeito");
            System.out.println("3. Calcular o fatorial de um número");
            System.out.println("4. Encontrar o N-ésimo número de Fibonacci");
            System.out.println("5. Calcular a raiz x1 de uma equação do segundo grau");
            System.out.println("6. Calcular a raiz x2 de uma equação do segundo grau");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); //recebe opção

            switch (opcao) {
                case 1: 
                    System.out.print("Digite um número inteiro: ");
                    num = scanner.nextInt(); //recebe o numero
                    if (Problemas.primo(num)) { //verifica se é primo
                        System.out.println(num + " é um número primo."); //mensagem para true
                    } else {
                        System.out.println(num + " não é um número primo."); //mensagem para false
                    }
                    break;

                case 2: 
                    System.out.print("Digite um número inteiro: ");
                    num = scanner.nextInt();
                    if (Problemas.perfeito(num)) { //verifica se é perfeito
                        System.out.println(num + " é um número perfeito.");
                    } else {
                        System.out.println(num + " não é um número perfeito.");
                    }
                    break;

                case 3: 
                    System.out.print("Digite um número inteiro: ");
                    num = scanner.nextInt();
                    try {
                        System.out.println("O fatorial de " + num + " é " + Problemas.fatorial(num)); //calcula e exibe o fatorial
                    } catch (Exception e) {
                        System.out.println(e.getMessage()); //mensagem de erro caso insira valor invalido
                    }
                    
                    break;

                case 4: 
                    System.out.print("Digite a posição N para Fibonacci: ");
                    num = scanner.nextInt();
                    try {
                        System.out.println("O " + num + "-ésimo número de Fibonacci é " + Problemas.fibonacci(num)); //calcula e exibe o numero fibonacci
                    } catch(Exception e) { 
                        System.out.println(e.getMessage()); //mansagem de erro para numeros negativos e zero
                    }
                    break;

                case 5: 
                    System.out.print("Digite o valor de a: ");
                    a = scanner.nextDouble();
                    System.out.print("Digite o valor de b: ");
                    b = scanner.nextDouble();
                    System.out.print("Digite o valor de c: ");
                    c = scanner.nextDouble();
                    try {
                        System.out.println("A raiz x1 é " + Problemas.retornaX1(a, b, c)); //calcula a primeira raiz
                    } catch(Exception e) {
                        System.out.println(e.getMessage()); //mensagem de erro caso nao exista raiz real
                    }
                    break;

                case 6: 
                    System.out.print("Digite o valor de a: ");
                    a = scanner.nextDouble();
                    System.out.print("Digite o valor de b: ");
                    b = scanner.nextDouble();
                    System.out.print("Digite o valor de c: ");
                    c = scanner.nextDouble();
                    try {
                        System.out.println("A raiz x2 é " + Problemas.retornaX2(a, b, c)); //calcula a segunda raiz
                    } catch(Exception e) {
                        System.out.println(e.getMessage()); //mensagem de erro caso nao exista raiz real
                    }
                    break;

                case 0: 
                    System.out.println("Fechando o programa."); //opção de encerramento
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente."); //mensagem caso escolha opção invalida
            }
        } 

        scanner.close();
    }
}
