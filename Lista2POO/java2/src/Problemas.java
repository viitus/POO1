public class Problemas {

    public static boolean primo(int n) {
        if (n <= 1) { 
            return false; //se o numero é 1 ou menor então ele nao é primo
        } 

        for (int i = 2; i < n; i++) {
            if (n % i == 0) { 
                return false; //se o numero possui divisores entre 2 e ele mesmo, entao ele nao é primo
            }
        }
        return true;  //fora isso ele é primo
    }
    
    public static boolean perfeito(int n) {
        int soma = 0;
        for (int i = 1; i < n; i++) { 
            if (n % i == 0) {
                soma += i; //soma os divisores entre 1 e o numero 
            }
        }
        return soma == n; //se a soma for igual o numero será true, portanto é perfeito, se nao entao será false
    }

    public static long fatorial(int n) {
        if (n < 0) { //aviso de erro para numeros negativos
            throw new IllegalArgumentException("Não existe fatorial para números negativos.");
        }
        long resultado = 1; //começa em 1 pois se começar em 0 tudo vira 0, além disso o fatorial de 0 é 1
        for (int i = 1; i <= n; i++) {
            resultado *= i; //faz o produtorio dos numeros de 1 a n
        }
        return resultado;
    }

    
    public static long fibonacci(int n) { 
        if (n <= 0) throw new IllegalArgumentException("A posição de Fibonacci deve existir."); //erro para posições nao existentes
        if (n == 1) return 0; //1a posição = 0  
        if (n == 2) return 1; //2a posição = 1

        long anterior = 0, atual = 1, proximo = 1;

        for (int i = 3; i <= n; i++) {
            proximo = anterior + atual; //soma os numeros anteriores
            anterior = atual; //atualiza valor
            atual = proximo; //atualiza valor
        }

        return atual;
    }

   
    public static double delta(double a, double b, double c){ //calcula o delta
        return b*b - 4*a*c;
    }

    public static double retornaX1(double a, double b, double c) { 
        double delta = delta(a, b, c);
        if (delta < 0) { //verifica se o delta é negativo e cria mensagem de erro
            throw new ArithmeticException("Delta é negativo.\nA equação não possui raízes reais.");
        }        
        return (-b + Math.sqrt(delta)) / (2 * a);//calcula o X1
    }

    public static double retornaX2(double a, double b, double c) {
        double delta = delta(a, b, c);
        if (delta < 0) {//verifica se o delta é negativo e cria mensagem de erro
            throw new ArithmeticException("Delta é negativo.\nA equação não possui raízes reais.");
        }        
        return (-b - Math.sqrt(delta)) / (2 * a);//calcula o X2
    }
}
