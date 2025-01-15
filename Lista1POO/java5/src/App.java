import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 1; //inicializa com a opção sim
        System.out.println("Insira os valores dos coeficientes da equação de segundo grau: (ax^2 + bx + c)");
        while (opcao == 1) {
            System.out.print("a: "); //recebe os valores dos coeficientes as suas devidas variaveis 
            double a = scanner.nextDouble();
            System.out.print("b: ");
            double b = scanner.nextDouble();
            System.out.print("c: ");
            double c = scanner.nextDouble();
            double delta = calcularDelta(a, b, c); //chama a função para calcular delta
            System.out.println("Resultado: ");
            System.out.println("Delta: " + delta); //exibe o resultado
            if (delta < 0) {
                System.out.println("A equação não possui raízes reais."); //verifica se existe raiz
            } else {
                double x1 = calcularRaiz1(a, b, delta); //calcula as raizes 
                double x2 = calcularRaiz2(a, b, delta);
                System.out.printf("x1 = %.2f \nx2 = %.2f\n", x1, x2);  //exibe as raizes
            }
            System.out.print("Deseja realizar outra operação?\nDigite 1 para Sim ou 0 para Não: ");
            opcao = scanner.nextInt(); // se receber valor diferente de 1 sai do loop 
        } 
        scanner.close();
    }

    public static double calcularDelta(double a, double b, double c) {
        return (b * b) - (4 * a * c); //formula para calcular delta
    }

    public static double calcularRaiz1(double a, double b, double delta) {
        return (-b + Math.sqrt(delta)) / (2 * a); //formula para calcular a primeira raiz
    }

    public static double calcularRaiz2(double a, double b, double delta) {
        return (-b - Math.sqrt(delta)) / (2 * a); //formula para calcular a segunda raiz
    }
}