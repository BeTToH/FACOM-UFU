public class Vendedor extends Funcionario{
    private double totalVendas;

    public void zeraVendas(){
        this.totalVendas = 0;
    }

    public void acrescentaVendas(double valorVenda) {
        this.totalVendas += valorVenda;
    }

    public double getSalarioTotal(){
        return (this.totalVendas * 0.05) + this.salarioBase;
    }

    public double getTotalVendas() {
        return totalVendas;
    }
}
