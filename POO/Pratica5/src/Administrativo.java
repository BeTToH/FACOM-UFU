public class Administrativo extends Funcionario{
    private int horasExtras; // Supondo q só é possível fazer horas extras completas - e não, por exemplo, 0.5h extra

    public void zeraHorasExtras(){
        this.horasExtras = 0;
    }

    public void acrescentaHorasExtras(int horasExtras) {
        this.horasExtras += horasExtras;
    }

    public double getSalarioTotal(){
        return this.salarioBase + (this.horasExtras * (0.01 * this.salarioBase));
    }

    public int getHorasExtras() {
        return horasExtras;
    }
}
