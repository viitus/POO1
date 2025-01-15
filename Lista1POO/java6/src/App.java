import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 1; //inicializa com a opção 'sim'

        while(opcao == 1) {
            System.out.print("Digite a quantidade de quilômetros percorridos: ");
            int quilometros = scanner.nextInt(); //recebe o valor de quilômetros

            System.out.print("Digite a quantidade de litros gastos: ");
            int litros = scanner.nextInt(); //recebe o valor de litros

            if (litros == 0) {
                System.out.println("A quantidade de litros deve ser maior que zero."); //evita divisão por zero
            } else {
                float consumo = (float) quilometros / litros; //faz o calculo do consumo
                System.out.printf("Consumo: %.2f km/l", consumo); //exibe o consumo
            }
            System.out.print("\nDeseja realizar outro cálculo?\nDigite 1 para Sim ou 0 para Não: ");
            opcao = scanner.nextInt(); //verifica se havera novo loop
        }
        scanner.close();
    }
}
