import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor a ser aplicado em reais: R$");
        double vp = scanner.nextDouble();  //vp recebe o valor presente (pode ser decimal)

        System.out.print("Digite a taxa de juros mensal(%): ");
        double j = scanner.nextDouble()/100; // j recebe a taxa de juros e divide por 100 para ficar em decimal

        System.out.print("Digite o numero de meses: ");
        int n = scanner.nextInt(); // n recebe o numero de meses do investimento

        double vf = vp * Math.pow((1 + j), n); // formula do juros compostos 

        System.out.printf("O valor final após %d meses será: R$%.2f", n, vf); //exibe na tela o resultado final da aplicação

        scanner.close();
    }
}
