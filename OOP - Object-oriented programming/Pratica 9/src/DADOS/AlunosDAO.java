package DADOS;

import NEGOCIOS.Aluno;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AlunosDAO {
    private ArrayList<Aluno> alunos;

    public AlunosDAO() {
        this.alunos = new ArrayList<Aluno>();
    }

    public void adicionar(Aluno aluno){
        alunos.add(aluno);
    }

    public void salvaDados(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("Alunos");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Aluno aluno : alunos)
                escritorObj.writeObject(aluno);
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if(escritorArquivo != null)
                    escritorArquivo.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
