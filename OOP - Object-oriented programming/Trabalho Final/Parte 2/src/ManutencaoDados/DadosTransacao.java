package ManutencaoDados;

import pessoas.Transacao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class DadosTransacao implements IManutencao<Transacao>{
    private ArrayList<Transacao> transacoes;

    @Override
    public void adicionar(Transacao transacao){
        transacoes.add(transacao);
    }

    @Override
    public void eliminar(String nroContrato){
        if(!transacoes.removeIf(transacao -> Objects.equals(transacao.getNroContrato(), nroContrato)))
            System.out.println("Não foi possível encontrar nenhuma transacao com o numero de contrato correspondente!");
    }

    @Override
    public void listar(){
        for (Transacao transacao : transacoes) {
            System.out.println(transacao.toString());
        }
    }

    @Override
    public Transacao buscar(String nroContrato){
        Transacao t = null;
        for(Transacao transacao : transacoes){
            if(Objects.equals(transacao.getNroContrato(), nroContrato)){
                t = transacao;
                break;
            }
        }
        return t;
    }

    @Override
    public void salvaDadosBin(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("TransacoesBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Transacao transacao : transacoes)
                escritorObj.writeObject(transacao);
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
