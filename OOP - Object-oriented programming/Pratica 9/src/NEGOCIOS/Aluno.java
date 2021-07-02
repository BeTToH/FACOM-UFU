package NEGOCIOS;

public class Aluno extends Pessoa{
    private String curso;
    private int anoDeConclusao;

    public Aluno(String nome, String celular, String email, String estCivil, boolean mulher, String curso, int anoDeConclusao){
        super(nome, celular, email, estCivil, mulher);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoDeConclusao() {
        return anoDeConclusao;
    }

    public void setAnoDeConclusao(int anoDeConclusao) {
        this.anoDeConclusao = anoDeConclusao;
    }
}
