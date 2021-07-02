public class Transporte {
    private double peso;
    private double largura;

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargura() {
        return largura;
    }

    public double getPeso() {
        return peso;
    }

    public Transporte(double peso, double largura){
        setPeso(peso);
        setLargura(largura);
    }

    public Transporte(){

    }

    @Override
    public String toString() {
        return "Transporte{" +
                "peso=" + peso +
                ", largura=" + largura +
                '}';
    }
}
