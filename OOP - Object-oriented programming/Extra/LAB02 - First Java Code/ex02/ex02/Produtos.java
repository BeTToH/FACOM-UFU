class Produto {
    private int codigo;
    private String nome, fabricante;
    private float preco;

    public Produto(int codigoNovo, String nomeNovo, String fabricNovo, float precoNovo){
        codigo = codigoNovo;
        nome = nomeNovo;
        fabricante = fabricNovo;
        preco = precoNovo;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public float getPreco() {
        return preco;
    }
    public void setCodigo(int codigo) {
        codigo = codigoNovo;
    }
    public void setNome(String nome) {
        nome = nomeNovo;
    }
    public void setFabricante(String fabricante) {
        fabricante = fabricNovo;
    }
    public void setPreco(float preco) {
        preco = precoNovo;
    }
}