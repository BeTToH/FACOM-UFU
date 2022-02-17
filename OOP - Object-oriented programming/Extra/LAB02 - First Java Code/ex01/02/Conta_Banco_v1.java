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

public class Banco {
    public static void main (String args[])
    {
        Conta c1 = new Conta();
        c1.setLimite(300);
        c1.depositar(500);
        c1.sacar(200);
        System.out.println("O saldo é " + c1.getSaldo);
    }
}