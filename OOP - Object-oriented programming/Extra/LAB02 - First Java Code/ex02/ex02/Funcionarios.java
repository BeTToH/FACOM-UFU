class Funcionario {
    private String cpf, nome;
    private String dataDeNascimento, dataDeIngresso;

    public Funcionario(String cpfNovo, String nomeNovo, String dataNascNovo, String dataDeIngNovo){
        cpf = cpfNovo;
        nome = nomeNovo;
        dataDeNascimento = dataNascNovo;
        dataDeIngresso = dataDeIngNovo;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public String getDataDeIngresso() {
        return dataDeIngresso;
    }
    public void setCpf(String cpf) {
        cpf = cpfNovo;
    }
    public void setNome(String nome) {
        nome = nomeNovo;
    }
    public void setDataDeNascimento(String dataDeNascimento) {
        dataDeNascimento = dataNascNovo;
    }
    public void setDataDeIngresso(String dataDeIngresso) {
        this.dataDeIngresso = dataDeIngresso;
    }
}