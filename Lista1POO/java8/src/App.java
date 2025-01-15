import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "s"; //inicializa com a opcao sim 

        while(opcao.equalsIgnoreCase("s")){  //verifica se havera outro loop
            System.out.print("Digite o valor do primeiro cateto: ");
            double cateto1 = scanner.nextDouble(); // recebe o valor do primeiro cateto
            System.out.print("Digite o valor do segundo cateto: ");
            double cateto2 = scanner.nextDouble(); // recebe o valor do segundo cateto 

            double hipotenusa = calculaHipotenusa(cateto1, cateto2);//chama o metodo para calcular o valor da hipotenusa
            System.out.printf("O valor da hipotenusa é: %.2f \n", hipotenusa); //exibe o valor da hipotenusa
            
            System.out.print("Deseja realizar outro cálculo? (s/n): ");//pergunta se havera outro loop
            opcao = scanner.next();//recebe o valor da string de opçao
        }
        scanner.close();
    }

    public static double calculaHipotenusa(double cateto1, double cateto2) {
        return Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2)); //teorema de pitágoras para hipotenusa 
    }
}
