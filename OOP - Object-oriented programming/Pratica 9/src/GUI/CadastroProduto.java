package GUI;

import DADOS.ProdutosDAO;
import NEGOCIOS.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProduto{
    public CadastroProduto(ProdutosDAO produtos){
        int textBoxWidth = 200;

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.setTitle("Cadastro Produto");
        frame.setSize(400,350);
        frame.add(panel);

        JLabel lNome = new JLabel("Nome: ");
        lNome.setBounds(10,20,50,25);
        JTextField tfNome = new JTextField(20);
        tfNome.setBounds(150,20,textBoxWidth,25);
        panel.add(lNome);
        panel.add(tfNome);


        JLabel lMarca = new JLabel("Marca: ");
        lMarca.setBounds(10,60,50,25);
        JTextField tfMarca = new JTextField(20);
        tfMarca.setBounds(150,60,textBoxWidth,25);
        panel.add(lMarca);
        panel.add(tfMarca);


        JLabel lModelo = new JLabel("Modelo: ");
        lModelo.setBounds(10,100,70,25);
        JTextField tfModelo = new JTextField(20);
        tfModelo.setBounds(150,100,textBoxWidth,25);
        panel.add(lModelo);
        panel.add(tfModelo);

        JLabel lPreco = new JLabel("Preço: ");
        lPreco.setBounds(10,140,150,25);
        JTextField tfPreco = new JTextField(20);
        tfPreco.setBounds(150,140,textBoxWidth,25);
        panel.add(lPreco);
        panel.add(tfPreco);

        JButton btnSubmit = new JButton("Cadastrar");
        btnSubmit.setBounds(100,220,200,30);
        panel.add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produto prod = new Produto(tfNome.getText(), tfModelo.getText(), tfMarca.getText(), Float.parseFloat(tfPreco.getText()));
                    produtos.adicionar(prod);
                    produtos.salvaDados();
                    JOptionPane.showMessageDialog(frame, "Produto cadastrado com sucesso!");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Insira um valor válido para o preço!\nEx.: 12.99", "Atenção!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        frame.setVisible(true);
    }
}


