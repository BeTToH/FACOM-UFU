package GUI;

import DADOS.ClientesDAO;
import NEGOCIOS.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CadastroCliente{
    private static JTextField tfNome,tfCelular,tfEmail,tfProfissao;
    private static JRadioButton rbMulher;
    private static JComboBox cbEstadoCivil;

    public CadastroCliente(ClientesDAO clientes){
        int textBoxWidth = 200;

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.setTitle("Cadastro Cliente");
        frame.setSize(400,400);
        frame.add(panel);

        JLabel lNome = new JLabel("Nome: ");
        lNome.setBounds(10,20,50,25);
        tfNome = new JTextField(20);
        tfNome.setBounds(150,20,textBoxWidth,25);
        panel.add(lNome);
        panel.add(tfNome);


        JLabel lEmail = new JLabel("Email: ");
        lEmail.setBounds(10,60,50,25);
        tfEmail = new JTextField(20);
        tfEmail.setBounds(150,60,textBoxWidth,25);
        panel.add(lEmail);
        panel.add(tfEmail);


        JLabel lCelular = new JLabel("Celular: ");
        lCelular.setBounds(10,100,70,25);
        tfCelular = new JTextField(20);
        tfCelular.setBounds(150,100,textBoxWidth,25);
        panel.add(lCelular);
        panel.add(tfCelular);

        JLabel lProfissao = new JLabel("Profissão: ");
        lProfissao.setBounds(10,140,150,25);
        tfProfissao = new JTextField(20);
        tfProfissao.setBounds(150,140,textBoxWidth,25);
        panel.add(lProfissao);
        panel.add(tfProfissao);

        // Create Radio buttons
        ButtonGroup bgMulher = new ButtonGroup();
        JRadioButton rbHomem = new JRadioButton("Homem", true);
        rbHomem.setBounds(10,180,80,25);
        rbMulher = new JRadioButton("Mulher", false);
        rbMulher.setBounds(100,180,80,25);
        bgMulher.add(rbMulher);
        bgMulher.add(rbHomem);

        panel.add(rbHomem);
        panel.add(rbMulher);

        String[] estCivil = {"Solteiro(a)", "Casado(a)", "Separado(a)", "Viúvo(a)", "Outro"};
        cbEstadoCivil = new JComboBox(estCivil);
        cbEstadoCivil.setBounds(210,180,150,25);
        panel.add(cbEstadoCivil);

        JButton btnSubmit = new JButton("Cadastrar");
        btnSubmit.setBounds(100,280,200,30);
        panel.add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente c = new Cliente(tfNome.getText(), tfCelular.getText(), tfEmail.getText(), Objects.requireNonNull(cbEstadoCivil.getSelectedItem()).toString(), rbMulher.isSelected(), tfProfissao.getText());
                clientes.adicionar(c);
                clientes.salvaDados();
                JOptionPane.showMessageDialog(frame,"Cliente cadastrado com sucesso!");
                frame.dispose();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        frame.setVisible(true);
    }
}

