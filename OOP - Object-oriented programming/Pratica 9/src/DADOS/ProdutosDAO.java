package DADOS;

import NEGOCIOS.Produto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProdutosDAO {
    private ArrayList<Produto> produtos;

    public ProdutosDAO() {
        this.produtos = new ArrayList<Produto>();
    }

    public void adicionar(Produto produto){
        produtos.add(produto);
    }

    public void salvaDados(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("Produtos");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Produto produto : produtos)
                escritorObj.writeObject(produto);
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

