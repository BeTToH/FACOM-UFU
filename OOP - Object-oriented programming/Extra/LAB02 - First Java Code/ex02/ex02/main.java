class Cadastro {
    public static void main (String args[])
    {
        // PRODUTOS
        Produto p1 = new Produto(293851, "Whisky", "Jack Daniels", 999.99);
        int codigo;
        String nome, fabricante;
        float preco;

        // Mostrando dados dos produtos
        codigo = p1.getCodigo();
        System.out.println(codigo);
        nome = p1.getNome();
        System.out.println(nome);
        fabricante = p1.getFabricante();
        System.out.println(fabricante);
        preco = p1.getPreco();
        System.out.println(preco);

        // Alterando dados dos produtos e mostrando depois
        p1.setCodigo(337788);
        codigo = p1.getCodigo();
        System.out.println(codigo);

        p1.setNome("Vodka");
        nome = p1.getNome();
        System.out.println(nome);

        p1.setFabricante("Smirnoff");
        fabricante = p1.getFabricante();
        System.out.println(fabricante);

        p1.setPreco(100.00);
        preco = p1.getPreco();
        System.out.println(preco);

        //-------------------------------------------------------------------------------------------------------
        // CLIENTES
        Cliente c1 = new Cliente("394.806.530-60", "Cláudio Danilo Rodrigo da Silva", "01/01/1952", "73754-308");
        String cpf, nome, cep;
        String dataDeNascimento;

        // Mostrando dados das pessoas
        cpf = c1.getCpf();
        System.out.println(cpf);
        nome = c1.getNome();
        System.out.println(nome);
        dataDeNascimento = c1.getDataDeNascimento();
        System.out.println(dataDeNascimento);
        cep = c1.getCep();
        System.out.println(cep);

        // Alterando dados dos clientes e mostrando depois
        c1.setCpf("894.167.019-55");
        cpf = c1.getCpf();
        System.out.println(cpf);

        c1.setNome("Lucca Danilo Giovanni Moreira");
        nome = c1.getNome();
        System.out.println(nome);

        c1.setDataDeNascimento("02/01/1959");
        dataDeNascimento = c1.getDataDeNascimento();
        System.out.println(dataDeNascimento);

        c1.setCep("53360-100");
        cep = c1.getCep();
        System.out.println(cep);

        //----------------------------------------------------------------------------------------------------//
        // FUNCIONÁRIOS
        Funcionario f1 = new Funcionario("704.225.802-95", "Marcela Andreia Dias", "08/01/1998", "19/08/2019");
        String cpf, nome;
        String dataDeNascimento, dataDeIngresso;

        // Mostrando dados das pessoas
        cpf = f1.getCpf();
        System.out.println(cpf);
        nome = f1.getNome();
        System.out.println(nome);
        dataDeNascimento = f1.getDataDeNascimento();
        System.out.println(dataDeNascimento);
        dataDeIngresso = f1.getDataDeIngresso();
        System.out.println(dataDeIngresso);

        // Alterando dados dos funcionários e mostrando depois
        f1.setCpf("443.600.268-38");
        cpf = f1.getCpf();
        System.out.println(cpf);

        f1.setNome("Bruna Hadassa Luzia Gonçalves");
        nome = f1.getNome();
        System.out.println(nome);

        f1.setDataDeNascimento("11/12/1989");
        dataDeNascimento = c1.getDataDeNascimento();
        System.out.println(dataDeNascimento);

        f1.setDataDeIngresso("14/02/2011");
        dataDeIngresso = f1.getDataDeIngresso();
        System.out.println(dataDeIngresso);
    }
}