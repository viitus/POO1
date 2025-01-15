import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 1; //inicializa com a opcao sim

        while (opcao == 1) {         
            System.out.print("Digite o número de horas trabalhadas no mês: ");
            int horasTrabalhadas = scanner.nextInt();
            System.out.print("Digite o valor da hora trabalhada: ");
            double valorHora = scanner.nextDouble();
            System.out.print("Digite o número de dependentes: ");
            int numeroDependentes = scanner.nextInt();
            System.out.print("Digite o valor dos descontos: ");
            double descontos = scanner.nextDouble(); 
            //recebe as variaveis nescessárias 

            double salario = calcularSalario(horasTrabalhadas, valorHora, numeroDependentes, descontos); //chama a funcao que calcula o salario
            System.out.printf("O salário do empregado é: R$ %.2f", salario); //exibe o salario calculado
            System.out.print("\nDeseja calcular o salario de outro empregado?\nDigite 1 para Sim ou 0 para Não: ");
            opcao = scanner.nextInt(); //verifica se havera outro loop
        }
        
        scanner.close();
    }

    public static double calcularSalario(int horasTrabalhadas, double valorHora, int numeroDependentes, double descontos) {
        return (horasTrabalhadas * valorHora) + (50 * numeroDependentes) - descontos; //formula para calculo do salário
    }
}

