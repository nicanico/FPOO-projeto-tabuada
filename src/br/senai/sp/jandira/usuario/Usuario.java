package br.senai.sp.jandira.usuario;
import br.senai.sp.jandira.gui.Frame;
import br.senai.sp.jandira.model.*;

public class Usuario {
	
public static void main(String[] args) {
	
		Frame tela = new Frame();
		tela.titulo = "Tabuada";
		tela.altura = 600;
		tela.largura = 500;
		tela.criarTela();
		
		Tabuada tab = new Tabuada();
		tab.entrada = 8;
		tab.multiplicadorMinimo = 4;
		tab.multiplicadorMaximo = 36;
		
		String [] resultado = tab.getMultiply();
		int i = 0;
		
		while (i < resultado.length) {
			System.out.println(resultado[i]);
			i++;
		}

	}

}