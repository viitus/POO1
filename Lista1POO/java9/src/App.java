import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10]; //cria vetor de interiros de 10 posiçoes 

        System.out.println("Digite 10 numeros inteiros:");
        for (int i = 0; i < 10; i++) { // percore o vetor 
            System.out.printf("%dº numero: ", i+1);
            valores[i] = scanner.nextInt(); //recebe um valor a cada posicao do vetor
        }

        System.out.println("Numeros na ordem inversa:");
        for (int i = 9; i >= 0; i--) { //percore o vetor de trás para frente 
            System.out.println(valores[i]); //exibe os valores de forma inversa 
        }

        scanner.close();
    }
}
