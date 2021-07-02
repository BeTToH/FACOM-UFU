package pessoas;

import java.util.Locale;

public class Pessoa {
    protected String cpf, nome, celular, telFixo, email, estCivil;
    protected boolean mulher;
    protected Endereco endereco;

    public Pessoa(String cpf, String nome, String celular, String telFixo, String email, String estCivil, boolean mulher, Endereco endereco) {
        if(!setCpf(cpf)) this.cpf = "11111111111";
        setNome(nome);
        setCelular(celular);
        setTelFixo(telFixo);
        setEmail(email);
        setEstCivil(estCivil);
        setMulher(mulher);
        setEndereco(endereco);
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getSexo() {
        if(mulher) return "Feminino";
        return "Masculino";
    }

    public void setMulher(boolean mulher) {
        this.mulher = mulher;
    }

    public String getCpf() {
        return ValidaCPF.imprimeCPF(this.cpf);
    }

    public boolean setCpf(String cpf) {
        if(ValidaCPF.isCPF(cpf)) {
            this.cpf = cpf;
            return true;
        }
        return false;
    }

    public String getNome() {
        String retorno = this.nome;
        int strLen = retorno.length();
        retorno = retorno.substring(0, 1).toUpperCase() + retorno.substring(1);
        for (int i = 0; i<strLen;i++){
            if (retorno.charAt(i) == ' ' && i+1<=strLen){
                retorno.substring(i+1,i+2).toUpperCase();
            }
        }
        return nome;
    }

    public void setNome(String nome) {
        nome = nome.trim();
        nome = nome.toLowerCase();
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", telFixo='" + telFixo + '\'' +
                ", email='" + email + '\'' +
                ", estCivil='" + estCivil + '\'' +
                ", mulher=" + mulher +
                ", endereco=" + endereco +
                '}';
    }
}
