interface Corredor {
    String provaCorrer();
}

interface Nadador {
    String provaNadar();
}

interface Pedalar {
    String provaPedalar();
}

class TriAtleta implements Corredor, Nadador, Pedalar {
    private String nome;
    private int distCorrida;
    private int distNado;
    private String tipoNado;
    private int distBike;
    private String tipoBike;

    public TriAtleta(String nome, int distCorrida, int distNado, String tipoNado, int distBike, String tipoBike) {
        this.nome = nome;
        this.distCorrida = distCorrida;
        this.distNado = distNado;
        this.tipoNado = tipoNado;
        this.distBike = distBike;
        this.tipoBike = tipoBike;
    }

    @Override
    public String provaCorrer() {
        if (distCorrida == 21) return "meia-maratona";
        if (distCorrida == 42) return "maratona";
        return distCorrida + " km de corrida";
    }

    @Override
    public String provaNadar() {
        return distNado + " m de nado no " + tipoNado;
    }

    @Override
    public String provaPedalar() {
        return distBike + " km de ciclismo na " + tipoBike;
    }

    public String prova() {
        return "A prova será " + provaCorrer() + ", " + provaNadar() + " e " + provaPedalar() + ".";
    }
}

public class Main {
    public static void main(String[] args) {
        TriAtleta atleta1 = new TriAtleta("Juliana", 12, 100, "mar", 80, "rua");
        System.out.println(atleta1.prova());

        TriAtleta atleta2 = new TriAtleta("Carlos", 42, 3000, "piscina", 120, "cidade");
        System.out.println(atleta2.prova());
    }
}
