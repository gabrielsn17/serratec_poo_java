package br.com.poo.dao;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

import br.com.poo.vo.MenuClienteVO;

public class SaqueContaCorrenteDAO {

	public static void Saque(String cpfsenha, String agencia, double valor, String cargo, String tipoconta,
			double saldo) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");

		Conexao con = new Conexao();
		String sql = "update funcionario f set saldo=saldo-" + valor + " where cpfsenha=" + "'" + cpfsenha + "'"
				+ "and agencia=" + "'" + agencia + "'" + ";";
		int res = con.excutaSql(sql);

		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Saque de " + df.format(valor) + " feito com sucesso");
			Tributação(cpfsenha, agencia, valor, cargo, tipoconta);

		} else {
			System.out.println("Erro durante o cadastro saque");
		}

	}

	public static void Tributação(String cpfsenha, String agencia, double valor, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		double tributo = 0.10;
		String relatorio = "Tributo do Saque de " + df.format(valor) + " na Conta Corrente realizado na agência "
				+ agencia + " em " + gre.getTime();

		String sql = "insert into tributacao(cpfsenha,relatorio,tributo)" + "values (" + "'" + cpfsenha + "'" + ",'"
				+ relatorio + "'" + ",'" + tributo + "')";
		int res = con.excutaSql(sql);

		if (res > 0) {

			Relatorio(cpfsenha, agencia, valor, cargo, tipoconta);

		} else {
			System.out.println("Erro durante o cadastro tributa");
		}

	}

	public static void Relatorio(String cpfsenha, String agencia, double valor, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String descricao = "Saque de " + df.format(valor) + " na Conta Corrente realizado na agência " + agencia
				+ " Em " + gre.getTime();

		String sql = "insert into relatorio(cpfsenha,descricao,agencia)" + "values (" + "'" + cpfsenha + "'" + ",'"
				+ descricao + "'" + ",'" + agencia + "')";
		int res = con.excutaSql(sql);

		if (res > 0) {

			MenuClienteVO.MenuClienteC(cpfsenha, agencia);

		} else {
			System.out.println("Erro durante o cadastro relatorio");
		}
	}

}