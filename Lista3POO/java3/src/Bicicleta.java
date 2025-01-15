import javax.swing.JOptionPane;

public class Bicicleta implements Transporte {
    private int tempoDeUso;

    public Bicicleta() {
        this.tempoDeUso = 0;
    }

    @Override
    public void iniciar() {
        JOptionPane.showMessageDialog(null, "Corrida de Bicicleta iniciada.");
    }

    @Override
    public void parar() {
        JOptionPane.showMessageDialog(null, "Corrida de Bicicleta finalizada.");
    }

    @Override
    public double calcularCusto(double distancia) {
        return 0.0;
    }

    public void registrarTempoDeUso(int minutos) {
        this.tempoDeUso += minutos;
    }

    public int getTempoDeUso() {
        return tempoDeUso;
    }

    public String toString(double distancia, double custo) {
        double velocidadeMedia = distancia / (tempoDeUso / 60.0);
        return String.format(
                "Bicicleta:\nDistância: %.2f km\nTempo de uso: %d minutos\nVelocidade média: %.2f km/h\nCusto: R$ %.2f",
                distancia, tempoDeUso, velocidadeMedia, custo);
    }
}
