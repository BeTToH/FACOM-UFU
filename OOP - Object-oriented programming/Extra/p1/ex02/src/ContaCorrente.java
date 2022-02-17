import java.util.Date;

public class ContaCorrente {
    private int id; // Num de Identificação
    private Cliente[] clientesMantenedores;
    private Agencia agencia;
    private Date dataCriacao;
    private double saldo;
    private Date dataUltimoAcesso;

    public ContaCorrente(Cliente[] clientesMantenedores, Agencia agencia, double saldo) {
        this.clientesMantenedores = clientesMantenedores;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dataCriacao = new Date();
        this.dataUltimoAcesso = new Date();
    }

    public int getId() {
        return id;
    }

    public Cliente[] getClientesMantenedores() {
        return clientesMantenedores;
    }

    public void setClientesMantenedores(Cliente[] clientesMantenedores) {
        this.clientesMantenedores = clientesMantenedores;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
}
