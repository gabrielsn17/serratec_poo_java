package br.com.poo.dao;


import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

import br.com.poo.vo.MenuClienteVO;

public class DepositoPoupanca {

	public static void Deposito(String cpfsenha, String agencia,double valord,String cargo,String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		Conexao con = new Conexao();
		String sql = "update funcionario f set poupanca=poupanca+"+valord+" where cpfsenha=" + "'" + cpfsenha + "'" + "and agencia=" + "'"
				+ agencia + "'" + ";";
		int res = con.excutaSql(sql);
		
		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Deposito de "+df.format(valord)+" em conta Poupança feito com sucesso");
			Relatorio(cpfsenha, agencia, valord, cargo, tipoconta);
			MenuClienteVO.MenuClienteP(cpfsenha, agencia);	
		} else {
			System.out.println("Erro durante o cadastro");
		}

	}
	public static void Relatorio(String cpfsenha, String agencia, double valord, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String descricao="Depósito de " +df.format(valord)+" na Poupança realizado na agência "+agencia+" em "+gre.getTime();
		
		String sql = "insert into relatorio(cpfsenha,descricao,agencia)"
				+ "values ("+"'"+cpfsenha+"'"+",'"+descricao+"'"+",'"+agencia+"')"; 
		int res = con.excutaSql(sql);

		if (res > 0) {
			
			
		} else {
			System.out.println("Erro durante o cadastro");
		}
	}

}