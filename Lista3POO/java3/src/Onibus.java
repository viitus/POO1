import javax.swing.JOptionPane;

public class Onibus implements Transporte, Compartilhavel {
    private double custoPorPassageiro;
    private int lugaresTotais;
    private int lugaresOcupados;
    private double consumoCombustivel;
    private double precoCombustivel;

    public Onibus(double custoPorPassageiro, int lugaresOcupados, double consumoCombustivel, double precoCombustivel) {
        this.custoPorPassageiro = custoPorPassageiro;
        this.lugaresTotais = 50;
        this.lugaresOcupados = lugaresOcupados;
        this.consumoCombustivel = consumoCombustivel;
        this.precoCombustivel = precoCombustivel;
    }

    public int getLugaresTotais(){
        return lugaresTotais;
    }

    @Override
    public void iniciar() {
        JOptionPane.showMessageDialog(null, "Corrida de Ônibus iniciada.");
    }

    @Override
    public void parar() {
        JOptionPane.showMessageDialog(null, "Corrida de Ônibus finalizada.");
    }

    @Override
    public double calcularCusto(double distancia) {
        double custoCombustivel = (distancia / consumoCombustivel) * precoCombustivel;
        double receita = lugaresOcupados * custoPorPassageiro * distancia;
        return receita - custoCombustivel;
    }

    @Override
    public int calcularLugaresDisponiveis() {
        return lugaresTotais - lugaresOcupados;
    }

    public String toString(double distancia, double custo) {
        String statusFinanceiro = custo > 0 ? "Lucro" : "Prejuízo";
        return String.format(
                "Ônibus:\nDistância: %.2f km\nCusto total: R$ %.2f\nStatus: %s\nLugares disponíveis: %d",
                distancia, custo, statusFinanceiro, calcularLugaresDisponiveis());
    }
}
