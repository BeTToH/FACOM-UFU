package pessoas;

import Imoveis.Imovel;

import java.util.Date;

public class Transacao {
    private Date dataTransacao;
    private String metodoPagamento;
    private float valor;
    private Cliente usuario;
    private Imovel imovel;
    private Corretor corretor;
    private final String nroContrato;
    private static int qntContratosTotal;

    public Transacao(Cliente usuario, Imovel imovel){
        setImovel(imovel);
        setUsuario(usuario);
        this.nroContrato = Integer.toString(qntContratosTotal);
        qntContratosTotal++;
    }

    public Transacao(Date dataTransacao, String metodoPagamento, Cliente usuario, Imovel imovel, Corretor corretor, float valor) {
        setDataTransacao(dataTransacao);
        setMetodoPagamento(metodoPagamento);
        setImovel(imovel);
        setUsuario(usuario);
        setCorretor(corretor);
        setValor(valor);
        this.nroContrato = Integer.toString(qntContratosTotal);
        qntContratosTotal++;
    }

    public void setValor(float valor) { this.valor = valor; }

    public float getValor() { return valor; }

    public Corretor getCorretor() { return corretor; }

    public void setCorretor(Corretor corretor) { this.corretor = corretor; }

    public Cliente getUsuario() { return usuario; }

    public void setUsuario(Cliente usuario) { this.usuario = usuario; }

    public Imovel getImovel() { return imovel; }

    public void setImovel(Imovel imovel) { this.imovel = imovel; }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getNroContrato() {
        return nroContrato;
    }

    public boolean efetuarTransacao(){
        corretor.adicionaVendaMes(getValor());
        imovel.setStatus((byte) 3);
        setDataTransacao(new Date());
        return true;
    }
}
