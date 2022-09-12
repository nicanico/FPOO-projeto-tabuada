package br.senai.sp.jandira.model;

public class Tabuada {
	
	public int entrada;
	public int multiplicadorMaximo;
	public int multiplicadorMinimo;
	
	public String[] getMultiply() {
			
		int tamanho = multiplicadorMaximo - multiplicadorMinimo + 1;
		String tabuada[] =  new String [tamanho];
			
			int i = 0;
			while (multiplicadorMinimo <= multiplicadorMaximo) {
			int produto = entrada * multiplicadorMinimo;
			
			String resultado = entrada + "x" + multiplicadorMinimo + "=" + produto;
			tabuada[i] = resultado;
			
			i++;
			multiplicadorMinimo++;
			}
			
			return tabuada;
			
		}
	
}