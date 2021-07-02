package ManutencaoDados;

import pessoas.Cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class DadosClientes implements IManutencao<Cliente>{
    private ArrayList<Cliente> clientes;

    @Override
    public void adicionar(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public void eliminar(String cpf){
        if(!clientes.removeIf(cliente -> Objects.equals(cliente.getCpf(), cpf)))
            System.out.println("Não foi possível encontrar nenhum cliente com o cpf correspondente!");
    }

    @Override
    public void listar(){
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    @Override
    public Cliente buscar(String cpf){
        Cliente cli = null;
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                cli = cliente;
                break;
            }
        }
        return cli;
    }

    @Override
    public void salvaDadosBin(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("ClientesBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Cliente cliente : clientes)
                escritorObj.writeObject(cliente);
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
