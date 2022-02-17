class Cliente {
    private String cpf, nome, cep;
    private String dataDeNascimento;

    public Cliente(String cpfNovo, String nomeNovo, String dataNascNovo, String cepNovo){
        cpf = cpfNovo;
        nome = nomeNovo;
        dataDeNascimento = dataNascNovo;
        cep = cepNovo;
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
    public String getCep() {
        return cep;
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
    public void setCep(String cep) {
        cep = cepNovo;
    }
}