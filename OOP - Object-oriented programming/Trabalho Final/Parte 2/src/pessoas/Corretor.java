package pessoas;

import java.util.Date;

public class Corretor extends Funcionario{
    private boolean formadoVendas;
    private Date dataInicioCorretagem;
    private final static float porcentagemComissao = 5;
    private float vendaMes;

    public Corretor(String cpf, String nome, String celular, String telFixo, String email, String estCivil, boolean mulher, Endereco endereco, String cargo, String usuario, String senha, Date dataIngressoEmpresa, boolean formadoVendas, Date dataInicioCorretagem) {
        super(cpf, nome, celular, telFixo, email, estCivil, mulher, endereco, cargo, usuario, senha, dataIngressoEmpresa);
        setFormadoVendas(formadoVendas);
        setDataInicioCorretagem(dataInicioCorretagem);
    }

    public boolean isFormadoVendas() {
        return formadoVendas;
    }

    public void setFormadoVendas(boolean formadoVendas) {
        this.formadoVendas = formadoVendas;
    }

    public Date getDataInicioCorretagem() {
        return dataInicioCorretagem;
    }

    public void setDataInicioCorretagem(Date dataInicioCorretagem) {
        this.dataInicioCorretagem = dataInicioCorretagem;
    }

    public float calculaSalario() {
        return getSalarioBase() + getVendaMes();
    }

    public float getVendaMes() { return vendaMes; }

    public void adicionaVendaMes(float vendaMes) { this.vendaMes += vendaMes; }

    public void zerarVendaMes(){
        this.vendaMes = 0;
    }

    public static float getPorcentagemComissao() { return porcentagemComissao; }
}
