import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu peso (kg): ");
        double peso = scanner.nextDouble(); //recebe o peso numero real
        System.out.print("Digite sua altura (m): ");
        double altura = scanner.nextDouble(); //recebe a altura numero real
        double imc = calcularIMC(peso, altura); //chama a função/metodo que calcula o imc
        System.out.printf("Seu IMC é: %.2f\n", imc); //exibe o valor do imc
        System.out.printf("Classificação: " + classificarIMC(imc));//exibe a clacificação do imc
        scanner.close();
    }

    public static double calcularIMC(double peso, double altura) { //retorna numero real
        return peso / (altura * altura); //formula do imc
    }

    public static String classificarIMC(double imc) { //retorna uma string
        if (imc < 18.5) { //classifica o imc entre as categorias 
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Saudável";
        } else if (imc < 30) {
            return "Peso em excesso";
        } else if (imc < 35) {
            return "Obesidade grau I";
        } else if (imc < 40) {
            return "Obesidade grau II";
        } else {
            return "Obesidade mórbida"; //nao precisa de condição na ultima categoria 
        }
    }
}
