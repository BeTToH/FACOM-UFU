public class Conta {
    private double limite;
    private double saldo;

    public void depositar(double x) {
        saldo = saldo + x;
    }
    public void sacar(double x) {
        if (saldo + limite >= x)
        saldo = saldo - x;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setLimite(double x) {
        limite = x;
    }
    public double getLimite() {
        return limite;
    }
}