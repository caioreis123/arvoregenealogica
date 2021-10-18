package arvoregenealogica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ArvoreGenealogicaGUI extends JFrame{
    private JPanel mainPanel;
    private JComboBox<Pessoa> familiaresComboBox;
    private JLabel familiaresLabel;
    private JLabel filhoLabel;
    private JCheckBox femininoCheckBox;
    private JCheckBox masculinoCheckBox;
    private JButton button;
    private JTextPane textPane;
    private JTextField filhoTexto;

    public ArvoreGenealogicaGUI(String title){
//        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        Filho joao = new Filho("João");
        familiaresComboBox.addItem(joao);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Pessoa pai = (Pessoa) familiaresComboBox.getSelectedItem();
                String nomeDescendente = filhoTexto.getText();
                if (femininoCheckBox.isSelected()){
                    Filha filha = new Filha(nomeDescendente);
                    pai.cadastrarFilho(filha);
                    familiaresComboBox.addItem(filha);
                }
                if (masculinoCheckBox.isSelected()){
                    Filho filho = new Filho(nomeDescendente);
                    pai.cadastrarFilho(filho);
                    familiaresComboBox.addItem(filho);
                }
                System.out.println("ascendentes antes: " + pai.ascendentes);

            }
        });

        familiaresComboBox.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Pessoa pessoaSelecionada = (Pessoa) familiaresComboBox.getSelectedItem();
                System.out.println("pessoaSelecionada : " + pessoaSelecionada);
                System.out.println("ascendentes : " + pessoaSelecionada.ascendentes);
                System.out.println("descendentes : " + pessoaSelecionada.descendentes);
                textPane.setText(pessoaSelecionada.toString());
                for (int index=pessoaSelecionada.ascendentes.size()-1; index >= 0; index--){
                    System.out.println("index"+ index);
                    Pessoa pessoaAtual = pessoaSelecionada.ascendentes.get(index);
                    textPane.setText(textPane.getText()+"\n"+pessoaAtual.toString());
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new ArvoreGenealogicaGUI("Arvore Genealogica");
        frame.setVisible(true);
    }
}

