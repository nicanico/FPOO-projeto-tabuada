package br.senai.sp.jandira.gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Tabuada;

public class Frame {
	
	public String titulo;
	public int largura;
	public int altura;
	
	public Color amarelo = new Color (255, 215, 0);
	public Color azul = new Color (5, 79, 119);
	public Color verde = new Color (0, 128, 0);
	public Color vermelho = new Color (255, 105, 97);
	public Color corPainel = new Color(255, 255, 255);
	public Color corFonte = new Color (220, 220, 220);
	public Font tituloFont = new Font("Arial", Font.BOLD, 15);
	public Font labelFont = new Font("Arial", Font.ITALIC, 15);
	public Font labelDescription = new Font("Arial", Font.ITALIC, 12);
	public Font labelComponentes = new Font("Arial", Font.ITALIC, 17);

	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		
		Container painel = tela.getContentPane();
		painel.setBackground(corPainel);
		
		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon("src/img/calculator.png"));
		imagem.setBounds(10, 20, 100, 30);
		
		
		JLabel labelTitulo = new JLabel();
		labelTitulo.setText("Tabuada 1.0");
		labelTitulo.setFont(tituloFont);
		labelTitulo.setForeground(vermelho);
		labelTitulo.setBounds(50, 10, 100, 30);
		
		JLabel labelDescricao = new JLabel();
		labelDescricao.setText("Precisa calcular? Utilize agora a Tabuada 1.0 e não tenha mais problemas!");
		labelDescricao.setFont(labelDescription);
		labelDescricao.setForeground(corFonte);
		labelDescricao.setBounds(50, 30, 500, 30);
		
		JLabel labelMultiplicador = new JLabel();
		labelMultiplicador.setText("Multiplicador:");
		labelMultiplicador.setFont(labelComponentes);
		labelMultiplicador.setBounds(98, 110, 100, 30);
		
		JTextField textFildMultiplicador = new JTextField();
		textFildMultiplicador.setBounds(200, 110, 150, 30);
		
		JLabel labelMultiplicadorMaximo = new JLabel();
		labelMultiplicadorMaximo.setText("Multiplicador Maximo:");
		labelMultiplicadorMaximo.setFont(labelComponentes);
		labelMultiplicadorMaximo.setBounds(34, 190, 190, 30);
		
		JTextField textFildMutiplicadorMaximo = new JTextField();
		textFildMutiplicadorMaximo.setBounds(200, 190, 150, 30);
		
		JLabel labelMultiplicadorMinimo = new JLabel();
		labelMultiplicadorMinimo.setText("Multiplicador Minimo:");
		labelMultiplicadorMinimo.setFont(labelComponentes);
		labelMultiplicadorMinimo.setBounds(34, 150, 190, 30);
		
		JTextField textFildMutiplicadorMinimo = new JTextField();
		textFildMutiplicadorMinimo.setBounds(200, 150, 150, 30);
		
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setFont(tituloFont);
		buttonCalcular.setBackground(amarelo);
		buttonCalcular.setBounds(250, 240, 150, 30);
		
		JButton buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setFont(tituloFont);
		buttonLimpar.setBackground(verde);
		buttonLimpar.setBounds(70, 240, 150, 30);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(40, 290, 380, 260);
		JList listagem = new JList();
		listagem.setForeground(azul);
		
		painel.add(imagem);
		painel.add(labelTitulo);
		painel.add(labelDescricao);
		painel.add(labelMultiplicador);
		painel.add(textFildMultiplicador);
		painel.add(labelMultiplicadorMaximo);
		painel.add(textFildMutiplicadorMaximo);
		painel.add(labelMultiplicadorMinimo);
		painel.add(textFildMutiplicadorMinimo);
		painel.add(buttonCalcular);
		painel.add(buttonLimpar);
		painel.add(scroll);
		painel.add(listagem);
		
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textFildMultiplicador.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Multiplicador é obrigatorio!", "Erro!" , JOptionPane.OK_OPTION);
					textFildMultiplicador.requestFocus();	
				
				}else if(textFildMutiplicadorMinimo.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Mínimo é obrigatorio!", "Erro!" , JOptionPane.OK_OPTION);
					textFildMutiplicadorMinimo.requestFocus();
				
				}else if(textFildMutiplicadorMaximo.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Maxímo é obrigatorio!", "Erro!" , JOptionPane.OK_OPTION);
					textFildMutiplicadorMaximo.requestFocus();
				} else {
					Tabuada tabuada = new Tabuada();
					tabuada.entrada = Integer.parseInt(textFildMultiplicador.getText());
					tabuada.multiplicadorMaximo = Integer.parseInt(textFildMutiplicadorMaximo.getText());
					tabuada.multiplicadorMinimo = Integer.parseInt(textFildMutiplicadorMinimo.getText());
				
					if(tabuada.multiplicadorMaximo < tabuada.multiplicadorMinimo) {
						JOptionPane.showMessageDialog(null, "O multiplicador mínimo é maior que o máximo, digitar valor menor.", "Erro!" , JOptionPane.OK_OPTION);
						textFildMutiplicadorMinimo.setText("");
						textFildMutiplicadorMaximo.setText("");
					}else{
						
						listagem.setListData(tabuada.getMultiply());
						scroll.getViewport().add(listagem);
						
					}
				}
				
				//teste de saida
				System.out.println("Saiu!!");
				
					
			}
		});
		
		buttonLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFildMultiplicador.setText("");
				textFildMutiplicadorMaximo.setText("");
				textFildMutiplicadorMinimo.setText("");
				
				String[] limpar = {""};
				listagem.setListData(limpar);
				
//				DefaultListModel<String> model = new DefaultListModel<>();
//				listagem.setModel(model);
				
				
			}
		});
		
		tela.setVisible(true);
	}
}