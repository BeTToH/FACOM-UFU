package Imoveis;

import pessoas.ClienteProprietario;
import pessoas.Endereco;

import java.util.ArrayList;
import java.util.Date;

public abstract class Moradia extends Imovel{
    private int numQuartos, numSuites, numSalaEstar, numSalaJantar, numVagasGaragem, numArmEmbutido;
    private String descricao;
    private boolean condominio;



    public Moradia(boolean disponivel, boolean paraVenda, byte status, Date dataConstrucao, Date dataRegistro, float valor, float valorImobiliaria, Endereco endereco, int area, ArrayList<ClienteProprietario> proprietarios, int numQuartos, int numSuites, int numSalaEstar, int numSalaJantar, int numVagasGaragem, int numArmEmbutido, String descricao, boolean condominio) {
        super(disponivel, paraVenda, status, dataConstrucao, dataRegistro, valor, valorImobiliaria, endereco, area, proprietarios);
        setNumQuartos(numQuartos);
        setNumSuites(numSuites);
        setNumSalaEstar(numSalaEstar);
        setNumSalaJantar(numSalaJantar);
        setNumVagasGaragem(numVagasGaragem);
        setNumArmEmbutido(numArmEmbutido);
        setDescricao(descricao);
        setCondominio(condominio);
    }
    public boolean isCondominio() {
        return condominio;
    }
    public void setCondominio(boolean condominio) {
        this.condominio = condominio;
    }

    public int getNumQuartos() {
        return numQuartos;
    }
    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    public int getNumSuites() {
        return numSuites;
    }
    public void setNumSuites(int numSuites) {
        this.numSuites = numSuites;
    }

    public int getNumSalaEstar() {
        return numSalaEstar;
    }
    public void setNumSalaEstar(int numSalaEstar) {
        this.numSalaEstar = numSalaEstar;
    }

    public int getNumSalaJantar() {
        return numSalaJantar;
    }
    public void setNumSalaJantar(int numSalaJantar) {
        this.numSalaJantar = numSalaJantar;
    }

    public int getNumVagasGaragem() {
        return numVagasGaragem;
    }
    public void setNumVagasGaragem(int numVagasGaragem) {
        this.numVagasGaragem = numVagasGaragem;
    }

    public int getNumArmEmbutido() {
        return numArmEmbutido;
    }
    public void setNumArmEmbutido(int numArmEmbutido) {
        this.numArmEmbutido = numArmEmbutido;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
