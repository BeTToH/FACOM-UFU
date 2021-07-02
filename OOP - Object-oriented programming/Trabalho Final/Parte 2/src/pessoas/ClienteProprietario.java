package pessoas;

import java.util.Date;

public class ClienteProprietario extends Cliente{
    Date dataPrimeiroCadastro;

    public ClienteProprietario(String cpf, String nome, String celular, String telFixo, String email, String estCivil, boolean mulher, Endereco endereco, String profissao, Date dataPrimeiroCadastro) {
        super(cpf, nome, celular, telFixo, email, estCivil, mulher, endereco, profissao);
        setDataPrimeiroCadastro(dataPrimeiroCadastro);
    }

    public Date getDataPrimeiroCadastro() {
        return dataPrimeiroCadastro;
    }

    public void setDataPrimeiroCadastro(Date dataPrimeiroCadastro) {
        this.dataPrimeiroCadastro = dataPrimeiroCadastro;
    }
}
