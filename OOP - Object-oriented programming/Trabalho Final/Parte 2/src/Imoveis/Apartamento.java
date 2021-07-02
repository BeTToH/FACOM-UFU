package Imoveis;

import pessoas.ClienteProprietario;
import pessoas.Endereco;

import java.util.ArrayList;
import java.util.Date;

public class Apartamento extends Moradia {
    private int andar;
    private float valorCondominio;
    private boolean portaria24h;

    public Apartamento(boolean disponivel, boolean paraVenda, byte status, Date dataConstrucao, Date dataRegistro, float valor, float valorImobiliaria, Endereco endereco, int area, ArrayList<ClienteProprietario> proprietarios, int numQuartos, int numSuites, int numSalaEstar, int numSalaJantar, int numVagasGaragem, int numArmEmbutido, String descricao, boolean condominio, int andar, float valorCondominio, boolean portaria24h) {
        super(disponivel, paraVenda, status, dataConstrucao, dataRegistro, valor, valorImobiliaria, endereco, area, proprietarios, numQuartos, numSuites, numSalaEstar, numSalaJantar, numVagasGaragem, numArmEmbutido, descricao, condominio);
        setAndar(andar);
        setValorCondominio(valorCondominio);
        setPortaria24h(portaria24h);
    }

    public int getAndar() {
        return andar;
    }
    public void setAndar(int andar) {
        this.andar = andar;
    }

    public float getValorCondominio() {
        return valorCondominio;
    }
    public void setValorCondominio(float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public boolean isPortaria24h() {
        return portaria24h;
    }
    public void setPortaria24h(boolean portaria24h) {
        this.portaria24h = portaria24h;
    }

    @Override
    public int calculaIndiceVendaLocacao() {
        return 0;
    }
}
