package GUI;

import DADOS.*;
import NEGOCIOS.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    public MenuPrincipal(){
        ClientesDAO clientes = new ClientesDAO();
        AlunosDAO alunos = new AlunosDAO();
        ProdutosDAO prods = new ProdutosDAO();

        int col1 = 10;
        int col2 = 310;
        int rowHeight = 70;

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JOptionPane.showMessageDialog(frame, "Caso os botões não apareçam, passe o mouse sobre a tela", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

        frame.setSize(330,330);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Trabalho Final POO");
        frame.setVisible(true);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(null);

        JLabel label = new JLabel("Cadastros");
        label.setBounds(10,0,290,60);
        panel.add(label);

        JButton btnCadastroCliente = new JButton("Cadastrar Cliente");
        btnCadastroCliente.setBounds(col1,rowHeight,290,60);
        panel.add(btnCadastroCliente);
        btnCadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroCliente tlCadastroCliente = new CadastroCliente(clientes);
            }
        });

        JButton btnCadastroAluno = new JButton("Cadastrar Aluno");
        btnCadastroAluno.setBounds(col1,rowHeight*2,290,60);
        panel.add(btnCadastroAluno);
        btnCadastroAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroAluno ca = new CadastroAluno(alunos);
            }
        });

        JButton btnCadastroProduto = new JButton("Cadastrar Produto");
        btnCadastroProduto.setBounds(col1,rowHeight*3,290,60);
        panel.add(btnCadastroProduto);
        btnCadastroProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroProduto tlCadastroProduto = new CadastroProduto(prods);
            }
        });
    }

}

