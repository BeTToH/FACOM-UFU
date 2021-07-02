package com.company;

public class Contato {
<<<<<<< HEAD
    private String nome,sexo,profissao,telefone,email;
    private int idade;

    public Contato() {
    }

    public Contato(String nome, int idade, String sexo, String profissao, String telefone, String email) {
=======
    private String nome,sexo,profissão,telefone, email;
    private int idade;

    public Contato(String nome, int idade, String sexo, String profissão, String telefone, String email) {
>>>>>>> ddeac64d80e80a96655041fe6b42ebf633677125
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
<<<<<<< HEAD
        return getNome() + ", "+getIdade()+" anos de idade, do sexo "+getSexo()+","+getProfissao()+", telefone n.º "+getTelefone()+",e-mail:"+getEmail()+"";
=======
        return getNome() + ", "+getIdade()+" anos de idade, do sexo "+getSexo()+","+getProfissão()+", telefone n.º "+getTelefone()+",e-mail:"+getEmail()+"";
>>>>>>> ddeac64d80e80a96655041fe6b42ebf633677125
    }
}
