public class Conta {
    private double limite;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double x) {
        saldo = x;
    }
    public double getLimite() {
        return limite;
    }
    public void setLimite(double y) {
        limite = y;
    }
}

public class Banco {
    public static void main (String args[])
    {
        Conta c1 = new Conta();
        c1.setSaldo(1000);
        c1.setLimite(1000);
        double saldoAtual = c1.getSaldo();
        System.out.println("Saldo atual é " + saldoAtual);
        double limiteConta = c1.getLimite();
        System.out.println("Limite é " +limiteConta);
    }
}