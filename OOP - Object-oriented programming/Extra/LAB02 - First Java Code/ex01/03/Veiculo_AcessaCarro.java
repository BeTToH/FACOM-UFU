class Veiculo {
    private String marca;
    private String placa;
    private int quilometragem;

    public Veiculo(String m, String p, int km){
        marca = m;
        placa = p;
        quilometragem = km;
    }
    public String getMarca() {
        return marca;
    }
    public String getPlaca() {
        return placa;
    }
    public int getQuilometragem() {
        return quilometragem;
    }
    public void setQuilometragem(int km) {
        quilometragem = km;
    }
}

class AcessaCarro {
    public static void main (String args[])
    {
        Veiculo meuCarro = new Veiculo("Porsche", "XYZ-777", 50000);
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