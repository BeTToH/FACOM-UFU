public class Aereo extends Transporte{
    private final double autonomia; // final implementado pois n há nenhum método para alterar o valor do atributo

    public Aereo(double peso, double largura, double autonomia){
        setLargura(largura);
        setPeso(peso);
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return "Aereo{" +
                "autonomia=" + autonomia +
                "} " + super.toString();
    }
}
