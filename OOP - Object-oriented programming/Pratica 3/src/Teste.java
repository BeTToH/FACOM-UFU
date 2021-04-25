class Teste {
    public static void main(String[] args) {
        Ponto um = new Ponto();

        um.criaPonto(3.5, 3.4);

        Ponto dois = new Ponto();

        dois.criaPonto(2.3, 7.8);

        System.out.println(um.calculaDistancia(dois));
    }
}
