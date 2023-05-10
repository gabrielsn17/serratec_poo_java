package br.com.poo.dao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

public class AlterarTipoConta {

	public static void CheckConta(String cfpsenha) {

		String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário:");
		Object[] escolha = { "Corrente", "Poupança" };
		Object opcao = JOptionPane.showInputDialog(null, "Qual o tipo de conta que deseja adicionar?",
				"Adicionar conta", JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpf=" + "'" + cpf + "'" + ";";
		ResultSet rs = con.executaBusca(sql);

		try {
			while (rs.next()) {

				String tipoconta = rs.getString("tipoconta");

				if (selecao.equalsIgnoreCase("Corrente") && (tipoconta.equalsIgnoreCase("Corrente"))) {
					JOptionPane.showMessageDialog(null, "Você já possui uma conta corrente!");
				}  
				if (selecao.equalsIgnoreCase("Poupança") && (tipoconta.equalsIgnoreCase("Poupanca"))) {
					JOptionPane.showMessageDialog(null, "Você já possui uma conta Poupança!");
				} 
				else if (selecao.equalsIgnoreCase("Poupança") && (tipoconta.equalsIgnoreCase("corrente"))) {
					AlterarTipoConta.adcionarPoupanca(cpf);

				} 
				else if (selecao.equalsIgnoreCase("Corrente") && (tipoconta.equalsIgnoreCase("poupanca"))) {
					AlterarTipoConta.adcionarCorrente(cpf);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void adcionarCorrente(String cpf) {

		String valorst = JOptionPane.showInputDialog("Deposite um valor mínimo de R$100,00");
		double valor = Double.parseDouble(valorst);

		Conexao con = new Conexao();

		String sql = "update funcionario f set tipoconta='ambos'" + ",saldo=" + "'" + valor + "'" + " where cpf=" + "'"
				+ cpf + "'" + ";";

		int res = con.excutaSql(sql);

		if (res > 0) {

			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");

		} else {
			System.out.println("Erro durante a alteração de conta");
		}
	}

	public static void adcionarPoupanca(String cpf) {

		String valorst = JOptionPane.showInputDialog("Deposite um valor mínimo de R$50,00");
		double valor = Double.parseDouble(valorst);

		Conexao con = new Conexao();

		String sql = "update funcionario f set tipoconta='ambos'" + ",poupanca=" + "'" + valor + "'" + " where cpf="
				+ "'" + cpf + "'" + ";";

		int res = con.excutaSql(sql);

		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");

		} else {
			System.out.println("Erro durante a alteração de conta");
		}
	}
}
