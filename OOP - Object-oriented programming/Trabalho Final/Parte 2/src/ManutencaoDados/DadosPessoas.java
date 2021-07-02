package ManutencaoDados;

import pessoas.Pessoa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class DadosPessoas implements IManutencao<Pessoa>{
    private ArrayList<Pessoa> pessoas;

    @Override
    public void adicionar(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    @Override
    public void eliminar(String cpf){
        if(!pessoas.removeIf(pessoa -> Objects.equals(pessoa.getCpf(), cpf)))
            System.out.println("Não foi possível encontrar nenhuma pessoa com o cpf correspondente!");
    }

    @Override
    public void listar(){
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }
    }

    @Override
    public Pessoa buscar(String cpf){
        Pessoa p = null;
        for(Pessoa pessoa : pessoas){
            if(pessoa.getCpf().equals(cpf)){
                p = pessoa;
                break;
            }
        }
        return p;
    }

    @Override
    public void salvaDadosBin(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("PessoasBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Pessoa pessoa : pessoas)
                escritorObj.writeObject(pessoa);
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
