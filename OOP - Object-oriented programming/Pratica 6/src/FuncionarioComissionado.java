public class FuncionarioComissionado extends Funcionario{
    private float valorComissoes;

    public FuncionarioComissionado(String nome, String cpf, char sexo, int idade, float valorComissoes) {
        super(nome, cpf, sexo, idade);
        this.valorComissoes = valorComissoes;
        calculaSalario();
    }

    public float getValorComissoes() {
        return valorComissoes;
    }

    public void setValorComissoes(float valorComissoes) {
        if(valorComissoes > 0) {
            this.valorComissoes = valorComissoes;
            calculaSalario();
        }
    }

    public void addComissao(float valor){
        if(valorComissoes > 0) {
            valorComissoes += valor;
            calculaSalario();
        }
    }

    public void calculaSalario(){
        this.salarioMensal = salarioBase + this.valorComissoes;
    }

    @Override
    public String toString() {
        return "FuncionarioComissionado{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", sexo=" + sexo +
                ", idade=" + idade +
                ", salarioMensal=" + salarioMensal +
                ", valorComissoes=" + valorComissoes +
                '}';
    }
}
