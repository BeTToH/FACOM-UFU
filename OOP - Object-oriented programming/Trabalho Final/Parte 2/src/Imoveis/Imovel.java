package Imoveis;

import pessoas.ClienteProprietario;
import pessoas.Endereco;

import java.util.ArrayList;
import java.util.Date;

public abstract class Imovel {
    private boolean disponivel, paraVenda;
    private Date dataConstrucao, dataRegistro;
    private float valor, valorImobiliaria, area;
    private Endereco endereco;
    private byte status; // 1 - Ativo, 2 - Inativo, 3 - Em uso
    private ArrayList<ClienteProprietario> proprietarios;

    // CONSTRUTORES
    public Imovel(){ }

    public Imovel(ArrayList<ClienteProprietario> proprietarios){
        setProprietarios(proprietarios);
    }

    public Imovel(boolean disponivel, boolean paraVenda, byte status, Date dataConstrucao, Date dataRegistro, float valor, float valorImobiliaria, Endereco endereco, float area, ArrayList<ClienteProprietario> proprietarios) {
        setDisponivel(disponivel);
        setParaVenda(paraVenda);
        setStatus(status);
        setDataConstrucao(dataConstrucao);
        setDataRegistro(dataRegistro);
        setValor(valor);
        setValorImobiliaria(valorImobiliaria);
        setEndereco(endereco);
        setArea(area);
        setProprietarios(proprietarios);
    }

    // GETTERS AND SETTERS
    public ArrayList<ClienteProprietario> getProprietarios() { return proprietarios; }

    public void setProprietarios(ArrayList<ClienteProprietario> proprietarios) { this.proprietarios = proprietarios; }

    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isParaVenda() {
        return paraVenda;
    }
    public void setParaVenda(boolean paraVenda) {
        this.paraVenda = paraVenda;
    }

    public byte getStatus() {
        return status;
    }
    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getDataConstrucao() {
        return dataConstrucao;
    }
    public void setDataConstrucao(Date dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValorImobiliaria() {
        return valorImobiliaria;
    }
    public void setValorImobiliaria(float valorImobiliaria) {
        this.valorImobiliaria = valorImobiliaria;
    }

    public float calculaValorFinal(){
        return this.valor + this.valorImobiliaria;
    }

    public abstract int calculaIndiceVendaLocacao();
}
