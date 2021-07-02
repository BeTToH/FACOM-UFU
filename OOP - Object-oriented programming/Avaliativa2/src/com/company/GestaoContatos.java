package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class GestaoContatos {
    private ArrayList<Contato> familia;
    private ArrayList<Contato> amigos;
    private ArrayList<Contato> profissional;

    public GestaoContatos() {
        familia = new ArrayList<Contato>();
        amigos = new ArrayList<Contato>();
        profissional = new ArrayList<Contato>();
    }

    public void adicionaContato(Contato novoContato, int lista){
        if (lista == 1)
            familia.add(novoContato);
        else if (lista == 2)
            amigos.add(novoContato);
        else if (lista == 3)
            profissional.add(novoContato);
    }

    public void eliminaContato(String nome){
        boolean flag = false;
        flag = familia.removeIf(contato -> Objects.equals(contato.getNome(), nome));
        if(!flag)
            flag = amigos.removeIf(contato -> Objects.equals(contato.getNome(), nome));
        if(!flag)
            flag = profissional.removeIf(contato -> Objects.equals(contato.getNome(), nome));
        if (!flag)
            System.out.println("Não foi possível encontrar nenhum contato com o nome correspondente!");
    }

    public void listaContatos(int lista){
        if (lista == 1)
            for (Contato contato : familia) {
                System.out.println(contato.toString());
            }
        else if (lista == 2)
            for (Contato contato : amigos) {
                System.out.println(contato.toString());
            }
        else if (lista == 3)
            for (Contato contato : profissional) {
                System.out.println(contato.toString());
            }
    }

    public Contato maisVelho(int lista){
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        if (lista == 1)
            contatos = familia;
        else if (lista == 2)
            contatos = amigos;
        else if (lista == 3)
            contatos = profissional;

        Contato max = new Contato();
        max.setIdade(0);
        for (Contato contato : contatos) {
            if (contato.getIdade() > max.getIdade())
                max = contato;
        }

        return max;
    }

    public Contato maisNovo(int lista){
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        if (lista == 1)
            contatos = familia;
        else if (lista == 2)
            contatos = amigos;
        else if (lista == 3)
            contatos = profissional;

        Contato min = new Contato();
        int count = 0;
        for (Contato contato : contatos) {
            if (count == 0) {
                min = contato;
                count++;
                continue;
            }
            if (contato.getIdade() < min.getIdade()) {
                min = contato;
            }
            count++;
        }

        return min;
    }

public void salvaContatos() throws IOException {
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("contatosFamilia"));
            StringBuilder texto = new StringBuilder("CONTATOS -------------+\n");
            for (Contato contato: familia) {
                texto.append(contato.toString()).append("\n");
            }
            texto.append("+-------------+");
            escritor.write(texto.toString());
            escritor.flush();
            escritor.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("contatosAmigos"));
            StringBuilder texto = new StringBuilder("CONTATOS -------------+\n");
            for (Contato contato: amigos) {
                texto.append(contato.toString()).append("\n");
            }
            texto.append("+-------------+");
            escritor.write(texto.toString());
            escritor.flush();
            escritor.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("contatosProfissional"));
            StringBuilder texto = new StringBuilder("CONTATOS -------------+\n");
            for (Contato contato: profissional) {
                texto.append(contato.toString()).append("\n");
            }
            texto.append("+-------------+");
            escritor.write(texto.toString());
            escritor.flush();
            escritor.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void salvaContatosBin(){
        FileOutputStream escritorArquivo = null;
        ObjectOutputStream escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("contatosFamiliaBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Contato contato : familia)
                escritorObj.writeObject(contato);
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

        escritorArquivo = null;
        escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("contatosAmigosBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Contato contato : amigos)
                escritorObj.writeObject(contato);
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

        escritorArquivo = null;
        escritorObj = null;
        try{
            escritorArquivo =new FileOutputStream("contatosProfissionalBin");
            escritorObj = new ObjectOutputStream(escritorArquivo);
            for (Contato contato : profissional)
                escritorObj.writeObject(contato);
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

    @Override
    public String toString() {
        return "GestaoContatos{" +
                "familia=" + familia +
                ", amigos=" + amigos +
                ", profissional=" + profissional +
                '}';
    }
}
