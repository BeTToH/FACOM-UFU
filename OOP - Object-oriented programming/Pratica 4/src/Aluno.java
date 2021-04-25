public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno (Curso curso){
        setCurso(curso);
    }

    public Aluno (){
    }

    public Aluno(String nome, String matricula, Curso curso){
        setNome(nome);
        setMatricula(matricula);
        setCurso(curso);
    }
}
