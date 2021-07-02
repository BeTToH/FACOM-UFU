package pessoas;

public class Endereco {
    private String rua, complemento, cep, cidade, bairro;
    private int nro;

    public Endereco(String rua, String complemento, String cep, String cidade, String bairro, int nro) {
        setRua(rua);
        setComplemento(complemento);
        setCep(cep);
        setCidade(cidade);
        setBairro(bairro);
        setNro(nro);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }
}
