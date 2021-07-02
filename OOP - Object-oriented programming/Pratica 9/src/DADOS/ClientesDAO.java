package DADOS;

import NEGOCIOS.Cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class ClientesDAO {
    private ArrayList<Cliente> clientes;

    public ClientesDAO() {
        this.clientes = new ArrayList<Cliente>();
    }

    public void adicionar(Cliente cliente){
        clientes.add(cliente);
    }

    public void salvaDados(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("Clientes");
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
