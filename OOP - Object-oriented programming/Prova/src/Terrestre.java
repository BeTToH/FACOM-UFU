public class Terrestre extends Transporte{
    private final int qtdeRodas;

    public Terrestre(double peso, double largura, int qtdeRodas){
        setLargura(largura);
        setPeso(peso);
        this.qtdeRodas = qtdeRodas;
    }

    @Override
    public String toString() {
        return "Terrestre{" +
                "qtdeRodas=" + qtdeRodas +
                "} " + super.toString();
    }
}
