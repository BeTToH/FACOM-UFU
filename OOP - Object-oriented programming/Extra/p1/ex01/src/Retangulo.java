public class Retangulo {
    private Ponto pontoUm;
    private Ponto pontoDois;

    // Caso decida criar um obj da classe sem precisar definir um conjunto de valores - útil se ao criar não ter os valores definidos
    public Retangulo () {
    }

    // Forma de criar um obj da classe e já definir um conjunto de valores - mais rápido que utilizar diversos sets
    public Retangulo (Ponto pontoUm, Ponto pontoDois) {
        this.pontoUm = pontoUm;
        this.pontoDois = pontoDois;
    }

    // A possibilidade de se ter diversos construtores, assim como diversos métodos com o mesmo nome, se dá pela característica chamada Polimorfismo.

    public Ponto getPontoDois() {
        return pontoDois;
    }

    public void setPontoDois(Ponto pontoDois) {
        this.pontoDois = pontoDois;
    }

    public Ponto getPontoUm() {
        return pontoUm;
    }

    public void setPontoUm(Ponto pontoUm) {
        this.pontoUm = pontoUm;
    }

    public double calculaArea(){
        double largura = pontoUm.getX() - pontoDois.getX();
        double altura = pontoUm.getY() - pontoDois.getY();

        return Math.abs(largura * altura);
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                "pontoUm=" + pontoUm.toString() +
                ", pontoDois=" + pontoDois.toString() +
                '}';
    }
}
