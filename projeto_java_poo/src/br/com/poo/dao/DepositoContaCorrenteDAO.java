package br.com.poo.dao;


import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

import br.com.poo.vo.MenuClienteVO;


public class DepositoContaCorrenteDAO {

	public static void Deposito(String cpfsenha, String agencia, double valord, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");


		Conexao con = new Conexao();
		String sql = "update funcionario f set saldo=saldo+" + valord + " where cpfsenha=" + "'" + cpfsenha + "'"
				+ "and agencia=" + "'" + agencia + "'" + ";";
		int res = con.excutaSql(sql);

		if (res > 0) {
			JOptionPane.showMessageDialog(null,
					"Deposito de " + df.format(valord) + " em conta Corrente feito com sucesso");
			Tributação(cpfsenha,agencia,valord,cargo,tipoconta);
			MenuClienteVO.MenuClienteC(cpfsenha, agencia);

		} else {
			System.out.println("Erro durante o cadastro");
		}
	}
	
	
	public static void Tributação(String cpfsenha, String agencia, double valord, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		double tributo=0.10;
		String relatorio="Tributo do Deposito de " +df.format(valord)+" na Conta Corrente realizado na agência "+agencia+" em "+gre.getTime();
		
		String sql = "insert into tributacao(cpfsenha,relatorio,tributo)"
				+ "values ("+"'"+cpfsenha+"'"+",'"+relatorio+"'"+",'"+tributo+"')"; 
		int res = con.excutaSql(sql);

		if (res > 0) {
			
			Relatorio(cpfsenha, agencia, valord, cargo, tipoconta);
			
			
			
		} else {
			System.out.println("Erro durante o cadastro");
		}
		
		
	}
	
	
	
	
	

	public static void Relatorio(String cpfsenha, String agencia, double valord, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String descricao="Depósito de " +df.format(valord)+" na Conta Corrente realizado na agência "+agencia+" em "+gre.getTime();
		
		String sql = "insert into relatorio(cpfsenha,descricao,agencia)"
				+ "values ("+"'"+cpfsenha+"'"+",'"+descricao+"'"+",'"+agencia+"')"; 
		int res = con.excutaSql(sql);

		if (res > 0) {
			
			
		} else {
			System.out.println("Erro durante o cadastro");
		}
	}
	
	
	

}
