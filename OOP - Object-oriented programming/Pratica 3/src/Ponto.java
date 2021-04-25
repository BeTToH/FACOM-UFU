import java.lang.Math;

public class Ponto {
    private double x;
    private double y;

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

    public double calculaDistancia(Ponto a){
        return Math.sqrt(((a.getX() - this.x) * (a.getX() - this.x)) + ((a.y - this.y) * (a.y - this.y)));
    }
}
