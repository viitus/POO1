import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double somaSalarios = 0;     // variaveis iniciais 
        int quantidadeSalarios = 0;
        System.out.println("-Salario negativo para sair-"); //mesagem informa como sair do programa
        
        while (true) {  
            System.out.printf("Insira o salario do %dº funcionario: ", quantidadeSalarios+1);//informa quantas pessoas vc ja inseriu 
            double salario = scanner.nextDouble(); //recebe o salario
            
            if (salario < 0) {
                break;  // sai do loop se salario for menor que 0
            }
            
            somaSalarios += salario; // adiciona o salario a variavel somatoria
            quantidadeSalarios++;  //conta a quantidade de funcionarios 
        }
        
        if (quantidadeSalarios == 0) {
            System.out.println("Nenhum salário foi inserido."); //mensagem para evitar divisao por 0
        } else {
            double mediaSalarios = somaSalarios / quantidadeSalarios; //faz a media dos salarios 
            System.out.printf("A média dos salários é: R$ %.2f", mediaSalarios); // exibe o resultado final
        }
    
        scanner.close();
    }
}
