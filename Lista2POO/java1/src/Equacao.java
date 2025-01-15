public class Equacao {
    private double a; //declara os atributos encapsulados
    private double b;
    private double c;

    public Equacao(double a, double b, double c) {
        this.a = a; //funcao geradora
        this.b = b;
        this.c = c;
    }

    public double getA() {return a;} //metodos get e set 
    public void setA(double a) {this.a = a;}
    public double getB() {return b;}
    public void setB(double b) {this.b = b;}
    public double getC() {return c;}
    public void setC(double c) {this.c = c;}

    public double delta(){ //calcula o delta
        return b*b - 4*a*c;
    }

    public double retornaX1() { 
        double delta = delta();
        if (delta < 0) { //verifica se o delta é negativo e cria mensagem de erro
            throw new ArithmeticException("Delta é negativo.\nA equação não possui raízes reais.");
        }        
        return (-b + Math.sqrt(delta)) / (2 * a);//calcula o X1
    }

    public double retornaX2() {
        double delta = delta();
        if (delta < 0) {//verifica se o delta é negativo e cria mensagem de erro
            throw new ArithmeticException("Delta é negativo.\nA equação não possui raízes reais.");
        }        
        return (-b - Math.sqrt(delta)) / (2 * a);//calcula o X2
    }

    public String toString(){//função que exibe a equação inteira 
        return "Equação: " + a + "x^2 + " + b + "x + " + c;
    }
}
