package pessoas;

import java.util.Date;

public class Funcionario extends Pessoa{
    protected String cargo, usuario, senha;
    protected Date dataIngressoEmpresa;
    protected static float salarioBase;

    public Funcionario(String cpf, String nome, String celular, String telFixo, String email, String estCivil, boolean mulher, Endereco endereco, String cargo, String usuario, String senha, Date dataIngressoEmpresa) {
        super(cpf, nome, celular, telFixo, email, estCivil, mulher, endereco);
        setCargo(cargo);
        setUsuario(usuario);
        setSenha(senha);
        setDataIngressoEmpresa(dataIngressoEmpresa);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean compareSenha(String inputSenha) {
        return inputSenha.equals(this.senha);
    }

    public boolean setSenha(String senha) {
        if (senha.length() >= 6) {
            this.senha = senha;
            return true;
        }
        return false;
    }

    public Date getDataIngressoEmpresa() {
        return dataIngressoEmpresa;
    }

    public float calculaSalario() { return getSalarioBase(); }

    public void setDataIngressoEmpresa(Date dataIngressoEmpresa) {
        this.dataIngressoEmpresa = dataIngressoEmpresa;
    }

    public static void setSalarioBase(float salarioBase) { Funcionario.salarioBase = salarioBase; }

    public float getSalarioBase() { return salarioBase; }
}
