public class Curso {
    private String codigo;
    private String nome;
    private int duracao;

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public int getDuracao(){
        return duracao;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    public Curso(String codigo, String nome, int duracao){
        setCodigo(codigo);
        setNome(nome);
        setDuracao(duracao);
    }
}
