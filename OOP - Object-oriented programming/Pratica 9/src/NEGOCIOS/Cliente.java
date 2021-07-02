package NEGOCIOS;


public class Cliente extends Pessoa{
    private String profissao;

    public Cliente(String nome, String celular, String email, String estCivil, boolean mulher, String profissao) {
        super(nome, celular, email, estCivil, mulher);
        setProfissao(profissao);
    }
    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
