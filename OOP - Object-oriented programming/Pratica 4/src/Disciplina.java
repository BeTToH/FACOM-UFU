public class Disciplina {
    private Curso curso;
    private String codigo;
    private String nome;
    private int CargaHoraria;

    public Curso getCurso() {
        return curso;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setCargaHoraria(int cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina(Curso curso){
        setCurso(curso);
    }

    public Disciplina(Curso curso, String codigo, String nome, int cargaHoraria){
        setCurso(curso);
        setCodigo(codigo);
        setNome(nome);
        setCargaHoraria(cargaHoraria);
    }
}
