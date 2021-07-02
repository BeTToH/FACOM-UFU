public class FuncionarioNoturno extends Funcionario{
    private static float valorAdicional;
    private int noitesTrabalhadasMes;

    public FuncionarioNoturno(String nome, String cpf, char sexo, int idade, int noitesTrabalhadasMes) {
        super(nome, cpf, sexo, idade);
        this.noitesTrabalhadasMes = noitesTrabalhadasMes;
        calculaSalario();
    }

    public int getNoitesTrabalhadasMes() {
        return noitesTrabalhadasMes;
    }

    public static float getValorAdicional() {
        return valorAdicional;
    }

    public void setNoitesTrabalhadasMes(int noitesTrabalhadasMes) {
        this.noitesTrabalhadasMes = noitesTrabalhadasMes;
        calculaSalario();
    }

    public void addNoitesTrabalhadas(int qntde){
        noitesTrabalhadasMes += qntde;
        calculaSalario();
    }

    public static void setValorAdicional(float valorAdicional) {
        FuncionarioNoturno.valorAdicional = valorAdicional;
    }

    public void calculaSalario() {
        this.salarioMensal = salarioBase + (valorAdicional * noitesTrabalhadasMes);
    }

    @Override
    public String toString() {
        return "FuncionarioNoturno{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", sexo=" + sexo +
                ", idade=" + idade +
                ", salarioMensal=" + salarioMensal +
                ", noitesTrabalhadasMes=" + noitesTrabalhadasMes +
                '}';
    }
}
