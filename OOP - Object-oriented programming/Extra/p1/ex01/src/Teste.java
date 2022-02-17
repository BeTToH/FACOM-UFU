import java.util.Scanner;

class Teste {
    public static void main(String[] args) {
        Scanner scan;
        scan = new Scanner(System.in);

        //(a)	Peça para o usuário informar os pontos que definem
        //    o retângulo e mostre a área do mesmo.
        System.out.println("Questão a)");
        System.out.println("Informe os pontos que definem o retângulo:");
        System.out.println("Ponto 1:");
        System.out.println("Coordenada X:");
        int x = Integer.parseInt(scan.nextLine());

        System.out.println("Coordenada Y:");
        int y = Integer.parseInt(scan.nextLine());

        Ponto pontoUmA = new Ponto(x, y);

        System.out.println("Ponto 2:");
        System.out.println("Coordenada X:");
        x = Integer.parseInt(scan.nextLine());

        System.out.println("Coordenada Y:");
        y = Integer.parseInt(scan.nextLine());

        Ponto pontoDoisA = new Ponto(x, y);

        Retangulo ret = new Retangulo(pontoUmA, pontoDoisA);

        System.out.printf("A area do retangulo é: %.3f\n\n", ret.calculaArea());


//        (b)	Crie um programa que leia as informações de n retângulos
//        e ao final mostre todas as informações lidas e indique
//        o retângulo de maior área

        System.out.println("Questão b)");
        System.out.println("Quantos retângulos deseja informar?");
        int n = Integer.parseInt(scan.nextLine());

        Retangulo[] listaRetangulos = new Retangulo[n];
        for (int i = 0; i < n; i++){
            listaRetangulos[i] = new Retangulo();
            Ponto pontoUm = new Ponto();

            System.out.println("---------------------------------------------");
            System.out.println("Informe sobre o Retângulo " + i+1 + ":");

            System.out.println("Ponto 1:");
            System.out.println("Coordenada X:");
            pontoUm.setX(Integer.parseInt(scan.nextLine()));

            System.out.println("Coordenada Y:");
            pontoUm.setY(Integer.parseInt(scan.nextLine()));

            listaRetangulos[i].setPontoUm(pontoUm);

            Ponto pontoDois = new Ponto();
            System.out.println("Ponto 2:");
            System.out.println("Coordenada X:");
            pontoDois.setX(Integer.parseInt(scan.nextLine()));

            System.out.println("Coordenada Y:");
            pontoDois.setY(Integer.parseInt(scan.nextLine()));

            listaRetangulos[i].setPontoDois(pontoDois);
        }

        int indexRetMaiorArea = 0;
        double maiorArea = 0;

        for (int i = 0; i < n; i++){
            if (listaRetangulos[i].calculaArea() > maiorArea) {
                maiorArea = listaRetangulos[i].calculaArea();
                indexRetMaiorArea = i;
            }

            System.out.printf("%s\n", listaRetangulos[i]);
        }

        System.out.printf("O retângulo com maior área é o %s, com área de aprox. %.3f unidades.", listaRetangulos[indexRetMaiorArea], listaRetangulos[indexRetMaiorArea].calculaArea());

    }
}