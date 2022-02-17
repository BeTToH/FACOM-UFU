class AcessaCarro {
    public static void main(String args[])
    {
        Veiculo meuCarro = new Veiculo ("Porsche", "XYZ-777", 50000);
        String marca;
        int quilometragem;
        marca = meuCarro.getMarca();
        System.out.println(marca);
        quilometragem = meuCarro.getQuilometragem();
        System.out.println(quilometragem);
        meuCarro.setQuilometragem(100000);
        quilometragem = meuCarro.getQuilometragem();
        System.out.println(quilometragem);
    }
}