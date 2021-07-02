package ManutencaoDados;

import pessoas.Corretor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class DadosCorretores implements IManutencao<Corretor>{
    private ArrayList<Corretor> corretores;

    public void adicionar(Corretor corretor){
        corretores.add(corretor);
    }

    public void eliminar(String cpf){
        if(!corretores.removeIf(corretor -> Objects.equals(corretor.getCpf(), cpf)))
            System.out.println("Não foi possível encontrar nenhum corretor com o cpf correspondente!");
    }

    public void listar(){
        for (Corretor corretor : corretores) {
            System.out.println(corretor.toString());
        }
    }

    public Corretor buscar(String cpf){
        Corretor p = null;
        for(Corretor corretor : corretores){
            if(corretor.getCpf().equals(cpf)){
                p = corretor;
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
            escritorArquivo =new FileOutputStream("CorretoresBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Corretor corretor : corretores)
                escritorObj.writeObject(corretor);
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
