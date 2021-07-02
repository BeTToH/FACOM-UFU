package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan;
        scan = new Scanner(System.in);

        GestaoContatos gestao = new GestaoContatos();

        String menu = """
                1 - Sair
                2 - Adicionar Contato
                3 - Excluir Contato
                4 - Listar Contatos
                5 - Obter contato mais novo
                6 - Obter contato mais velho
                7 - Salvar contatos
                8 - Salvar contatos arquivo binário
                """;

        String listas = "1 - Familia\n2 - Amigos\n3 - Profissional";

        boolean flag = true;
        while(flag){
            System.out.println(menu);
            String option = scan.nextLine();
            int opt = Integer.parseInt(option);
            if(opt == 1)
                flag = false;
            else if (opt == 2){
                System.out.println("Insira as informações do contato:");

                System.out.println("Nome: ");
                String nome = scan.nextLine();
                System.out.println("Idade: ");
                String idade = scan.nextLine();
                System.out.println("Sexo: ");
                String sexo = scan.nextLine();
                System.out.println("Profissao: ");
                String profissao  = scan.nextLine();
                System.out.println("Telefone: ");
                String telefone  = scan.nextLine();
                System.out.println("E-mail: ");
                String email  = scan.nextLine();

                Contato novoContato = new Contato(nome, Integer.parseInt(idade), sexo, profissao, telefone, email);

                System.out.println("Em qual lista deseja inserir o contato?");
                System.out.println(listas);
                String lista  = scan.nextLine();

                gestao.adicionaContato(novoContato, Integer.parseInt(lista));
            } else if (opt == 3) {
                System.out.println("Insira o nome do contato que deseja remover:");
                String nome = scan.nextLine();

                gestao.eliminaContato(nome);
            } else if(opt == 4){
                System.out.println("Qual lista voce deseja ver?");
                System.out.println(listas);
                String lista = scan.nextLine();

                gestao.listaContatos(Integer.parseInt(lista));
            } else if (opt == 5){
                System.out.println("Em qual lista deseja fazer a busca?");
                System.out.println(listas);
                String lista  = scan.nextLine();

                Contato contato = gestao.maisNovo(Integer.parseInt(lista));
                System.out.println(contato.toString());
            } else if (opt == 6){
                System.out.println("Em qual lista deseja fazer a busca?");
                System.out.println(listas);
                String lista  = scan.nextLine();

                Contato contato = gestao.maisVelho(Integer.parseInt(lista));
                System.out.println(contato.toString());
            } else if (opt == 7) {
                gestao.salvaContatos();
            } else if (opt == 8) {
                gestao.salvaContatosBin();
            }
        }
    }
}
