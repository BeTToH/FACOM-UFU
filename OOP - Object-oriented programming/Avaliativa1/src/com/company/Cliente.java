package com.company;

public class Cliente {
    protected float saldo, saldoAplicacao;
    protected String cpf;

    // Construtores
    public Cliente(String cpf){
        this.saldo = 0;
        this.saldoAplicacao = 0;
        setCpf(cpf);
    }
    public Cliente(float saldo, String cpf) {
        this(cpf); // pq isso ta dando erro?
        deposito(saldo);
    }

    // getters
    public String getCpf() { return cpf; }
    public float getSaldo() { return saldo; }
    public float getSaldoAplicacao() { return saldoAplicacao; }

    // setters
    public boolean setCpf(String cpf) {
        if (ValidaCPF.isCPF(cpf)){
            this.cpf = cpf;
            return true;
        }
        return false;
    }

    public boolean deposito(float valor) {
        if(valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean saque(float valor) {
        if(saldo - (valor * 1.05) >= 0) {
            this.saldo -= (valor * 1.05);
            return true;
        }
        return false;
    }

    // Transferir saldo da conta para saldo da aplicação
    public boolean aplicar(float valorAAplicar) {
        if (valorAAplicar >= 1000 && valorAAplicar <= this.saldo){
            this.saldo -= valorAAplicar;
            this.saldoAplicacao += valorAAplicar;
            return true;
        }
        return false;
    }

    public boolean retirarAplicacao(float valorARetirar){
        if(this.saldoAplicacao >= valorARetirar){
            this.saldo += valorARetirar;
            this.saldoAplicacao -= valorARetirar;
            return true;
        }
        return false;
    }
}

