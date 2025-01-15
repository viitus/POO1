import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int opcao = 1; // inicia a opção com valor diferente de 4 para entrar no while

        while (opcao != 4) { // verifica se a opção de saida foi selecionada 
            String menu = "Escolha uma operação:\n" +
                          "1 – Calcular a área de um quadrado\n" +
                          "2 – Calcular a área de um círculo\n" +
                          "3 – Calcular a área de um triângulo\n" +
                          "4 – Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu)); //exibe o menu no joptionpane e recebe a opçao desejada

            switch (opcao) { //chama o metodo dependendo da opção desejada 
                case 1:
                    calcularAreaQuadrado();
                    break;
                case 2:
                    calcularAreaCirculo();
                    break;
                case 3:
                    calcularAreaTriangulo();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break; //exibe mensagem de saida caso escolha a opção 4 
                default: //exibe mensagem de erro caso nao tenha escolhido uma das 4 opções anteriores
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } 
    }

    public static void calcularAreaQuadrado() { //metodo para calcular area do quadrado
        double lado = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do lado do quadrado:"));
        double area = lado * lado; // joptionpane para receber dado e exibir o resultado
        JOptionPane.showMessageDialog(null, "A área do quadrado é: " + area);
    }

    public static void calcularAreaCirculo() {
        double raio = Double.parseDouble(JOptionPane.showInputDialog("Digite o raio do círculo:"));
        double area = Math.PI * raio * raio; // foi usado String.format dentro do joptinpane para mostrar apenas 2 casas decimais no resultado 
        JOptionPane.showMessageDialog(null, String.format("A área do círculo é: %.2f", area));
    }

    public static void calcularAreaTriangulo() {
        double base = Double.parseDouble(JOptionPane.showInputDialog("Digite a base do triângulo:"));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triângulo:"));
        double area = (base * altura) / 2;
        JOptionPane.showMessageDialog(null, "A área do triângulo é: " + area);
    }
}
