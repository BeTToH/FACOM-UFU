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