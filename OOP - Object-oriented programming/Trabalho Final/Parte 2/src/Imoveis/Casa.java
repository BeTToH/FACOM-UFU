package Imoveis;

import pessoas.ClienteProprietario;
import pessoas.Endereco;

import java.util.ArrayList;
import java.util.Date;

public class Casa extends Moradia{
    private int numPiscinas;

    public Casa(boolean disponivel, boolean paraVenda, byte status, Date dataConstrucao, Date dataRegistro, float valor, float valorImobiliaria, Endereco endereco, int area, ArrayList<ClienteProprietario> proprietarios, int numQuartos, int numSuites, int numSalaEstar, int numSalaJantar, int numVagasGaragem, int numArmEmbutido, String descricao, boolean condominio, boolean condominio1, int numPiscinas) {
        super(disponivel, paraVenda, status, dataConstrucao, dataRegistro, valor, valorImobiliaria, endereco, area, proprietarios, numQuartos, numSuites, numSalaEstar, numSalaJantar, numVagasGaragem, numArmEmbutido, descricao, condominio);

        setNumPiscinas(numPiscinas);
    }

    public int getNumPiscinas() {
        return numPiscinas;
    }
    public void setNumPiscinas(int numPiscinas) {
        this.numPiscinas = numPiscinas;
    }

    @Override
    public int calculaIndiceVendaLocacao() {
        return 0;
    }
}
