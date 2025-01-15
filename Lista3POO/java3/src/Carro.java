import javax.swing.JOptionPane;

public class Carro implements Transporte, Compartilhavel {
    private double consumoCombustivel;
    private double precoCombustivel;
    private int lugaresTotais;
    private int lugaresOcupados;

    public Carro(double consumoCombustivel, double precoCombustivel, int lugaresOcupados) {
        this.consumoCombustivel = consumoCombustivel;
        this.precoCombustivel = precoCombustivel;
        this.lugaresTotais = 5;
        this.lugaresOcupados = lugaresOcupados;
    }

    public int getLugaresTotais(){
        return lugaresTotais;
    }

    @Override
    public void iniciar() {
        JOptionPane.showMessageDialog(null, "Corrida de Carro iniciada.");
    }

    @Override
    public void parar() {
        JOptionPane.showMessageDialog(null, "Corrida de Carro finalizada.");
    }

    @Override
    public double calcularCusto(double distancia) {
        return (distancia / consumoCombustivel) * precoCombustivel;
    }

    @Override
    public int calcularLugaresDisponiveis() {
        return lugaresTotais - lugaresOcupados;
    }

    public String toString(double distancia, double custo) {
        return String.format(
                "Carro:\nDistância: %.2f km\nCusto: R$ %.2f\nLugares disponíveis: %d",
                distancia, custo, calcularLugaresDisponiveis());
    }
}
