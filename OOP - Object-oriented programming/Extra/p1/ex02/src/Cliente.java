import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private String cidade;
    private String estado;
    private Gerente gerente;
    private ContaCorrente[] contasCorrente;


    public Cliente(String nome, String cpf, Date dataNascimento, String endereco, String cidade, String estado, Gerente gerente) {
        // id = Novo id gerado automaticamente
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.gerente = gerente;
    }

    public Cliente(String nome, String cpf, Date dataNascimento, String endereco, String cidade, String estado, Gerente gerente, ContaCorrente[] contasCorrente) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.gerente = gerente;
        this.contasCorrente = contasCorrente;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public ContaCorrente[] getContasCorrente() {
        return contasCorrente;
    }

    public void setContasCorrente(ContaCorrente[] contasCorrente) {
        this.contasCorrente = contasCorrente;
    }
}
