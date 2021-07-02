package pessoas;

public class Cliente extends Pessoa{
    private String profissao;

    public Cliente(String cpf, String nome, String celular, String telFixo, String email, String estCivil, boolean mulher, Endereco endereco, String profissao) {
        super(cpf, nome, celular, telFixo, email, estCivil, mulher, endereco);
        setProfissao(profissao);
    }
    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
