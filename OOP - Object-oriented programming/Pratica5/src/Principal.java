import javax.swing.text.html.parser.Parser;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner scan;
        scan = new Scanner(System.in);

        Vendedor[] vendedores = new Vendedor[5];
        Administrativo[] admins = new Administrativo[5];

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Insira a seguir os dados dos vendedores:");
        System.out.println("------------------------");
        for (int i = 0; i < vendedores.length; i++){
            vendedores[i] = new Vendedor();
            System.out.println("\nVendedor " + (i+1) + ":");

            System.out.println("Nome: ");
            vendedores[i].setNome(scan.nextLine());

            System.out.println("RG: ");
            vendedores[i].setRG(scan.nextLine());

            System.out.println("Telefone: ");
            vendedores[i].setTelefone(scan.nextLine());

            System.out.println("Salario base: ");
            vendedores[i].setSalarioBase(Double.parseDouble(scan.nextLine()));

            System.out.println("\n------------------------");
        }

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("Insira a seguir os dados dos Administrativos:");
        System.out.println("------------------------");
        for (int i = 0; i < admins.length; i++){
            admins[i] = new Administrativo();
            System.out.println("\nAdministrativo " + (i+1) + ":");

            System.out.println("Nome: ");
            admins[i].setNome(scan.nextLine());

            System.out.println("RG: ");
            admins[i].setRG(scan.nextLine());

            System.out.println("Telefone: ");
            admins[i].setTelefone(scan.nextLine());

            System.out.println("Salario base:");
            admins[i].setSalarioBase(Double.parseDouble(scan.nextLine()));

            System.out.println("\n------------------------");
        }

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("Descreva o q foi feito pelos funcionários " + vendedores[0].getNome() + " e " + admins[0].getNome() + " durante um período de 5 dias:");
        System.out.println("------------------------");
        for (int i = 1; i < 6; i++){
            System.out.println("\nDia" + i + ":");

            System.out.println("Valor das vendas realizadas pelo " + vendedores[0].getNome() + ":");
            vendedores[0].acrescentaVendas(scan.nextDouble());

            System.out.println("Horas extras trabalhadas pelo " + admins[0].getNome() + ":");
            admins[0].acrescentaHorasExtras(scan.nextInt());

            System.out.println("\n------------------------");
        }

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("Ficha completa dos funcionários " + vendedores[0].getNome() + " e " + admins[0].getNome() + " contando apenas os 5 dias de trabalho anteriormente preenchidos:");

        System.out.println("\n----------------------\n");

        System.out.println(vendedores[0].getNome() + ": \nTelefone: " + vendedores[0].getTelefone() + "\tRG: " + vendedores[0].getRG() +
                "\tSalario Base: R$" + vendedores[0].getSalarioBase() +
                "\nSalário Total: R$" + vendedores[0].getSalarioTotal() + "\t Valor das Vendas: " + vendedores[0].getTotalVendas());

        System.out.println("\n----------------------\n");

        System.out.println(admins[0].getNome() + ": \nTelefone: " + admins[0].getTelefone() + "\tRG: " + admins[0].getRG() +
                "\tSalario Base: R$ " + admins[0].getSalarioBase() +
                "\nSalário Total: R$" + admins[0].getSalarioTotal() + "\t Horas Extras Trabalhadas: " + admins[0].getHorasExtras());

        System.out.println("\n----------------------");
        System.out.println("\n--------------------------------------------------------------------------------------");
    }
}
