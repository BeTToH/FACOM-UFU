package ManutencaoDados;

import Imoveis.Imovel;
import pessoas.Endereco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class DadosImoveis {
    private ArrayList<Imovel> imoveis;

    public void adicionar(Imovel imovel){
        imoveis.add(imovel);
    }

    // Como diferenciar os imóveis? Criar método de comparação?
    public void eliminar(Endereco endereco){
        if(imoveis.removeIf(imovel -> imovel.getEndereco().equals(endereco)))
            System.out.println("Não foi possível encontrar nenhum imovel com o endereço correspondente!");
    }

    public void listar(){
        for (Imovel imovel : imoveis) {
            System.out.println(imovel.toString());
        }
    }

    public Imovel buscar(Endereco endereco){
        Imovel im = null;
        for(Imovel imovel : imoveis){
            if(imovel.getEndereco().equals(endereco)){
                im = imovel;
                break;
            }
        }
        return im;
    }

    public void salvaDadosBin(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("ImoveisBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Imovel imovel : imoveis)
                escritorObj.writeObject(imovel);
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
