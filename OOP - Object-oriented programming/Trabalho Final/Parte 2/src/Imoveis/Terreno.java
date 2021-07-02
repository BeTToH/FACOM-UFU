package Imoveis;

import pessoas.ClienteProprietario;
import pessoas.Endereco;

import java.util.ArrayList;
import java.util.Date;

public class Terreno extends Imovel{
    private boolean possuiAclive;

    public Terreno(boolean disponivel, boolean paraVenda, byte status, Date dataConstrucao, Date dataRegistro, float valor, float valorImobiliaria, Endereco endereco, int area, ArrayList<ClienteProprietario> proprietarios, boolean possuiAclive) {
        super(disponivel, paraVenda, status, dataConstrucao, dataRegistro, valor, valorImobiliaria, endereco, area, proprietarios);
        setPossuiAclive(possuiAclive);
    }

    public boolean possuiAclive() {
        return possuiAclive;
    }
    public void setPossuiAclive(boolean possuiAclive) {
        this.possuiAclive = possuiAclive;
    }

    @Override
    public int calculaIndiceVendaLocacao() {
        return 0;
    }
}
