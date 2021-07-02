package NEGOCIOS;

public class Pessoa {
    protected String nome, telefone, email, estCivil;
    protected boolean mulher;

    public Pessoa(String nome, String telefone, String email, String estCivil, boolean mulher) {
        setNome(nome);
        setCelular(telefone);
        setEmail(email);
        setEstCivil(estCivil);
        setMulher(mulher);
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
        return telefone;
    }

    public void setCelular(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String toString() {
        return "Pessoa{" +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", estCivil='" + estCivil + '\'' +
                ", mulher=" + mulher +
                '}';
    }
}

