public class Funcionario {
    protected String nome, CPF;
    protected char sexo;
    protected int idade;
    protected static float salarioBase;
    protected float salarioMensal;

    // GETTERS
    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public float getSalarioMensal() {
        return salarioMensal;
    }

    public int getIdade() {
        return idade;
    }

    public String getCPF() {
        return CPF;
    }

    // SETTERS
    public static void setSalarioBase(float salarioBase) {
        Funcionario.salarioBase = salarioBase;
    }

    public void setIdade(int idade) {
        if(idade > 15)
            this.idade = idade;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F')
            this.sexo = sexo;
    }

    // CONSTRUCTORS

    public Funcionario(){ }

    public Funcionario(String nome, String cpf, char sexo, int idade){
        this.nome = nome;
        this.CPF = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    public void calculaSalario() { }
}
