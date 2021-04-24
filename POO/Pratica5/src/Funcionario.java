public class Funcionario {
    private String nome;
    private String RG;
    protected double salarioBase;
    private String telefone;

    // Getters
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Setters
    public double getSalarioBase() {
        return salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public String getRG() {
        return RG;
    }

    public String getTelefone() {
        return telefone;
    }
}
