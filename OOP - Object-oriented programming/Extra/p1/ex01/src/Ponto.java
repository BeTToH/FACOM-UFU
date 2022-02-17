import java.lang.Math;

public class Ponto {
    private double x;
    private double y;

    // Caso decida criar um obj da classe sem precisar definir um conjunto de valores - útil se ao criar não ter os valores definidos
    public Ponto () {
    }

    // Forma de criar um obj da classe e já definir um conjunto de valores - mais rápido que utilizar diversos sets
    public Ponto (double x, double y) {
        this.y = y;
        this.x = x;
    }

    // A possibilidade de se ter diversos construtores, assim como diversos métodos com o mesmo nome, se dá pela característica chamada Polimorfismo.

    public Ponto (double cordenada) {
        x = cordenada;
        y = cordenada;
    }

    public void criaPonto(double x, double y){
        if (x >= 0)
            this.x = x;
        else
            this.x = 0;

        if(y >= 0)
            this.y = y;
        else
            this.y = 0;
    }

    public void alteraPonto(double x, double y){
        if (x >= 0)
            this.x = x;
        else
            this.x = 0;

        if(y >= 0)
            this.y = y;
        else
            this.y = 0;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
