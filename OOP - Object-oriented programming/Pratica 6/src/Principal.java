import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qntdeFunc = 2;
        System.out.println("Defina o valor do salário base:");
        Funcionario.setSalarioBase(Float.parseFloat(sc.nextLine()));

        System.out.println("Defina o valor adicional para trabalho noturno:");
        FuncionarioNoturno.setValorAdicional(Float.parseFloat(sc.nextLine()));

        Funcionario[] vetFunc = new Funcionario[qntdeFunc];

        for (int i = 0; i < qntdeFunc; i++) {
            boolean flag = true;
            System.out.println("---------------------------------------------");
            System.out.println("Informe sobre o Funcionario " + i + ":");

            System.out.println("Nome:");
            String nome = sc.nextLine();
            System.out.println("CPF:");
            String cpf = sc.nextLine();
            System.out.println("Sexo (M ou F):");
            char sexo = sc.nextLine().toCharArray()[0];
            System.out.println("Idade:");
            int idade = Integer.parseInt(sc.nextLine());

            while(flag) {
                System.out.println("Selecione o tipo do funcionário:");
                System.out.println("1 - Funcionário Comissionado\n2 - Funcionário Noturno");

                int tipo = Integer.parseInt(sc.nextLine());
                if (tipo == 1) {
                    System.out.println("Valor Comissões:");
                    float valorComissoes = Float.parseFloat(sc.nextLine());
                    vetFunc[i] = new FuncionarioComissionado(nome, cpf, sexo, idade, valorComissoes);
                    flag = false;
                } else if (tipo == 2) {
                    System.out.println("Noites Trabalhadas:");
                    int noitesTrabalhadas = Integer.parseInt(sc.nextLine());
                    vetFunc[i] = new FuncionarioNoturno(nome, cpf, sexo, idade, noitesTrabalhadas);
                    flag = false;
                }
            }
        }

        for(int i = 0; i < qntdeFunc; i ++){
            System.out.println(vetFunc[i].toString());
        }

        String menu = """
                Selecione uma opção:
                    1 - Obter Salário mensal;
                    2 - Obter todas informações sobre o funcionário;
                    3 - Adicionar comissão ou horas noturnas trabalhadas
                    4 - Sair
                """;

        boolean flag = true;
        while(flag) {
            System.out.println(menu);
            int option = Integer.parseInt(sc.nextLine());
            if(option == 4){
                flag = false;
            } else {
                System.out.println("Selecione o funcionário pelo seu index:");
                int index = Integer.parseInt(sc.nextLine());
                if(option == 1){
                    System.out.println(vetFunc[index].getSalarioMensal());
                } else if (option == 2){
                    System.out.println(vetFunc[index].toString());
                } else if (option == 3) {
                    if(vetFunc[index] instanceof FuncionarioComissionado) {
                        System.out.println("Defina o valor da comissão a ser adicionado:");
                        float valor = Float.parseFloat(sc.nextLine());
                        ((FuncionarioComissionado) vetFunc[index]).addComissao(valor);
                    } else {
                        System.out.println("Informe o numero de noites trabalhadas a serem adicionadas:");
                        int qntde = Integer.parseInt(sc.nextLine());
                        ((FuncionarioNoturno) vetFunc[index]).addNoitesTrabalhadas(qntde);
                    }
                }
            }
        }
    }
}
