package br.com.poo.balancotrimestral;

import java.text.DecimalFormat;

public class BalancoTrimestral {

	public static void main(String[] args)
	{
		Gastos janeiro = new GastosJaneiro();
		Gastos fevereiro = new GastosFevereiro();
		Gastos marco = new GastosMarco();
		
		janeiro.setGastosMes(15000);
		fevereiro.setGastosMes(23000);
		marco.setGastosMes(17000);
		
		double somar = janeiro.getGastosMes() + fevereiro.getGastosMes() + marco.getGastosMes();
		
		DecimalFormat format = new DecimalFormat("#,###.00");
		String gastos = format.format(somar);
					
		System.out.println("A soma dos gastos trimestrais são de R$"+gastos);
		
	}
}
